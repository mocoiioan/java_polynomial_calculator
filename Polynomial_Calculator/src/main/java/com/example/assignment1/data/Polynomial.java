package com.example.assignment1.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private TreeMap<Integer, Monomial> Elements;

    public Polynomial(TreeMap<Integer, Monomial> tm) {
        this.Elements = tm;
    }

    public Polynomial() {
        this.Elements = new TreeMap<>();
    }

    public Polynomial(String input) {
        //([+-])?(\d+\.?\d*)?(x)?(\^)?(\d+)?
        this.Elements = new TreeMap<>();
        Pattern pattern = Pattern.compile("((?=.)([+-])?(\\d+\\.?\\d*)?(x)?(\\^)?(\\d+)?)");
        Matcher matcher = pattern.matcher(input);
        List<Monomial> mList = new ArrayList<>();
        while (matcher.find()) {
            mList.add(new Monomial(matcher.group()));
        }
        for (Monomial m : mList) {
            if (this.Elements.containsKey(m.getExponent()))
                this.Elements.put(m.getExponent(), this.getElements().get(m.getExponent()).addMonomials(m));
            else
                this.Elements.put(m.getExponent(), m);
        }
    }

    public TreeMap<Integer, Monomial> getElements() {
        return Elements;
    }

    public void addElement(Monomial m) {
        this.Elements.put(m.getExponent(), m);
    }

    @Override
    public String toString() {
        StringBuilder toRet = new StringBuilder();
        for (Map.Entry<Integer, Monomial> entry : this.Elements.descendingMap().entrySet()) {
            if ((toRet.length() > 0) && entry.getValue().getCoefficient() > 0)
                toRet.append("+").append(entry.getValue());
            else
                toRet.append(entry.getValue());
        }
        return toRet.toString();
    }
}
