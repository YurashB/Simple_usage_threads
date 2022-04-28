import bisnesLogic.CalculatorContext;
import bisnesLogic.TimeMeasurer;
import bisnesLogic.calcuators.CalculatorStrategy;
import bisnesLogic.calcuators.FormulaCalculator;
import bisnesLogic.calcuators.OneThreadCalculator;
import bisnesLogic.calcuators.TwoThreadCalculator;

public class Main {
    public static void main(String[] args) {
        long N = 1_000_000_000L;
        CalculatorContext calculatorContext = new CalculatorContext();

        CalculatorStrategy formula = new FormulaCalculator();
        CalculatorStrategy oneThread = new OneThreadCalculator();
        CalculatorStrategy twoThread = new TwoThreadCalculator();

        System.out.println("За формулою");
        calculatorContext.setCalculatorStrategy(formula);
        long start = System.nanoTime();
        long result = calculatorContext.calculate(N);
        long end = System.nanoTime();
        System.out.println("Результат: " + result);
        System.out.println("Час: " + (end - start));

        System.out.println("\nОдин поток");
        calculatorContext.setCalculatorStrategy(oneThread);
        start = System.nanoTime();
        result = calculatorContext.calculate(N);
        end = System.nanoTime();
        System.out.println("Результат: " + result);
        System.out.println("Час: " + (end - start));

        System.out.println("\nДва потоки");
        calculatorContext.setCalculatorStrategy(twoThread);
        start = System.nanoTime();
        result = calculatorContext.calculate(N);
        end = System.nanoTime();
        System.out.println("Результат: " + result);
        System.out.println("Час: " + (end - start));

        method(); // метод
    }


    private static void method() { // метод, що реалізує Time Measurer class
        long startTime = 100_000_000L;
        long step = 100_000_000L;
        int steps = 50;
        TimeMeasurer timeMeasurer = new TimeMeasurer(startTime, step, steps);
        timeMeasurer.calculate();

        System.out.println(timeMeasurer.getOneThreadTimeList());// це потім як копіюю в пайтон)
        System.out.println(timeMeasurer.getTwoThreadTimeList());

    }
}
