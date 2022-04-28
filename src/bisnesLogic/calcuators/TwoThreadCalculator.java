package bisnesLogic.calcuators;

import bisnesLogic.calcuators.thread_classes.HalfCalculator;

public class TwoThreadCalculator implements CalculatorStrategy {
    @Override
    public long calculate(long N) {

        HalfCalculator evenCalculator = new HalfCalculator(1, N);
        HalfCalculator oddCalculator = new HalfCalculator(2, N);

        Thread evenThread = new Thread(evenCalculator);
        Thread oddThread = new Thread(oddCalculator);

        evenThread.start();
        oddThread.start();

        try {  // IS IT CORRECT AND CAN IT CAUSE 'PEREZDACHA'
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        return oddCalculator.getSum() + evenCalculator.getSum();

    }
}
