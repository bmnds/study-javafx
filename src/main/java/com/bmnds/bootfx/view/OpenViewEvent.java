package com.bmnds.bootfx.view;

import org.springframework.context.ApplicationEvent;

public class OpenViewEvent extends ApplicationEvent {
	private static final long serialVersionUID = 1L;

	public final ViewEnum view;

	public OpenViewEvent(ViewEnum view) {
		super(view);
		this.view = view;
	}

}
