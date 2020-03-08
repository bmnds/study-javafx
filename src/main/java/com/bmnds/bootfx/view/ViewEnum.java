package com.bmnds.bootfx.view;

public enum ViewEnum {

	LOGIN_VIEW("/views/login.fxml"), 
	HOME_VIEW("/views/home.fxml");

	public final String fxml;

	private ViewEnum(String fxml) {
		this.fxml = fxml;
	}

}
