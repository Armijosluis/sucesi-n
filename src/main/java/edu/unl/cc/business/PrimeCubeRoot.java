package edu.unl.cc.business;

import edu.unl.cc.domain.Successionable;

//8. Serie de primos elevados a la raiz cúbica hasta un n términos (S = 1^(1/3) + 3^(1/3) + 5^(1/3) + 7^(1/3) + 11^(1/3) + 13^(1/3)):

public class PrimeCubeRoot implements Successionable {
    private Integer limit;
    private Integer currentTerm;
    private final StringBuilder printableTerms;

    public PrimeCubeRoot(Number limit) {
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
        double result = 0;
        int count = 0;

        while (count < limit) {
            double root = Math.pow(currentTerm, 1.0 / 3);
            printableTerms.append(currentTerm).append("^(1/3) + ");
            result += root;
            count++;
            currentTerm = nextTerm(currentTerm).intValue();
        }

        return result;
    }

    @Override
    public String print() {
        return printableTerms.toString();
    }

}
