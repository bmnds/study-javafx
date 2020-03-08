package com.bmnds.bootfx.login;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;

import com.bmnds.bootfx.view.OpenViewEvent;
import com.bmnds.bootfx.view.ViewEnum;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

@Controller
public class LoginController {

	@FXML
	private TextField fldUser;
	@FXML
	private PasswordField fldPassword;
	@FXML
	private Button btnLogin;

	private LoginService service;

	private ApplicationEventPublisher publisher;

	private MessageSource messageSource;

	@Autowired
	public LoginController(LoginService service,
			ApplicationEventPublisher publisher,
			MessageSource messageSource) {
		this.service = service;
		this.publisher = publisher;
		this.messageSource = messageSource;
	}

	@FXML
	public void initialize() {
	}

	public void doLogin(Event event) {
		String user = fldUser.getText();
		String password = fldPassword.getText();

		// TODO audit
		if (service.isLoginSuccessful(user, password)) {
			publisher.publishEvent(new OpenViewEvent(ViewEnum.HOME_VIEW));
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro");
			alert.setHeaderText(messageSource
					.getMessage("login.btn.login.falha", null, Locale.getDefault()));
			alert.show();
		}
	}

}
