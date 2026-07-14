public class StreamingSubscription {
    static class Subscription {
        String subscriberName;
        String subscriptionId;

        public Subscription(String name, String id) {
            this.subscriberName = name;
            this.subscriptionId = id;
        }

        public double calculateMonthlyCharge() {
            return 0.0;
        }
    }

    static class BasicPlan extends Subscription {
        public BasicPlan(String name, String id) { super(name, id); }
        @Override
        public double calculateMonthlyCharge() { return 9.99; }
    }

    static class PremiumPlan extends Subscription {
        public PremiumPlan(String name, String id) { super(name, id); }
        @Override
        public double calculateMonthlyCharge() { return 19.99; }
    }

    static class FamilyPlan extends Subscription {
        public FamilyPlan(String name, String id) { super(name, id); }
        @Override
        public double calculateMonthlyCharge() { return 29.99; }
    }

    public static void main(String[] args) {
        Subscription[] subs = {
            new BasicPlan("Alice", "S01"),
            new PremiumPlan("Bob", "S02"),
            new FamilyPlan("Charlie", "S03"),
            new BasicPlan("Anna", "S04")
        };

        double totalRevenue = 0;
        Subscription expensive = subs[0];

        System.out.println("Subscribers starting with 'A':");
        for (Subscription sub : subs) {
            double charge = sub.calculateMonthlyCharge();
            totalRevenue += charge;
            
            if (charge > expensive.calculateMonthlyCharge()) expensive = sub;
            
            if (sub.subscriberName.startsWith("A")) {
                System.out.println("- " + sub.subscriberName);
            }
        }

        System.out.println("Total Monthly Revenue: $" + totalRevenue);
        System.out.println("Most Expensive Sub: " + expensive.subscriptionId + " ($" + expensive.calculateMonthlyCharge() + ")");
    }
}
