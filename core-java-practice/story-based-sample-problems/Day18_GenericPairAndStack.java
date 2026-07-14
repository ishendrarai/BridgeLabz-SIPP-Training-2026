import java.util.ArrayList;
import java.util.List;

public class Day18_GenericPairAndStack {
    static class Pair<T, U> {
        T first;
        U second;
        public Pair(T f, U s) { first = f; second = s; }
        @Override
        public String toString() { return "(" + first + ", " + second + ")"; }
    }
    
    static class Stack<T> {
        private List<T> list = new ArrayList<>();
        public void push(T val) { list.add(val); }
        public T pop() { return list.isEmpty() ? null : list.remove(list.size() - 1); }
    }
    
    public static <T extends Comparable<T>> T findMax(T[] arr) {
        if (arr == null || arr.length == 0) return null;
        T max = arr[0];
        for (T item : arr) {
            if (item.compareTo(max) > 0) max = item;
        }
        return max;
    }
    
    static class Repository<T> {
        List<T> entities = new ArrayList<>();
        public void add(T entity) { entities.add(entity); }
        public List<T> getAll() { return entities; }
    }
    
    public static void printUtility(List<?> list) {
        for (Object o : list) System.out.println(o);
    }
    
    public static void main(String[] args) {
        Pair<String, Integer> p = new Pair<>("Age", 25);
        System.out.println(p);
        
        Integer[] nums = {10, 50, 30, 20};
        System.out.println("Max element: " + findMax(nums));
        
        Repository<String> repo = new Repository<>();
        repo.add("User1"); repo.add("User2");
        printUtility(repo.getAll());
    }
}
