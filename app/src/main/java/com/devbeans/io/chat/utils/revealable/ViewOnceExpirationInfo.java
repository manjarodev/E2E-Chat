package com.devbeans.io.chat.utils.revealable;

public class ViewOnceExpirationInfo {

  private final String messageId;
  private final long receiveTime;

  public ViewOnceExpirationInfo(String messageId, long receiveTime) {
    this.messageId       = messageId;
    this.receiveTime     = receiveTime;
  }

  public String getMessageId() {
    return messageId;
  }

  public long getReceiveTime() {
    return receiveTime;
  }
}
