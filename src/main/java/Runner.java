import java.util.HashMap;
import java.util.Map;

public class Runner {

    public static void main(String[] args) {

        Map<Integer, String> dividerMap = new HashMap();
        dividerMap.put(3, "three");
        dividerMap.put(5, "five");
        int dividedMax = 15;

        Multiple multiple = new Multiple(dividerMap, dividedMax);
    }
}
