package bisnesLogic;

import bisnesLogic.calcuators.FormulaCalculator;
import bisnesLogic.calcuators.OneThreadCalculator;
import bisnesLogic.calcuators.TwoThreadCalculator;

import java.util.ArrayList;
/*
Клас, який робить дані щодо часу роботи програми в однопоточному
і двопоточному середовищі. Тобто в завдані до лаби потрібно зробити
графік залежності часу від кількості чисел для обрахунку для різних потоків.
Тобто я спершу рахую швидкість для startNumber (наприклад 10^6).
Потім роблю знову обрахунки, але на крок більше (startNumber += step)
і так step раз. Всі дані записуються в ArrayList класу.

Оскільки я хз як будувати графікі в java, да й Вовку це б не сподобалося, я просто
значення часу перекидую в пайтон і там вже будую графік.

 */

public class TimeMeasurer {
    private final OneThreadCalculator oneThreadCalculator = new OneThreadCalculator();
    private final TwoThreadCalculator twoThreadCalculator = new TwoThreadCalculator();
    private final ArrayList<Long> oneThreadTimeList = new ArrayList<>();
    private final ArrayList<Long> twoThreadTimeList = new ArrayList<>();
    private final long startNumber; // початкове число дял обрахунку прогресії
    private final long step; // крок обрахунки наступної
    private final long steps; // кількість таких кроків


    public TimeMeasurer(long startNumber, long step, long steps) {
        this.startNumber = startNumber;
        this.step = step;
        this.steps = steps;
    }


    public void calculate() {
        long N = this.startNumber;

        for (int i = 0; i < steps; i++) {
            long start = System.nanoTime();
            oneThreadCalculator.calculate(N);
            long finish = System.nanoTime();
            this.oneThreadTimeList.add(finish - start);

            start = System.nanoTime();
            twoThreadCalculator.calculate(N);
            finish = System.nanoTime();
            this.twoThreadTimeList.add(finish - start);

            N += this.step;
        }
    }

    public ArrayList<Long> getOneThreadTimeList() {
        return oneThreadTimeList;
    }

    public ArrayList<Long> getTwoThreadTimeList() {
        return twoThreadTimeList;
    }
}
