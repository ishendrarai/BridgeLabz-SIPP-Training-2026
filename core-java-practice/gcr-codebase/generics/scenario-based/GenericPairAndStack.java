import java.util.ArrayList;
import java.util.List;

public class GenericPairAndStack {
    
    public static class Pair<T, U> {
        private T first;
        private U second;
        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
        public T getFirst() { return first; }
        public U getSecond() { return second; }
    }
    
    public static class Stack<T> {
        private List<T> elements = new ArrayList<>();
        public void push(T item) { elements.add(item); }
        public T pop() { 
            if (elements.isEmpty()) return null;
            return elements.remove(elements.size() - 1); 
        }
    }
    
    public static <T extends Comparable<T>> T findMax(T[] arr) {
        if (arr == null || arr.length == 0) return null;
        T max = arr[0];
        for (T item : arr) {
            if (item.compareTo(max) > 0) max = item;
        }
        return max;
    }
    
    public static class Repository<T> {
        private List<T> items = new ArrayList<>();
        public void save(T item) { items.add(item); }
        public List<T> findAll() { return items; }
    }
    
    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}
