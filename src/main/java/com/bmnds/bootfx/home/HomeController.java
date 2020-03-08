package com.bmnds.bootfx.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;

import com.bmnds.bootfx.view.OpenViewEvent;
import com.bmnds.bootfx.view.ViewEnum;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

@Controller
public class HomeController {

	@FXML
	private Button btnLogout;

	private ApplicationEventPublisher publisher;

	@Autowired
	public HomeController(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

	@FXML
	public void initialize() {
	}

	public void doLogout(Event event) {
		// TODO clean up
		publisher.publishEvent(new OpenViewEvent(ViewEnum.LOGIN_VIEW));
	}

}
