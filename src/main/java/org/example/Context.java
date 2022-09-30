package org.example;

public class Context {
    private Strategy strategy;
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
    public double execute(double a, double b) {
       return strategy.calculate(a,b);

    }
}
