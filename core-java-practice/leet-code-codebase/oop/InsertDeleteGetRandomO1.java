import java.util.*;

public class InsertDeleteGetRandomO1 {
    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random rand;

    public InsertDeleteGetRandomO1() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int loc = map.get(val);
        if (loc < list.size() - 1) {
            int lastOne = list.get(list.size() - 1);
            list.set(loc, lastOne);
            map.put(lastOne, loc);
        }
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
