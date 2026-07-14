public class OnlineRetailOrder {
    static class Order {
        String orderId;
        String orderDate;

        public Order(String orderId, String orderDate) {
            this.orderId = orderId;
            this.orderDate = orderDate;
        }

        public String getOrderStatus() {
            return "Order Placed";
        }
    }

    static class ShippedOrder extends Order {
        String trackingNumber;

        public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
            super(orderId, orderDate);
            this.trackingNumber = trackingNumber;
        }

        @Override
        public String getOrderStatus() {
            return "Order Shipped (Tracking: " + trackingNumber + ")";
        }
    }

    static class DeliveredOrder extends ShippedOrder {
        String deliveryDate;

        public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
            super(orderId, orderDate, trackingNumber);
            this.deliveryDate = deliveryDate;
        }

        @Override
        public String getOrderStatus() {
            return "Order Delivered on " + deliveryDate;
        }
    }

    public static void main(String[] args) {
        Order o1 = new Order("ORD-01", "2024-01-01");
        ShippedOrder o2 = new ShippedOrder("ORD-02", "2024-01-02", "TRK-1234");
        DeliveredOrder o3 = new DeliveredOrder("ORD-03", "2024-01-03", "TRK-5678", "2024-01-05");

        System.out.println(o1.orderId + " status: " + o1.getOrderStatus());
        System.out.println(o2.orderId + " status: " + o2.getOrderStatus());
        System.out.println(o3.orderId + " status: " + o3.getOrderStatus());
    }
}
