package com.example.assignment1.gui;

import com.example.assignment1.logic.Operations;
import com.example.assignment1.data.Polynomial;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CalculatorController {

    private static CalculatorView calculatorView;
    private static Operations operations;

    public CalculatorController(CalculatorView calcView, Operations op) {
        calculatorView = calcView;
        operations = op;
    }

    public static EventHandler<ActionEvent> addition = actionEvent -> {
        Polynomial p1 = new Polynomial(calculatorView.getPol1().getText());
        Polynomial p2 = new Polynomial(calculatorView.getPol2().getText());
        calculatorView.setResult(operations.addition(p1, p2).toString());
    };

    public static EventHandler<ActionEvent> subtraction = actionEvent -> {
        Polynomial p1 = new Polynomial(calculatorView.getPol1().getText());
        Polynomial p2 = new Polynomial(calculatorView.getPol2().getText());
        calculatorView.setResult(operations.subtraction(p1, p2).toString());
    };

    public static EventHandler<ActionEvent> multiplication = actionEvent -> {
        Polynomial p1 = new Polynomial(calculatorView.getPol1().getText());
        Polynomial p2 = new Polynomial(calculatorView.getPol2().getText());
        calculatorView.setResult(operations.multiplication(p1, p2).toString());
    };

    public static EventHandler<ActionEvent> division = actionEvent -> {
        Polynomial p1 = new Polynomial(calculatorView.getPol1().getText());
        Polynomial p2 = new Polynomial(calculatorView.getPol2().getText());
        String result = operations.division(p1, p2);
        String[] splitResult = result.split("\\s+");
        Polynomial pr1 = new Polynomial(splitResult[0]);
        Polynomial pr2 = new Polynomial(splitResult[1]);
        calculatorView.setResult("Q: " + pr1 + " R: " + pr2);
    };
    public static EventHandler<ActionEvent> derivative = actionEvent -> {
        Polynomial p1 = new Polynomial(calculatorView.getPol1().getText());
        calculatorView.setResult(operations.derivative(p1).toString());
    };

    public static EventHandler<ActionEvent> integral = actionEvent -> {
        Polynomial p1 = new Polynomial(calculatorView.getPol1().getText());
        calculatorView.setResult(operations.integral(p1).toString());
    };
}