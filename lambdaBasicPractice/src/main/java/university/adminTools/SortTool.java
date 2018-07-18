package university.adminTools;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class SortTool {

    public static <T> List<T> sort(List<T> list, Comparator<T> ruleset) {
        List<T> copyList = new ArrayList<>(list);
        copyList.sort(ruleset);
        return copyList;
    }
}
