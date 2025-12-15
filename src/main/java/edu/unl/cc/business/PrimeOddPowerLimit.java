package edu.unl.cc.business;

//5. Serie de primos elevados a impares hasta n térmimos (S = S = 1^1 + 3^3 + 5^5 + 7^7 + 11^9 + 13^11 ..):

import edu.unl.cc.domain.Successionable;

public class PrimeOddPowerLimit implements Successionable {
    private Integer limit;                 // N términos
    private Integer currentTerm;            // primo actual
    private final StringBuilder printableTerms;

    public PrimeOddPowerLimit(Number limit) {
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
        int exponent = 1;
        int count = 0;

        while (count < limit) {

            long power = (long) Math.pow(currentTerm, exponent);

            printableTerms.append(currentTerm).append("^").append(exponent).append(" + ");
            result += power;
            exponent += 2;
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
