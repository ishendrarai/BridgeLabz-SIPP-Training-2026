import java.util.ArrayList;
import java.util.List;

public class MergeCustomerRecords {
    public List<Integer> mergeRecords(List<Integer> listA, List<Integer> listB) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < listA.size() && j < listB.size()) {
            if (listA.get(i) <= listB.get(j)) {
                result.add(listA.get(i++));
            } else {
                result.add(listB.get(j++));
            }
        }
        while (i < listA.size()) result.add(listA.get(i++));
        while (j < listB.size()) result.add(listB.get(j++));
        return result;
    }
}
