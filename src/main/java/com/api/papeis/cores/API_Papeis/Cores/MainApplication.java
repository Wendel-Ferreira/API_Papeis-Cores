package com.api.papeis.cores.API_Papeis.Cores;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;


@SpringBootApplication
@EntityScan(basePackages = "com.api.papeis.cores.API_Papeis.Cores.Model")
@EnableJpaRepositories(basePackages = "com.api.papeis.cores.API_Papeis.Cores.Repository")
@ComponentScan(basePackages = {"com.api.papeis.cores.API_Papeis.Cores.Controller"})
public class MainApplication extends Application {

    @Getter
    private static Stage primaryStage;

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
        primaryStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/templates/View/PaginaInicial.fxml"));
        fxmlLoader.setControllerFactory(spring::getBean);

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Aplicativo Desktop Papeis&Cores");
        stage.setScene(scene);
        stage.show();
    }

    public static void trocaCena(String fxmlPath) throws Exception { //Chamar esse metodo quando trocar de cena no palco
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(fxmlPath));
        fxmlLoader.setControllerFactory(spring::getBean);
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setScene(scene);
    }

    @Override
    public void stop() {
        spring.close();
    }
}
