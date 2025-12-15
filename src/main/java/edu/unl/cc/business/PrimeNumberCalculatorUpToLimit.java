package edu.unl.cc.business;

import edu.unl.cc.domain.Successionable;

//10. Serie de primos hasta un limite (S = 1 + 2 + 3 + 5 + 7 + 11 + 13 + .. + N:

public class PrimeNumberCalculatorUpToLimit implements Successionable {

    private Integer limit;
    private Integer currentTerm;
    private final StringBuilder printableTerms;

    public PrimeNumberCalculatorUpToLimit(Number limit) {
        if (limit.intValue() <= 0) {
            throw new IllegalArgumentException("Limit must be greater than 0");
        }
        this.limit = limit.intValue();
        this.currentTerm = 1;
        this.printableTerms = new StringBuilder("S = ");
    }

    private boolean isPrime(Integer number) {
        if (number <= 1) return false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Number nextTerm(Number currentTerm) {
        int value = currentTerm.intValue() + 1;
        while (!isPrime(value)) {
            value++;
        }
        return value;
    }

    @Override
    public void setLimit(Number limit) {
        if (limit.intValue() <= 0) {
            throw new IllegalArgumentException("Limit must be greater than 0");
        }
        this.limit = limit.intValue();
    }

    @Override
    public Number calculate() {
        long result = 0;

        // Se incluye manualmente el 1
        printableTerms.append("1 + ");
        result += 1;

        currentTerm = 2;

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