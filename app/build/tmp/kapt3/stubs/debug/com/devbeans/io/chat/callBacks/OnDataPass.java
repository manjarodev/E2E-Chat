package com.devbeans.io.chat.callBacks;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H&\u00a8\u0006\u000b"}, d2 = {"Lcom/devbeans/io/chat/callBacks/OnDataPass;", "", "onDataPass", "", "isDurationEdited", "", "totalDurationUs", "", "startTimeUs", "endTimeUs", "viewOnce", "app_debug"})
public abstract interface OnDataPass {
    
    public abstract void onDataPass(boolean isDurationEdited, long totalDurationUs, long startTimeUs, long endTimeUs, boolean viewOnce);
}