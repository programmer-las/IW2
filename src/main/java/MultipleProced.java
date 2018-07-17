import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Class {@code Multiple} provides <b>5</b> methods for check multiple
 */
public class MultipleProced {

    final static Logger logger = Logger.getLogger(MultipleProced.class);
    final static Logger localLogDebug = Logger.getLogger("logDebug");
    final static Logger localLogError = Logger.getLogger("logError");

    private Map<Integer, String> dividerMap;
    private int dividedMax;
    private int divided;
    private int divider;
    private List<Integer> listOfMultipleIntegers = new ArrayList<>();

    public MultipleProced() {
        localLogDebug.debug("Run Multiple()");
    }

    public MultipleProced(Map<Integer, String> dividerMap, int dividedMax) {
        this.dividedMax = dividedMax;
        this.dividerMap = dividerMap;
        localLogDebug.debug("Run Multiple(Map<Integer, String> dividerMap ,int dividedMax)");
        multipleFrom1ToN();
//        multipleFrom1ToN(dividedMax, dividerMap);
    }

    public void multipleFrom1ToN() {
//    public void multipleFrom1ToN(int dividedMax, Map<Integer, String> dividerMap) {
        for (int i = 1; i <= dividedMax; i++) {
            this.divided = i;
            multipleOfMap();
//            multipleOfMap(divided, dividerMap);
            if (i == dividedMax) {
                localLogDebug.debug("Max iterration(s) of circle is/are " + i);
            }
        }
    }

    public boolean multipleOfMap() {
//    public boolean multipleOfMap(int divided, Map<Integer, String> dividerMap) {
        boolean isPositivResult = false;
        StringBuilder logStringBuilder = new StringBuilder("");
        int countKeys = 1;
        for (Map.Entry a : dividerMap.entrySet()) {
            this.divider = (int) a.getKey();
            if (isMultiple()) {
//            if (isMultiple(divided, divider)) {
                logStringBuilder.append(a.getValue());
                this.listOfMultipleIntegers.add(divided);
                isPositivResult = true;
            }
            if ((countKeys == dividerMap.size()) && (isPositivResult))
            {
                localLogDebug.debug("For " + divided + " - " + logStringBuilder);
            }
            countKeys += 1;
        }
        return isPositivResult;
    }

    public boolean isMultiple() {
//    public boolean isMultiple(int divided, int divider) {
//        return multiple(divided, divider) == 0 ? true : false;
        return multiple() == 0 ? true : false;
    }

    /**
     * @return multiple as result of operation divided / divider
     */
    int multiple() {
//    int multiple(int divided, int divider) {
        try {
            return divided % divider;
        } catch (ArithmeticException ex) {
            localLogError.error("Exception because divide at zero"/*, ex*/);
            return -1;
        }
    }
//todo: чи варто перемістити сеттери вверх?

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

    public List<Integer> getListOfMultipleIntegers() {
        return listOfMultipleIntegers;
    }
}
