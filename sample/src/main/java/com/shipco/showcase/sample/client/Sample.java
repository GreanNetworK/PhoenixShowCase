package com.shipco.showcase.sample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;

public class Sample implements EntryPoint {

	@Override
	public void onModuleLoad() {
		SampleServiceAsync service = GWT.create(SampleService.class);
		HandlerManager eventBus = new HandlerManager(null);
		AppController appViewer = new AppController(service, eventBus);
		appViewer.go(RootPanel.get());	
	}

}
