package com.devbeans.io.chat.utils.editor.imageeditor;

import android.graphics.Matrix;
import android.graphics.PointF;

import androidx.annotation.NonNull;

import com.devbeans.io.chat.utils.views.EditorElement;


/*
 * Represents an underway edit of the image.
 * <p>
 * Accepts new touch positions, new touch points, released touch points and when complete can commit the edit.
 * <p>
 * Examples of edit session implementations are, Drag, Draw, Resize:
 * <p>
 * {@link org.signal.imageeditor.core.ElementDragEditSession} for dragging with a single finger.
 * {@link org.signal.imageeditor.core.ElementScaleEditSession} for resize/dragging with two fingers.
 * {@link org.signal.imageeditor.core.DrawingSession} for drawing with a single finger.
 */
public interface EditSession {

  void movePoint(int p, @NonNull PointF point);

  EditorElement getSelected();

  EditSession newPoint(@NonNull Matrix newInverse, @NonNull PointF point, int p);

  EditSession removePoint(@NonNull Matrix newInverse, int p);

  void commit();
}
