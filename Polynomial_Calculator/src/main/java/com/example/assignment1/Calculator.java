package com.example.assignment1;

import com.example.assignment1.data.Monomial;
import com.example.assignment1.gui.CalculatorController;
import com.example.assignment1.gui.CalculatorView;
import com.example.assignment1.logic.Operations;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class Calculator extends Application {
    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 480, 480);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.setResizable(false);

        CalculatorView view = new CalculatorView();
        Operations operations = new Operations();
        CalculatorController controller = new CalculatorController(view, operations);

        root.getChildren().addAll(view.getAdd(), view.getSub(), view.getMul(),
                view.getDiv(), view.getDer(), view.getInt(),  view.getPol1(),
                view.getPol2(), view.getResult(), view.getP1(), view.getP2(),
                view.getR());
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/calculator_icon.png")));
        stage.getIcons().add(icon);
        stage.show();
    }

    public static void main(String[] args){
        launch();
    }
}