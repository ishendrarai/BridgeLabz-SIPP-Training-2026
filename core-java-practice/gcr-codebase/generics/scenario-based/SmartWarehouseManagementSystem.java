import java.util.ArrayList;
import java.util.List;

public class SmartWarehouseManagementSystem {
    public static abstract class WarehouseItem {
        private String name;
        public WarehouseItem(String name) { this.name = name; }
        public String getName() { return name; }
    }
    
    public static class Electronics extends WarehouseItem {
        public Electronics(String name) { super(name); }
    }
    
    public static class Groceries extends WarehouseItem {
        public Groceries(String name) { super(name); }
    }
    
    public static class Furniture extends WarehouseItem {
        public Furniture(String name) { super(name); }
    }
    
    public static class Storage<T extends WarehouseItem> {
        private List<T> items = new ArrayList<>();
        public void addItem(T item) { items.add(item); }
        public List<T> getItems() { return items; }
    }
    
    public static void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item.getName());
        }
    }
}
