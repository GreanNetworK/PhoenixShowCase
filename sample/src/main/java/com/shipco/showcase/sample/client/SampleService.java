package com.shipco.showcase.sample.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("sampleService")
public interface SampleService extends RemoteService {
	public String getSampleMessage();
}
