package edu.unl.cc.business;

import edu.unl.cc.domain.Successionable;

//2. Serie de primos elevados al cubo  hasta un limite (S = 1^3 + 3^3 + 5^3 + 7^3 + 11^3 + 13^3 ... + N^3):

public class PrimeCubedWithLimit implements Successionable {
    private Integer limit;
    private Integer currentTerm;
    private final StringBuilder printableTerms;

    public PrimeCubedWithLimit(Number limit) {
        if (limit.intValue() <= 0) {
            throw new IllegalArgumentException("Limit must be greater than 0");
        }
        this.limit = limit.intValue();
        this.currentTerm = 1;
        this.printableTerms = new StringBuilder("S = ");
    }

    private boolean isPrime(Integer number) {
        if (number == 1) return true;
        if (number == 2) return false;

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

        while (currentTerm <= limit) {

            long cube = (long) Math.pow(currentTerm, 3);
            printableTerms.append(currentTerm).append("^3 + ");
            result += cube;
            currentTerm = nextTerm(currentTerm).intValue();
        }

        return result;
    }

    @Override
    public String print() {
        return printableTerms.toString();
    }

}
