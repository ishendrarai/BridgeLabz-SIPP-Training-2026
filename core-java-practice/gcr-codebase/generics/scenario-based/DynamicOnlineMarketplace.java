public class DynamicOnlineMarketplace {
    public static abstract class Category {
        protected String name;
        public Category(String name) { this.name = name; }
    }
    
    public static class BookCategory extends Category {
        public BookCategory() { super("Book"); }
    }
    
    public static class ClothingCategory extends Category {
        public ClothingCategory() { super("Clothing"); }
    }
    
    public static class Product<T extends Category> {
        private String name;
        private double price;
        private T category;
        
        public Product(String name, double price, T category) {
            this.name = name;
            this.price = price;
            this.category = category;
        }
        
        public double getPrice() { return price; }
        public void setPrice(double price) { this.price = price; }
        public T getCategory() { return category; }
        public String getName() { return name; }
    }
    
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double newPrice = product.getPrice() * (1 - percentage / 100);
        product.setPrice(newPrice);
    }
}
