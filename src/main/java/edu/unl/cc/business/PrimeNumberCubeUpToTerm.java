package edu.unl.cc.business;

import edu.unl.cc.domain.Successionable;

//3. Serie de primos elevados al cubo  hasta N términos (S = 1^3 + 3^3 + 5^3 + 7^3 + 11^3 + 13^3 ...):

public class PrimeNumberCubeUpToTerm implements Successionable {
    private Integer terms;
    private Integer currentTerm;
    private Integer counter;
    private StringBuilder printableTerms;

    public PrimeNumberCubeUpToTerm(Number terms) {
        if (terms.intValue() <= 0) {
            throw new IllegalArgumentException("Number of terms must be greater than 0");
        }
        this.terms = terms.intValue();
        this.currentTerm = 1;
        this.counter = 0;
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
    }

    @Override
    public Number calculate() {
        long result = 0;

        while (counter < terms) {
            long cube = (long) Math.pow(currentTerm, 3);
            printableTerms.append(currentTerm).append("^3 + ");
            result += cube;
            counter++;
            currentTerm = nextTerm(currentTerm).intValue();
        }

        return result;
    }

    @Override
    public String print() {
        return printableTerms.toString();
    }
}
