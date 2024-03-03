package com.example.assignment1.logic;

import com.example.assignment1.data.Monomial;
import com.example.assignment1.data.Polynomial;

import java.util.Map;

//x.getElements().get(entry.getKey()).setCoefficient(x.getElements().get(entry.getKey()).getCoefficient()+entry.getValue().getCoefficient());


public class Operations {
    public Polynomial addition(Polynomial a, Polynomial b) {
        Polynomial x = new Polynomial(a.getElements());
        for (Map.Entry<Integer, Monomial> entry : b.getElements().entrySet())
            if (x.getElements().containsKey(entry.getKey()))
                x.addElement(x.getElements().get(entry.getKey()).addMonomials(entry.getValue()));
            else
                x.addElement(entry.getValue());
        return x;
    }

    public Polynomial subtraction(Polynomial a, Polynomial b) {
        Polynomial x = new Polynomial(a.getElements());
        for (Map.Entry<Integer, Monomial> entry : b.getElements().entrySet())
            if (x.getElements().containsKey(entry.getKey()))
                x.addElement(x.getElements().get(entry.getKey()).subMonomials(entry.getValue()));
            else
                x.addElement(new Monomial(entry.getValue().getCoefficient() * (-1), entry.getValue().getExponent()));
        for (Map.Entry<Integer, Monomial> entry : x.getElements().entrySet())
            if (entry.getValue().getCoefficient() == 0)
                x.getElements().remove(entry.getKey());
        return x;
    }

    public Polynomial multiplication(Polynomial a, Polynomial b) {
        Polynomial x = new Polynomial();
        for (Map.Entry<Integer, Monomial> entryA : a.getElements().entrySet()) {
            for (Map.Entry<Integer, Monomial> entryB : b.getElements().entrySet()) {
                Monomial m = new Monomial(entryA.getValue().mulMonomials(entryB.getValue()));
                if (x.getElements().containsKey(m.getExponent()))
                    x.addElement(x.getElements().get(m.getExponent()).addMonomials(m));
                else
                    x.addElement(m);
            }
        }
        return x;
    }

    public String division(Polynomial a, Polynomial b) {
        Polynomial dividend = new Polynomial(a.getElements());
        Polynomial divisor = new Polynomial(b.getElements());
        Polynomial quotient = new Polynomial();
        Polynomial remainder = new Polynomial();

        while (!dividend.getElements().isEmpty() && !divisor.getElements().isEmpty()
                && dividend.getElements().lastKey() >= divisor.getElements().lastKey()) {
            Monomial m = new Monomial(dividend.getElements().lastEntry().getValue().divMonomials(divisor.getElements().lastEntry().getValue()));
            if (quotient.getElements().containsKey(m.getExponent()))
                quotient.addElement(quotient.getElements().get(m.getExponent()).addMonomials(m));
            else
                quotient.addElement(m);
            Polynomial tempMul=new Polynomial();
            tempMul.addElement(m);
            Polynomial divMulQ=multiplication(divisor,tempMul);
            remainder=subtraction(dividend,divMulQ);
            dividend=remainder;
        }

        return quotient + " " + remainder;
    }

    public Polynomial derivative(Polynomial a) {
        Polynomial x = new Polynomial();
        for (Map.Entry<Integer, Monomial> entry : a.getElements().entrySet())
            x.addElement(new Monomial(entry.getValue().getCoefficient() * entry.getKey(), entry.getKey() - 1));
        return x;
    }

    public Polynomial integral(Polynomial a) {
        Polynomial x = new Polynomial();
        for (Map.Entry<Integer, Monomial> entry : a.getElements().entrySet())
            x.addElement(new Monomial(entry.getValue().getCoefficient() / (entry.getKey() + 1), entry.getKey() + 1));
        return x;
    }
}
