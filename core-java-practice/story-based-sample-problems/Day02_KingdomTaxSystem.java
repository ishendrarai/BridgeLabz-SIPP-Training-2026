public class Day02_KingdomTaxSystem {
    public static void main(String[] args) {
        double[] incomes = {5000, 12000, 45000, 60000, 9500, 52000, 15000, 8000, 20000, 75000};
        double totalTaxCollected = 0;
        
        for (int i = 0; i < incomes.length; i++) {
            double income = incomes[i];
            double tax = 0;
            String bracket = "";
            if (income < 10000) {
                tax = income * 0.05;
                bracket = "5%";
            } else if (income >= 10000 && income <= 50000) {
                tax = income * 0.15;
                bracket = "15%";
            } else {
                tax = income * 0.30;
                bracket = "30%";
            }
            totalTaxCollected += tax;
            System.out.println("Citizen " + (i + 1) + " Income: $" + income + " | Bracket: " + bracket + " | Tax: $" + tax);
        }
        System.out.println("Total Tax Collected: $" + totalTaxCollected);
    }
}
