package com.example.assignment1.gui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorView {
    private final Button Add;
    private final Button Sub;
    private final Button Mul;
    private final Button Div;
    private final Button Der;
    private final Button Int;
    private final TextField pol1;
    private final TextField pol2;
    private final TextField result;
    private final Label p1;
    private final Label p2;
    private final Label r;

    public Button getAdd() {
        return Add;
    }

    public Button getSub() {
        return Sub;
    }

    public Button getMul() {
        return Mul;
    }

    public Button getDiv() {
        return Div;
    }

    public Button getDer() {
        return Der;
    }

    public Button getInt() {
        return Int;
    }

    public TextField getPol1() {
        return pol1;
    }

    public TextField getPol2() {
        return pol2;
    }

    public TextField getResult() {
        return result;
    }

    public void setResult(String result){
        this.result.setText(result);
    }

    public Label getP1() {
        return p1;
    }

    public Label getP2() {
        return p2;
    }

    public Label getR() {
        return r;
    }

    public CalculatorView(){
        Add = new Button();
        Add.setText("Addition");
        Add.setLayoutX(40);
        Add.setLayoutY(320);
        Add.setPrefWidth(100);
        Add.setOnAction(CalculatorController.addition);

        Sub = new Button();
        Sub.setText("Subtraction");
        Sub.setLayoutX(190);
        Sub.setLayoutY(320);
        Sub.setPrefWidth(100);
        Sub.setOnAction(CalculatorController.subtraction);

        Mul = new Button();
        Mul.setText("Multiplication");
        Mul.setLayoutX(340);
        Mul.setLayoutY(320);
        Mul.setPrefWidth(100);
        Mul.setOnAction(CalculatorController.multiplication);

        Div = new Button();
        Div.setText("Division");
        Div.setLayoutX(40);
        Div.setLayoutY(370);
        Div.setPrefWidth(100);
        Div.setOnAction(CalculatorController.division);

        Der = new Button();
        Der.setText("Derivative");
        Der.setLayoutX(190);
        Der.setLayoutY(370);
        Der.setPrefWidth(100);
        Der.setOnAction(CalculatorController.derivative);

        Int = new Button();
        Int.setText("Integral");
        Int.setLayoutX(340);
        Int.setLayoutY(370);
        Int.setPrefWidth(100);
        Int.setOnAction(CalculatorController.integral);

        pol1 = new TextField("0.00");
        pol1.setLayoutX(40);
        pol1.setLayoutY(50);
        pol1.setPrefWidth(400);

        pol2 = new TextField("0.00");
        pol2.setLayoutX(40);
        pol2.setLayoutY(100);
        pol2.setPrefWidth(400);

        result = new TextField("0.00");
        result.setEditable(false);
        result.setLayoutX(40);
        result.setLayoutY(150);
        result.setPrefWidth(400);

        p1 = new Label("P1: ");
        p1.setLayoutX(20);
        p1.setLayoutY(53);

        p2 = new Label("P2: ");
        p2.setLayoutX(20);
        p2.setLayoutY(103);

        r = new Label("R: ");
        r.setLayoutX(20);
        r.setLayoutY(153);
    }
}
