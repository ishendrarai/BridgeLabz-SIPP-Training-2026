import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {
    static class Data {
        String val;
        int time;
        Data(String val, int time) { this.val = val; this.time = time; }
    }
    
    private Map<String, List<Data>> map;

    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Data> list = map.get(key);
        int left = 0, right = list.size() - 1;
        String res = "";
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).time <= timestamp) {
                res = list.get(mid).val;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
