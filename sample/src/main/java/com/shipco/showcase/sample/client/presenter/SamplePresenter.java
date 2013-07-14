package com.shipco.showcase.sample.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.shipco.showcase.sample.client.event.ShowSampleMessageEvent;

public class SamplePresenter implements Presenter {
	
	public interface Display{
		HasClickHandlers getShowButton();
		HasValue<String> getSampleTextbox();
		Widget asWidget();
	}
	
	private final HandlerManager eventBus;
	private final Display display;

	public SamplePresenter(HandlerManager eventBus, Display display) {
		this.eventBus = eventBus;
		this.display = display;
		bind();
	}

	private void bind() {
		display.getShowButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
                String message = display.getSampleTextbox().getValue();
			    eventBus.fireEvent(new ShowSampleMessageEvent(message));
			}
		});		
	}

	@Override
	public void go(final HasWidgets container) {
		container.clear();
		container.add(display.asWidget());		
	}

}
