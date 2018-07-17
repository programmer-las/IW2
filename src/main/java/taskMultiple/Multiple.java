package taskMultiple;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The {@code taskMultiple.Multiple} class provides <b>5</b> methods to get multiples
 * of integer digits {@code dividerMap} and {@code dididerMax}.
 * <p> Клас multiple дає 5 методів щоб отримати кратні цілих чисел dividerMap and dididerMax
 *
 *
 * There are two constructor. First of them is used for initializing instance of {@link Multiple#Multiple()}:
 * <blockquote><pre>
 *     public taskMultiple.Multiple()
 * </pre></blockquote><p>
 Second one {@link Multiple#Multiple} for getting multiples
 throw {@code getgetListOfDividers()} :
 *<p>
 *     Є два контсруктори. Перший для ініціалізації об'єкту taskMultiple.Multiple,
 *     друний - для того щоб отримати кратне з методу getgetListOfDividers()
 *     <p>
 *  Написано на основі:
 *   @see     java.lang.String
 *
 */
public class Multiple {

    /**
     * logger is used for TRACE
     * localLogDebug for logging in {@link Multiple#isMultipleOfMapOfDeviders()} ()}
     * localLogError for logging exception in {@link Multiple#remainder()}}
     */
    final static Logger logger = Logger.getLogger(Multiple.class);
    final static Logger localLogDebug = Logger.getLogger("logDebug");
    final static Logger localLogError = Logger.getLogger("logError");

    private Map<Integer, String> dividerMap;
    private int dividedMax;
    private int divided;
    private int divider;

    /**
     * listOfDividers contains all digits are divided at Integer amount dividerMap without remainder
     * listOfDividers містить всі числа, які діляться без залишку на цілі з ліста dividerMap
     */
    private List<Integer> listOfDividers = new ArrayList<>();

    /**
     * Default constructor
     */
    Multiple() {
        localLogDebug.debug("Run taskMultiple.Multiple()");
    }

    /**
     * Constructor
     * @param dividedMax max Integer divided
     * @param dividedMax найбільше ділене типу Integer
     * @param dividerMap map of {@code Integer} deviders
     * @param dividerMap мапа цілих дільників
     */
    Multiple(Map<Integer, String> dividerMap, int dividedMax) {
        this.dividedMax = dividedMax;
        this.dividerMap = dividerMap;
        localLogDebug.debug("Run taskMultiple.Multiple(Map<Integer, String> dividerMap ,int dividedMax)");
        multipleFrom1ToN();
    }

    /**
     * Define basic method to find multiples
     * задає основний метод пошуку кратних
     */
    void multipleFrom1ToN() {
        for (int i = 1; i <= dividedMax; i++) {
            this.divided = i;
            isMultipleOfMapOfDeviders();
            if (i == dividedMax) {
                localLogDebug.debug("Max iterration(s) of circle is/are " + i);
            }
        }
    }

    /**
     * Method isMultipleOfMapOfDeviders checks if Integer of Keys of map dividerMap are multiples
     * Method isMultipleOfMapOfDeviders перевіряє, чи цілі числа, які є ключами мапи dividerMap є кратними числами
     * @return true if Integer of Keys of map dividerMap are multiples
     * @return true якщо цілі числа, які є ключами мапи dividerMap, є кратними числами
     */
    boolean isMultipleOfMapOfDeviders() {
        boolean isPositivResult = false;
        StringBuilder logStringBuilder = new StringBuilder("");
        int countKeys = 1;
        for (Map.Entry a : dividerMap.entrySet()) {
            this.divider = (int) a.getKey();
            if (isMultiple()) {
                logStringBuilder.append(a.getValue());
                this.listOfDividers.add(divided);
                isPositivResult = true;
            }
            if ((countKeys == dividerMap.size()) && (isPositivResult)) {
                localLogDebug.debug("For " + divided + " - " + logStringBuilder);
            }
            countKeys += 1;
        }
        return isPositivResult;
    }

    /**
     * isMultiple checks if divided divides at divider without remainder
     * isMultiple перевіряє чи делене ділиться на дільник без залишку
     * @return true if divided divides at divider without remainder
     * @return true if делене ділиться на дільник без залишку
     */
    boolean isMultiple() {
        return remainder() == 0 ? true : false;
    }

    /**
     * remainder find out remainder of divided divides at divider
     * remainder знаходить залишоk divided поділеного на divider
     * @return remainder of operation divided / divider
     * @return залишок операції divided / divider
     */
    int remainder() {
        try {
            return divided % divider;
        } catch (ArithmeticException ex) {
            localLogError.error("Exception because divide at zero"/*, ex*/);
            return -1;
        }
    }

    public void setDividerMap(Map<Integer, String> dividerMap) {
        this.dividerMap = dividerMap;
    }

    public void setDividedMax(int dividedMax) {
        this.dividedMax = dividedMax;
    }

    public void setDivided(int divided) {
        this.divided = divided;
    }

    public void setDivider(int divider) {
        this.divider = divider;
    }

    public List<Integer> getListOfDividers() {
        return listOfDividers;
    }
}
