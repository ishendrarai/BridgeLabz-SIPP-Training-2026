public class PersonalizedMealPlanGenerator {
    public interface MealPlan {
        String getMealDetails();
    }
    
    public static class VegetarianMeal implements MealPlan {
        public String getMealDetails() { return "Vegetarian Plan"; }
    }
    
    public static class VeganMeal implements MealPlan {
        public String getMealDetails() { return "Vegan Plan"; }
    }
    
    public static class KetoMeal implements MealPlan {
        public String getMealDetails() { return "Keto Plan"; }
    }
    
    public static class HighProteinMeal implements MealPlan {
        public String getMealDetails() { return "High-Protein Plan"; }
    }
    
    public static class Meal<T extends MealPlan> {
        private T plan;
        public Meal(T plan) { this.plan = plan; }
        public T getPlan() { return plan; }
    }
    
    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealPlanType) {
        return new Meal<>(mealPlanType);
    }
}
