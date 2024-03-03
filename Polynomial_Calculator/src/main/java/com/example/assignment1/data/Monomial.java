package com.example.assignment1.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Monomial {
    private double coefficient;
    private int exponent;

    public Monomial(double coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public Monomial() {
        this(0.0, 0);
    }

    public Monomial(Monomial m){
        this.coefficient=m.getCoefficient();
        this.exponent=m.getExponent();
    }

    public Monomial(String input) {
        //([+-])?(\d+\.?\d*)?(x)?(\^)?(\d+)?
        Pattern pattern = Pattern.compile("(?=.)([+-])?(\\d+\\.?\\d*)?(x)?(\\^)?(\\d+)?");
        Matcher matcher = pattern.matcher(input);
        List<String> aux = new ArrayList<>();
        while (matcher.find()) {
            aux.add(matcher.group(1));
            aux.add(matcher.group(2));
            aux.add(matcher.group(3));
            aux.add(matcher.group(4));
            aux.add(matcher.group(5));
        }
//        for(String s:aux)
//            System.out.println(s);
        if (aux.get(2) != null) {
            if (aux.get(3) != null)
                this.exponent = Integer.parseInt(aux.get(4));
            else
                this.exponent = 1;
            if (Objects.isNull(aux.get(0))) {
                if (aux.get(1) != null)
                    this.coefficient = Double.parseDouble(aux.get(1));
                else
                    this.coefficient = 1;
            } else if (aux.get(0).equals("+")) {
                if (aux.get(1) != null)
                    this.coefficient = Double.parseDouble(aux.get(1));
                else
                    this.coefficient = 1;
            } else {
                if (aux.get(1) != null)
                    this.coefficient = -Double.parseDouble(aux.get(1));
                else
                    this.coefficient = -1;
            }
        } else {
            if (Objects.isNull(aux.get(0))) {
                if (aux.get(1) != null)
                    this.coefficient = Double.parseDouble(aux.get(1));
                else
                    this.coefficient = 1;
            } else if (aux.get(0).equals("+")) {
                if (aux.get(1) != null)
                    this.coefficient = Double.parseDouble(aux.get(1));
                else
                    this.coefficient = 1;
            } else {
                if (aux.get(1) != null)
                    this.coefficient = -Double.parseDouble(aux.get(1));
                else
                    this.coefficient = -1;
            }
        }
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    @Override
    public String toString() {
        StringBuilder toRet = new StringBuilder();
        if (this.coefficient == 0)
            return "";
        if (this.exponent == 0) {
            toRet.append(String.format("%.2f", this.coefficient));
            return toRet.toString();
        }
        if (this.exponent == 1) {
            if(this.coefficient == 1){
                toRet.append("x");
                return toRet.toString();
            }
            if (this.coefficient != -1)
                toRet.append(String.format("%.2f", this.coefficient));
            if (this.coefficient == -1)
                toRet.append("-");
            toRet.append("x");
            return toRet.toString();
        }
        if (this.coefficient == -1) {
            toRet.append("-");
            toRet.append("x^");
            toRet.append(this.exponent);
            return toRet.toString();
        }
        if (this.coefficient == 1) {
            toRet.append("x^");
            toRet.append(this.exponent);
            return toRet.toString();
        }
        if (this.coefficient != 1)
            toRet.append(String.format("%.2f", this.coefficient));
        toRet.append("x^");
        toRet.append(this.exponent);
        return toRet.toString();
    }

    public Monomial addMonomials(Monomial m) {
        return new Monomial(this.coefficient + m.coefficient, this.exponent);
    }

    public Monomial subMonomials(Monomial m) {
        return new Monomial(this.coefficient - m.coefficient, this.exponent);
    }

    public Monomial mulMonomials(Monomial m) {
        return new Monomial(this.coefficient * m.coefficient, this.exponent + m.exponent);
    }

    public Monomial divMonomials(Monomial m) {
        return new Monomial(this.coefficient / m.coefficient, this.exponent - m.exponent);
    }
}
