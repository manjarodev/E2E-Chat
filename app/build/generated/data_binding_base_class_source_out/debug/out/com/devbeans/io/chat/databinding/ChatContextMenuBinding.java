// Generated by view binder compiler. Do not edit!
package com.devbeans.io.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.devbeans.io.chat.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class ChatContextMenuBinding implements ViewBinding {
  @NonNull
  private final RecyclerView rootView;

  @NonNull
  public final RecyclerView signalContextMenuList;

  private ChatContextMenuBinding(@NonNull RecyclerView rootView,
      @NonNull RecyclerView signalContextMenuList) {
    this.rootView = rootView;
    this.signalContextMenuList = signalContextMenuList;
  }

  @Override
  @NonNull
  public RecyclerView getRoot() {
    return rootView;
  }

  @NonNull
  public static ChatContextMenuBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ChatContextMenuBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.chat_context_menu, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ChatContextMenuBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    RecyclerView signalContextMenuList = (RecyclerView) rootView;

    return new ChatContextMenuBinding((RecyclerView) rootView, signalContextMenuList);
  }
}
