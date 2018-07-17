import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class {@code Multiple} provides <b>5</b> methods for check multiple
 */
public class Multiple {

    final static Logger logger = Logger.getLogger(Multiple.class);
    final static Logger localLogDebug = Logger.getLogger("logDebug");
    final static Logger localLogError = Logger.getLogger("logError");

    private Map<Integer, String> dividerMap;
    private int dividedMax;
    private int divided;
    private int divider;
    private List<Integer> listOfMultipleIntegers = new ArrayList<>();

    public Multiple() {
        localLogDebug.debug("Run Multiple()");
    }

    public Multiple(Map<Integer, String> dividerMap, int dividedMax) {
        this.dividedMax = dividedMax;
        this.dividerMap = dividerMap;
        localLogDebug.debug("Run Multiple(Map<Integer, String> dividerMap ,int dividedMax)");
        multipleFrom1ToN();
    }

    public void multipleFrom1ToN() {
        for (int i = 1; i <= dividedMax; i++) {
            this.divided = i;
            multipleOfMap();
            if (i == dividedMax) {
                localLogDebug.debug("Max iterration(s) of circle is/are " + i);
            }
        }
    }

    public boolean multipleOfMap() {
        boolean isPositivResult = false;
        StringBuilder logStringBuilder = new StringBuilder("");
        int countKeys = 1;
        for (Map.Entry a : dividerMap.entrySet()) {
            this.divider = (int) a.getKey();
            if (isMultiple()) {
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
        return multiple() == 0 ? true : false;
    }

    /**
     * @return multiple as result of operation divided / divider
     */
    int multiple() {
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
