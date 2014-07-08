package com.mayhem.overlay;

public class Message implements rice.p2p.commonapi.Message {
	private static final long serialVersionUID = -537925666393304992L;
	private long messageId;
	private long sentTime;

	public Message() {
		messageId = new java.util.Random().nextLong();
		sentTime = System.currentTimeMillis();
	}

	public int getPriority() {
		return Message.LOW_PRIORITY;
	}

	public void execute(ClientApplication app) {

	}

	public long getMessageId() {
		return messageId;
	}
}
