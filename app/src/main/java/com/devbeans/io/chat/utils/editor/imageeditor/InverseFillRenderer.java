package com.devbeans.io.chat.utils.editor.imageeditor;

import android.graphics.Path;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

import com.devbeans.io.chat.utils.DimensionUnit;
import com.devbeans.io.chat.utils.Renderer;
import com.devbeans.io.chat.utils.RendererContext;
import com.devbeans.io.chat.utils.views.Bounds;



/**
 * Renders the {@link color} outside of the {@link com.devbeans.io.chat.utils.views.Bounds}.
 * <p>
 * Hit tests outside of the bounds.
 */
public final class InverseFillRenderer implements Renderer {

  private final int color;

  private final RectF dst  = new RectF();
  private final Path  path = new Path();

  @Override
  public void render(@NonNull RendererContext rendererContext) {
    rendererContext.canvas.save();

    rendererContext.mapRect(dst, Bounds.FULL_BOUNDS);
    rendererContext.canvasMatrix.setToIdentity();

    path.reset();
    path.addRoundRect(dst, DimensionUnit.DP.toPixels(18), DimensionUnit.DP.toPixels(18), Path.Direction.CW);

    rendererContext.canvas.clipPath(path);
    rendererContext.canvas.drawColor(color);
    rendererContext.canvas.restore();
  }

  public InverseFillRenderer(@ColorInt int color) {
    this.color = color;
    path.toggleInverseFillType();
  }

  private InverseFillRenderer(Parcel in) {
    this(in.readInt());
  }

  @Override
  public boolean hitTest(float x, float y) {
    return !Bounds.contains(x, y);
  }

  public static final Parcelable.Creator<InverseFillRenderer> CREATOR = new Parcelable.Creator<InverseFillRenderer>() {
    @Override
    public InverseFillRenderer createFromParcel(Parcel in) {
      return new InverseFillRenderer(in);
    }

    @Override
    public InverseFillRenderer[] newArray(int size) {
      return new InverseFillRenderer[size];
    }
  };

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(color);
  }
}
