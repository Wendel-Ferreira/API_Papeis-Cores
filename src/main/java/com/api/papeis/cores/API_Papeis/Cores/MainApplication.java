package com.api.papeis.cores.API_Papeis.Cores;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan(basePackages = "com.api.papeis.cores.API_Papeis.Cores.Model")
@EnableJpaRepositories(basePackages = "com.api.papeis.cores.API_Papeis.Cores.Repository")
public class MainApplication extends Application {
	@Autowired
	private static ConfigurableApplicationContext spring;

	public static void main(String[] args) {
		spring = SpringApplication.run(MainApplication.class, args);
		launch(args);
	}

	@Override
	public void init() throws Exception { //O Metodo especifica para o Spring que está classe é a principal.
	}

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/templates/View/PaginaInicial.fxml"));
		fxmlLoader.setControllerFactory(spring::getBean);

		Scene scene = new Scene(fxmlLoader.load());
		stage.setTitle("Aplicativo Desktop Papeis&Cores");
		stage.setScene(scene);
		stage.show();
	}
	@Override
	public void stop() {
		spring.close();
	}
}
