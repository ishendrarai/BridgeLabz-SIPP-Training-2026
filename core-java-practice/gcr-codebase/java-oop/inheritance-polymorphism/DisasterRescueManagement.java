public class DisasterRescueManagement {
    static class RescueTeam {
        String teamId;
        String location;

        public RescueTeam(String id, String loc) {
            this.teamId = id;
            this.location = loc;
        }

        public void performDuty() {
            System.out.println("Performing generic rescue duties.");
        }
    }

    static class MedicalTeam extends RescueTeam {
        public MedicalTeam(String id, String loc) { super(id, loc); }
        @Override
        public void performDuty() { System.out.println(teamId + " is providing medical aid at " + location); }
    }

    static class FireRescueTeam extends RescueTeam {
        public FireRescueTeam(String id, String loc) { super(id, loc); }
        @Override
        public void performDuty() { System.out.println(teamId + " is extinguishing fires at " + location); }
    }

    static class FoodSupplyTeam extends RescueTeam {
        public FoodSupplyTeam(String id, String loc) { super(id, loc); }
        @Override
        public void performDuty() { System.out.println(teamId + " is distributing food at " + location); }
    }

    public static void main(String[] args) {
        RescueTeam[] teams = {
            new MedicalTeam("MED-01", "Zone A"),
            new FireRescueTeam("FIRE-01", "Zone B"),
            new MedicalTeam("MED-02", "Zone B"),
            new FoodSupplyTeam("FOOD-01", "Zone C")
        };

        int med = 0, fire = 0, food = 0;
        for (RescueTeam t : teams) {
            t.performDuty();
            if (t instanceof MedicalTeam) med++;
            else if (t instanceof FireRescueTeam) fire++;
            else if (t instanceof FoodSupplyTeam) food++;
        }

        System.out.println("Deployments -> Med: " + med + ", Fire: " + fire + ", Food: " + food);
        
        String maxCategory = "Medical";
        int max = med;
        if (fire > max) { max = fire; maxCategory = "FireRescue"; }
        if (food > max) { max = food; maxCategory = "FoodSupply"; }

        System.out.println("Category with max deployments: " + maxCategory);
    }
}
