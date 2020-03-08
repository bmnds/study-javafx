package com.bmnds.bootfx.appfx;

import org.springframework.context.ApplicationEvent;

import javafx.stage.Stage;

final class FxStageReadyEvent extends ApplicationEvent {
	private static final long serialVersionUID = 1L;

	public final Stage stage;

	public FxStageReadyEvent(Stage stage) {
		super(stage);
		this.stage = stage;
	}
}
