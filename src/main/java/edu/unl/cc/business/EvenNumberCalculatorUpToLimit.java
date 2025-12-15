package edu.unl.cc.business;

import edu.unl.cc.domain.Successionable;

//1. Serie de numeros pares hasta un limite (S = 2 + 4 + 6 + 8 + ... N):

public class EvenNumberCalculatorUpToLimit implements Successionable {

    private Integer limit;
    private Integer currentTerm;
    private final StringBuilder printableTerms;

    public EvenNumberCalculatorUpToLimit(Number limit) {
        if (limit.intValue() <= 0) {
            throw new IllegalArgumentException("Limit must be greater than 0");
        }
        this.limit = limit.intValue();
        this.currentTerm = 2;
        this.printableTerms = new StringBuilder("S = ");
    }

    @Override
    public Number nextTerm(Number currentNumber) {
        return currentNumber.intValue() + 2;
    }

    @Override
    public void setLimit(Number limit) {
        this.limit = limit.intValue();
    }

    @Override
    public Number calculate() {
        long result = 0;

        while (currentTerm <= limit) {
            printableTerms.append(currentTerm).append(" + ");
            result += currentTerm;
            currentTerm = nextTerm(currentTerm).intValue();
        }
        return result;
    }

    @Override
    public String print() {
        return printableTerms.toString();
    }
}
