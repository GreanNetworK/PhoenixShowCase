package com.shipco.showcase.sample.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SampleServiceAsync {
	public void getSampleMessage(AsyncCallback<String> message);
}
