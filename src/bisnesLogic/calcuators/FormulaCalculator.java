package bisnesLogic.calcuators;

public class FormulaCalculator implements CalculatorStrategy {

    @Override
    public long calculate(long N) {
        return (2L * 10L + 10L * (N - 1L)) / 2L * N;
    }
}
