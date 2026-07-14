public class OnlineCouponValidator {
    interface CouponValidator {
        boolean validateCoupon(String code);

        static boolean isLengthValid(String code) {
            return code != null && code.length() >= 5 && code.length() <= 10;
        }
    }

    static class ShoppingCart implements CouponValidator {
        @Override
        public boolean validateCoupon(String code) {
            if (!CouponValidator.isLengthValid(code)) {
                return false;
            }
            return code.startsWith("DISCOUNT") || code.startsWith("FEST");
        }
    }

    public static void main(String[] args) {
        String[] coupons = {"DISCOUNT50", "FEST20", "BAD", "INVALID12345", "DISCOUNT10"};
        ShoppingCart cart = new ShoppingCart();

        for (String c : coupons) {
            System.out.println("Coupon: " + c + " -> " + (cart.validateCoupon(c) ? "Valid" : "Invalid"));
        }
    }
}
