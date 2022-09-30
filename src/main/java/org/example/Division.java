package org.example;

public class Division implements Strategy {
    @Override
    public double calculate(double a, double b) {
        return a/b;
    }
}
