package com.bmnds.bootfx.appfx;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.bmnds.bootfx.BootApplication;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

/**
 * 
 * Inicializa a UI da aplicação extendendo {@link Application}.
 * 
 * O contexto do Spring é inicializado no método {@link #init()} e encerado no
 * método {@link #stop()}.
 * 
 * Toda manipulação de UI deve ocorrer na JavaFX Application Thread. Nos métodos
 * {@link #start(Stage)} e {@link #stop()} essa thread é acessada para atualizar
 * o gráfico de cena.
 * 
 * @author Bruno
 *
 */
public final class FxApplication extends Application {

	private ConfigurableApplicationContext context;

	@Override
	public void init() throws Exception {
		String[] args = getParameters().getRaw().toArray(new String[0]);
		this.context = new SpringApplicationBuilder()
				.sources(BootApplication.class)
				.run(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		context.publishEvent(new FxStageReadyEvent(stage));
	}

	@Override
	public void stop() throws Exception {
		context.close();
		Platform.exit();
	}

}