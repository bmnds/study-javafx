package com.bmnds.bootfx.appfx;

import java.io.IOException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.event.EventListener;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.stereotype.Component;

import com.bmnds.bootfx.view.OpenViewEvent;
import com.bmnds.bootfx.view.ViewEnum;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * O {@link FxStageRenderer} é responsável por atualizar o gráfico de cena da
 * aplicação para cada view a ser renderizada.
 * 
 * Para que não sejam abertas múltiplas janelas, uma referência ao {@link Stage}
 * criado durante a inicialização da aplicação é mantida em uma vaiável estática.
 * 
 * NOTA*: é imprescindível que as atualizações sejam executadas dentro da JavaFX
 * Application Thread e, portanto, não deve ser utilizada a anotação @Async do
 * Spring em nenhum método anotado como @EventListener.
 * 
 * @author Bruno
 *
 */
@Component
final class FxStageRenderer {

	/**
	 * O mainStage representa a janela principal da aplicação.
	 * 
	 * Toda transição de tela que afete a janela principal será executada em
	 * duas etapas:<br>
	 * 1. {@link #loadView(ViewEnum)} para carregar o arquivo FXML;<br>
	 * 2. {@link #updateMainStage(Parent)} para atualizar o gráfico da cena
	 * principal.
	 */
	private static Stage mainStage;

	@Value("${application.screen.width}")
	private int width;

	@Value("${application.screen.height}")
	private int height;

	private ApplicationContext ctx;

	private MessageSource messageSource;

	public FxStageRenderer(ApplicationContext ctx,
			MessageSource messageSource) {
		super();
		this.ctx = ctx;
		this.messageSource = messageSource;
	}

	@EventListener
	public void onFxStageReadyEvent(FxStageReadyEvent event)
			throws IOException {
		mainStage = event.stage;
		mainStage.setTitle(messageSource
				.getMessage("application.title", null, Locale.getDefault()));

		Parent root = loadView(ViewEnum.LOGIN_VIEW);
		updateMainStage(root);
	}

	@EventListener
	public void onFxOpenViewEvent(OpenViewEvent event) throws IOException {
		Parent root = loadView(event.view);
		updateMainStage(root);
	}

	private Parent loadView(ViewEnum view) throws IOException {
		FXMLLoader loader = new FXMLLoader();

		// Enable Spring dependency injection for controllers defined in FXML
		loader.setControllerFactory(ctx::getBean);

		// Enable Spring to read messages from files using '%message' in FXML
		loader.setResources(new MessageSourceResourceBundle(
				ctx.getBean(MessageSource.class),
				Locale.getDefault()));

		// Load view from FXML file
		loader.setLocation(getClass().getResource(view.fxml));

		return loader.load();
	}

	private void updateMainStage(Parent root) {
		Scene scene = new Scene(root, width, height);

		mainStage.setScene(scene);
		mainStage.show();
	}

}
