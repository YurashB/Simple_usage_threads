package bisnesLogic;

import bisnesLogic.calcuators.CalculatorStrategy;

public class CalculatorContext {
    private CalculatorStrategy calculatorStrategy;

    public void setCalculatorStrategy(CalculatorStrategy calculatorStrategy) {
        this.calculatorStrategy = calculatorStrategy;
    }

    public long calculate(long N) {
        return this.calculatorStrategy.calculate(N);
    }
}
