package com.shipco.showcase.sample.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;
import com.shipco.showcase.sample.client.event.ShowSampleMessageEvent;
import com.shipco.showcase.sample.client.event.ShowSampleMessageEventHandler;
import com.shipco.showcase.sample.client.presenter.Presenter;
import com.shipco.showcase.sample.client.presenter.SamplePresenter;
import com.shipco.showcase.sample.client.view.SampleView;

public class AppController implements Presenter,ValueChangeHandler<String> {
	
	private SampleServiceAsync service;
	private HandlerManager eventBus;
	private HasWidgets container;

    private SampleView sampleView = null;

	public AppController(SampleServiceAsync service, HandlerManager eventBus) {
		this.service = service;
		this.eventBus = eventBus;
		bind();
	}

	private void bind() {
		History.addValueChangeHandler(this);
        eventBus.addHandler(ShowSampleMessageEvent.TYPE,
                new ShowSampleMessageEventHandler() {
                    @Override
                    public void onShowMessage(ShowSampleMessageEvent event) {
                        showSampleView(event.getMessage());
                    }
                });
	}

    private void showSampleView(String message){
        Window.alert(message);
        History.newItem(SampleView.TOKEN);
    }

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();
		if(token != null){
			if(token.equals(SampleView.TOKEN)){
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable throwable) {
                    }

                    @Override
                    public void onSuccess() {
                        if(sampleView == null){
                            sampleView = new SampleView();
                        }
                        new SamplePresenter(eventBus,sampleView).go(container);
                    }
                });
			}else{
                Window.alert("not found 404");
            }
		}
	}

	@Override
	public void go(HasWidgets container) {
		this.container = container;
		
		if("".equals(History.getToken())){
			History.newItem(SampleView.TOKEN);
		}else{
			History.fireCurrentHistoryState();
		}
		
	}

}
