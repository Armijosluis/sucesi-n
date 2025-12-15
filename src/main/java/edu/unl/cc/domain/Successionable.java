package edu.unl.cc.domain;

public interface Successionable extends Printable {

Number nextTerm(Number currentTerm);

void setLimit(Number limit);

Number calculate();
}
