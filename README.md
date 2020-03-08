# bootfx
Personal project to study JavaFX and SpringBoot.

# requirements so far
* [x] weave JavaFX and SpringBoot initialization code
* [x] show a login screen when application starts
* [x] transition to home screen using events

Next steps:
* [ ] show a splash screen during start up
* [ ] style the application
* [ ] show some data in the home screen retrieved from an in-memory database
* [ ] generate an executable package for windows

# how to render a view?

* All rendering code is centered in *com.bmnds.bootfx.appfx.FxStageRenderer* class. 
* When the application starts, an event of type *com.bmnds.bootfx.appfx.FxStageReadyEvent* gets fired containing the main stage provided by JavaFX in *com.bmnds.bootfx.appfx.FxApplication#start* method. This stage is maintained in a static variable and *com.bmnds.bootfx.view.ViewEnum.LOGIN_VIEW* gets rendered as the first view.
* For every other view that should be rendered, an event of type *com.bmnds.bootfx.view.OpenViewEvent* should be fired containing an element of *com.bmnds.bootfx.view.ViewEnum*.
* For each view, there should be an FXML file associated with it. This file will be loaded by *com.bmnds.bootfx.appfx.FxStageRenderer#loadView* method.

# how to weave JavaFX and SpringBoot?

* The requirement for a Spring Boot project is to annotate the main class with @SpringBootApplication.
* The requirement for a JavaFX app is to extend *javafx.application.Application* and override its #init, #start and #stop methods.
* So, in order to weave both Spring Boot and JavaFX, we must:
   1. Call *javafx.application.Application#launch* inside Spring Boot main class;
   2. Initialize *org.springframework.context.ApplicationContext* inside JavaFX Application class.
* In this project, classes *com.bmnds.bootfx.BootApplication* and *com.bmnds.bootfx.appfx.FxApplication* are responsible for all this weaving code.


# technologies

### [Open JDK 13](https://openjdk.java.net/)
### [Java FX 13](https://openjfx.io/)
### [Scene Builder for JavaFX 11](https://gluonhq.com/products/scene-builder/)