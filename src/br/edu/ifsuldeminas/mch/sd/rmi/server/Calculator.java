package br.edu.ifsuldeminas.mch.sd.rmi.server;

import java.util.ArrayList;
import java.util.List;
import br.edu.ifsuldeminas.mch.sd.rmi.remote.Operations;

public class Calculator implements Operations {
    private List<String> lastOperations = new ArrayList<String>();

    public Number sum(Number x, Number y) {
        Number result = x.doubleValue() + y.doubleValue();
        log("Soma", x, "+", y, result);
        return result;
    }

    public Number sub(Number x, Number y) {
        Number result = x.doubleValue() - y.doubleValue();
        log("Subtração", x, "-", y, result);
        return result;
    }

    public Number mul(Number x, Number y) {
        Number result = x.doubleValue() * y.doubleValue();
        log("Multiplicação", x, "*", y, result);
        return result;
    }

    public Number div(Number x, Number y) {
        Number result = Double.NaN;
        if (y.doubleValue() != 0)
            result = x.doubleValue() / y.doubleValue();
        log("Divisão", x, "/", y, result);
        return result;
    }

    public Number sqrt(Number x, int root) {
        Number result = Math.pow(x.doubleValue(), 1.0 / root);
        log("Raiz", x, "√" + root, null, result);
        return result;
    }

    public Number pow(Number x, int exponent) {
        Number result = Math.pow(x.doubleValue(), exponent);
        log("Potência", x, "^" + exponent, null, result);
        return result;
    }

    public Number percent(Number x, Number y) {
        Number result = (x.doubleValue() * y.doubleValue()) / 100.0;
        log("Porcentagem", x, "%", y, result);
        return result;
    }

    public Number mod(Number x, Number y) {
        Number result = x.doubleValue() % y.doubleValue();
        log("Módulo", x, "mod", y, result);
        return result;
    }

    public Number factorial(int x) {
        if (x < 0) return Double.NaN;
        long result = 1;
        for (int i = 2; i <= x; i++) {
            result *= i;
        }
        log("Fatorial", x, "!", null, result);
        return result;
    }

    public List<String> lastOperations(int howMany) {
        if (lastOperations.size() < howMany)
            return lastOperations();
        return new ArrayList<String>(lastOperations.subList(lastOperations.size() - howMany, lastOperations.size()));
    }

    public List<String> lastOperations() {
        return lastOperations;
    }

    private void log(String operationName, Number operatorOne, String operation, Number operatorTwo, Number result) {
        String formattedOperation = operatorTwo == null ? 
            String.format("%s: %s %s = %s", operationName, operatorOne.toString(), operation, result.toString()) :
            String.format("%s: %s %s %s = %s", operationName, operatorOne.toString(), operation, operatorTwo.toString(), result.toString());

        lastOperations.add(formattedOperation);
        System.out.println(formattedOperation);
    }
}