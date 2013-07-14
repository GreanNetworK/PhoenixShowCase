package com.shipco.showcase.sample.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class ShowSampleMessageEvent extends GwtEvent<ShowSampleMessageEventHandler> {
	public static Type<ShowSampleMessageEventHandler> TYPE = new Type<ShowSampleMessageEventHandler>();

    private String message;

    public ShowSampleMessageEvent(String message) {
        this.message = message;
    }

    @Override
	public Type<ShowSampleMessageEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ShowSampleMessageEventHandler handler) {
		handler.onShowMessage(this);
	}

    public String getMessage() {
        return message;
    }
}
