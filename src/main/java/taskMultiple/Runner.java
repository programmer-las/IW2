package taskMultiple;

import java.util.HashMap;
import java.util.Map;

public class Runner {

    /**
     * To find out digits are devided without remainder at divides in range from 1 to dividedMax
     * Знаходження чисел які діляться без залишку на дільники від 1 до dividedMax
     *
     * In method main is initialised and filled out map dividerMap
     * в методі проініціалізовано і заповнено мапу dividerMap
     *
     * Keys map dividerMap are dividers
     * ключі map dividerMap є дільниками
     *
     * Value map dividerMap are text to write if devided is devided at devider without remainder
     * Значенням мапи dividerMap є текст, якиий виводиться в лог при дільник ділиться на ділене без залишку
     *
     * Result is contained at class variable Multiple
     * Результат знаходиться у змінній listOfDividers класу Multiple
     */
    public static void main(String[] args) {

        Map<Integer, String> dividerMap = new HashMap();
        dividerMap.put(3, "three");
        dividerMap.put(5, "five");
        int dividedMax = 15;

        new Multiple(dividerMap, dividedMax);
    }
}
