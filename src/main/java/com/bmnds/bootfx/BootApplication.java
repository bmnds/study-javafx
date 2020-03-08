package com.bmnds.bootfx;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bmnds.bootfx.appfx.FxApplication;

import javafx.application.Application;

/**
 * Aplicação de estudo de JavaFX com Spring Boot. Como toda aplicação Spring
 * Boot, ela está anotada com @SpringBootApplication e implementa o método
 * {@link #main(String[])}.
 * 
 * A classe {@link javafx.application.Application} deve ser utilizada para
 * inicializar a UI.
 *
 * @author Bruno
 *
 */
@SpringBootApplication
public class BootApplication {

	public static void main(String[] args) {
		Application.launch(FxApplication.class, args);
	}

}
