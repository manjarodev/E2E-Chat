// Generated by view binder compiler. Do not edit!
package com.devbeans.io.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.view.PreviewView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.devbeans.io.chat.R;
import com.otaliastudios.cameraview.CameraView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityCameraBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  /**
   * This binding is not available in all configurations.
   * <p>
   * Present:
   * <ul>
   *   <li>layout-land/</li>
   * </ul>
   *
   * Absent:
   * <ul>
   *   <li>layout/</li>
   * </ul>
   */
  @Nullable
  public final CameraView camera;

  @NonNull
  public final ImageView cameraClicker;

  /**
   * This binding is not available in all configurations.
   * <p>
   * Present:
   * <ul>
   *   <li>layout-land/</li>
   * </ul>
   *
   * Absent:
   * <ul>
   *   <li>layout/</li>
   * </ul>
   */
  @Nullable
  public final FragmentContainerView cameraFragmentContainer;

  @NonNull
  public final RecyclerView cameraModeRecycler;

  @NonNull
  public final PreviewView cameraPreview;

  @NonNull
  public final ImageView cameraSwitch;

  @NonNull
  public final ImageView closeBtn;

  @NonNull
  public final ImageView flashToggle;

  /**
   * This binding is not available in all configurations.
   * <p>
   * Present:
   * <ul>
   *   <li>layout/</li>
   * </ul>
   *
   * Absent:
   * <ul>
   *   <li>layout-land/</li>
   * </ul>
   */
  @Nullable
  public final TextView recordTime;

  @NonNull
  public final ConstraintLayout root;

  @NonNull
  public final TextView tvSubsCamera;

  @NonNull
  public final ImageView videoClicker;

  private ActivityCameraBinding(@NonNull ConstraintLayout rootView, @Nullable CameraView camera,
      @NonNull ImageView cameraClicker, @Nullable FragmentContainerView cameraFragmentContainer,
      @NonNull RecyclerView cameraModeRecycler, @NonNull PreviewView cameraPreview,
      @NonNull ImageView cameraSwitch, @NonNull ImageView closeBtn, @NonNull ImageView flashToggle,
      @Nullable TextView recordTime, @NonNull ConstraintLayout root, @NonNull TextView tvSubsCamera,
      @NonNull ImageView videoClicker) {
    this.rootView = rootView;
    this.camera = camera;
    this.cameraClicker = cameraClicker;
    this.cameraFragmentContainer = cameraFragmentContainer;
    this.cameraModeRecycler = cameraModeRecycler;
    this.cameraPreview = cameraPreview;
    this.cameraSwitch = cameraSwitch;
    this.closeBtn = closeBtn;
    this.flashToggle = flashToggle;
    this.recordTime = recordTime;
    this.root = root;
    this.tvSubsCamera = tvSubsCamera;
    this.videoClicker = videoClicker;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityCameraBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityCameraBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_camera, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityCameraBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.camera;
      CameraView camera = ViewBindings.findChildViewById(rootView, id);

      id = R.id.camera_clicker;
      ImageView cameraClicker = ViewBindings.findChildViewById(rootView, id);
      if (cameraClicker == null) {
        break missingId;
      }

      id = R.id.camera_fragment_container;
      FragmentContainerView cameraFragmentContainer = ViewBindings.findChildViewById(rootView, id);

      id = R.id.camera_mode_recycler;
      RecyclerView cameraModeRecycler = ViewBindings.findChildViewById(rootView, id);
      if (cameraModeRecycler == null) {
        break missingId;
      }

      id = R.id.cameraPreview;
      PreviewView cameraPreview = ViewBindings.findChildViewById(rootView, id);
      if (cameraPreview == null) {
        break missingId;
      }

      id = R.id.camera_switch;
      ImageView cameraSwitch = ViewBindings.findChildViewById(rootView, id);
      if (cameraSwitch == null) {
        break missingId;
      }

      id = R.id.close_btn;
      ImageView closeBtn = ViewBindings.findChildViewById(rootView, id);
      if (closeBtn == null) {
        break missingId;
      }

      id = R.id.flash_toggle;
      ImageView flashToggle = ViewBindings.findChildViewById(rootView, id);
      if (flashToggle == null) {
        break missingId;
      }

      id = R.id.record_time;
      TextView recordTime = ViewBindings.findChildViewById(rootView, id);

      ConstraintLayout root = (ConstraintLayout) rootView;

      id = R.id.tvSubsCamera;
      TextView tvSubsCamera = ViewBindings.findChildViewById(rootView, id);
      if (tvSubsCamera == null) {
        break missingId;
      }

      id = R.id.video_clicker;
      ImageView videoClicker = ViewBindings.findChildViewById(rootView, id);
      if (videoClicker == null) {
        break missingId;
      }

      return new ActivityCameraBinding((ConstraintLayout) rootView, camera, cameraClicker,
          cameraFragmentContainer, cameraModeRecycler, cameraPreview, cameraSwitch, closeBtn,
          flashToggle, recordTime, root, tvSubsCamera, videoClicker);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
