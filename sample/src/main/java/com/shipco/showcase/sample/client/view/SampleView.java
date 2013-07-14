package com.shipco.showcase.sample.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.shipco.showcase.sample.client.presenter.SamplePresenter;

public class SampleView extends Composite implements SamplePresenter.Display {

    public static final String TOKEN = "sampleview";
	
	private VerticalPanel verticalPanel;
	private Button showButton;
	private TextBox sampleTextbox;
	
	

	public SampleView() {
		verticalPanel = new VerticalPanel();
		sampleTextbox = new TextBox();
        showButton = new Button("Submit");

		verticalPanel.add(sampleTextbox);
        verticalPanel.add(showButton);

		initWidget(verticalPanel);
	}

	@Override
	public HasClickHandlers getShowButton() {
		return showButton;
	}

	@Override
	public HasValue<String> getSampleTextbox() {
		return sampleTextbox;
	}

	@Override
	public Widget asWidget() {
		return this;
	}

}
