package com.example.assignment1.logic;

import com.example.assignment1.data.Polynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationsTest {
    Operations operations = new Operations();
    @Test
    void additionTrue() {
        Polynomial p1 = new Polynomial("x^3-x-1");
        Polynomial p2 = new Polynomial("-x^2+2");
        Polynomial expectedP=new Polynomial("x^3-x^2-x+1");
        Polynomial resultP = operations.addition(p1,p2);

        assertEquals(expectedP.toString(),resultP.toString());
    }

    @Test
    void subtractionTrue() {
        Polynomial p1 = new Polynomial("x^3-x-1");
        Polynomial p2 = new Polynomial("-x^2+2");
        Polynomial expectedP=new Polynomial("x^3+x^2-x-3");
        Polynomial resultP = operations.subtraction(p1,p2);

        assertEquals(expectedP.toString(),resultP.toString());
    }

    @Test
    void multiplicationTrue() {
        Polynomial p1 = new Polynomial("x^3-x-1");
        Polynomial p2 = new Polynomial("-x^2+2");
        Polynomial expectedP=new Polynomial("-x^5+3x^3+x^2-2x-2");
        Polynomial resultP = operations.multiplication(p1,p2);

        assertEquals(expectedP.toString(),resultP.toString());
    }

    @Test
    void divisionTrue() {
        Polynomial p1 = new Polynomial("x^3");
        Polynomial p2 = new Polynomial("x^2-1");
        String expectedP=new String("x x");
        String resultP = new String(operations.division(p1,p2));

        assertEquals(expectedP, resultP);
    }

    @Test
    void derivativeTrue() {
        Polynomial p1 = new Polynomial("x^3-x-1");
        Polynomial expectedP=new Polynomial("3x^2-1");
        Polynomial resultP = operations.derivative(p1);

        assertEquals(expectedP.toString(),resultP.toString());
    }

    @Test
    void integralTrue() {
        Polynomial p1 = new Polynomial("x^3-x-1");
        Polynomial expectedP=new Polynomial("0.25x^4-0.5x^2-x");
        Polynomial resultP = operations.integral(p1);

        assertEquals(expectedP.toString(),resultP.toString());
    }

    @Test
    void additionFalse() {
        Polynomial p1 = new Polynomial("x^3-x-1");
        Polynomial p2 = new Polynomial("-x^2+2");
        Polynomial expectedP=new Polynomial("x^22");
        Polynomial resultP = operations.addition(p1,p2);

        assertNotEquals(expectedP.toString(),resultP.toString());

    }

    @Test
    void subtractionFalse() {
        Polynomial p1 = new Polynomial("x^3-x-1");
        Polynomial p2 = new Polynomial("-x^2+2");
        Polynomial expectedP=new Polynomial("-x^5");
        Polynomial resultP = operations.subtraction(p1,p2);

        assertNotEquals(expectedP.toString(),resultP.toString());
    }

    @Test
    void multiplicationFalse() {
        Polynomial p1 = new Polynomial("x^3-x-1");
        Polynomial p2 = new Polynomial("-x^2+2");
        Polynomial expectedP=new Polynomial("x-x^2");
        Polynomial resultP = operations.multiplication(p1,p2);

        assertNotEquals(expectedP.toString(),resultP.toString());
    }

    @Test
    void divisionFalse() {
        Polynomial p1 = new Polynomial("x^3");
        Polynomial p2 = new Polynomial("x^2-1");
        String expectedP=new String("x^8 x");
        String resultP = new String(operations.division(p1,p2));

        assertNotEquals(expectedP, operations.division(p1,p2));
    }

    @Test
    void derivativeFalse() {
        Polynomial p1 = new Polynomial("x^3-x-1");
        Polynomial expectedP=new Polynomial("x^2");
        Polynomial resultP = operations.derivative(p1);

        assertNotEquals(expectedP.toString(),resultP.toString());
    }

    @Test
    void integralFalse() {
        Polynomial p1 = new Polynomial("x^3-x-1");
        Polynomial expectedP=new Polynomial("x");
        Polynomial resultP = operations.integral(p1);

        assertNotEquals(expectedP.toString(),resultP.toString());
    }
}