package university.adminTools;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public final class FilterTool {

    public static <T> List<T> filter(List<T> list, Predicate<T> ruleset) {

        List<T> finalList = new ArrayList<>();

        for(T item : list) {
            if(ruleset.test(item)) {
                finalList.add(item);
            }
        }

        return finalList;
    }
}
