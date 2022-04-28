package bisnesLogic.calcuators.thread_classes;

public class HalfCalculator implements Runnable {
    private final int k;
    private final long N;
    private long sum = 0;

    public HalfCalculator(int k,long N) {
        this.k = k;
        this.N = N;
    }

    @Override
    public void run() {
        for (long i = k; i <= N; i += 2) {
            this.sum += i * 10;
        }
    }

    public long getSum() {
        return sum;
    }
}
