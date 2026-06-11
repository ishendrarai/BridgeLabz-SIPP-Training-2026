public class KingdomTax {

    public static void main(String[] args) {

        
        double income = 45000;
        double tax = 0;

        
        if (income < 10000) {
            tax = income * 0.05;
            System.out.println("Tax Bracket : 5%");
        } else if (income <= 50000) {
            tax = income * 0.15;
            System.out.println("Tax Bracket : 15%");
        } else {
            tax = income * 0.30;
            System.out.println("Tax Bracket : 30%");
        }

        System.out.println("Income      : " + income);
        System.out.println("Tax Amount  : " + tax);

        System.out.println("\n----- Tax Collection Report -----");

        
        double[] incomes = {8000, 12000, 25000, 55000, 70000,
                            9500, 40000, 51000, 30000, 15000};

        double totalTax = 0;

        
        for (int i = 0; i < incomes.length; i++) {
            double currentTax;

            if (incomes[i] < 10000) {
                currentTax = incomes[i] * 0.05;
            } else if (incomes[i] <= 50000) {
                currentTax = incomes[i] * 0.15;
            } else {
                currentTax = incomes[i] * 0.30;
            }

            totalTax = totalTax + currentTax;

            System.out.println("Citizen " + (i + 1) +
                               " | Income: " + incomes[i] +
                               " | Tax: " + currentTax);
        }

        System.out.println("-------------------------------");
        System.out.println("Total Tax Collected: " + totalTax);
    }
}