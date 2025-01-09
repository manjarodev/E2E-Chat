package com.devbeans.io.chat.utils;

import com.devbeans.io.chat.callBacks.ListenableFuture;

import java.util.concurrent.ExecutionException;

public final class DeleteCanceledVoiceNoteListener implements ListenableFuture.Listener<VoiceNoteDraft> {
    @Override
    public void onSuccess(final VoiceNoteDraft result) {

        // was essential to over ride

    }

    @Override
    public void onFailure(ExecutionException e) {
        // was essential to over ride
    }
}