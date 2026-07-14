import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {
    class Data {
        String val;
        int time;
        Data(String val, int time) {
            this.val = val;
            this.time = time;
        }
    }
    
    private Map<String, List<Data>> map;

    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Data> list = map.get(key);
        return binarySearch(list, timestamp);
    }
    
    private String binarySearch(List<Data> list, int time) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2 + 1;
            if (list.get(mid).time <= time) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return list.get(left).time <= time ? list.get(left).val : "";
    }
}
