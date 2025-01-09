package com.devbeans.io.chat.utils.editor;

public interface UndoRedoStackListener {

    void onAvailabilityChanged(boolean undoAvailable, boolean redoAvailable);
}
