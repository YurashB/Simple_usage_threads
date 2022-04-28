package bisnesLogic.calcuators;

public class OneThreadCalculator implements CalculatorStrategy {
    @Override
    public long calculate(long N) {
        long sum = 0;

        for (long i = 1L; i <= N; i++) {
            sum += i * 10;
        }

        return sum;
    }
}
