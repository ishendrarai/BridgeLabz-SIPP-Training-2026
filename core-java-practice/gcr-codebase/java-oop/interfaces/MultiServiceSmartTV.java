public class MultiServiceSmartTV {
    interface StreamingService {
        void playMovie();
        default void showSubscriptionDetails() {
            System.out.println("StreamingService: Premium Plan ($15/mo)");
        }
    }

    interface GamingService {
        void playGame();
        default void showSubscriptionDetails() {
            System.out.println("GamingService: Gold Plan ($10/mo)");
        }
    }

    static class SmartTV implements StreamingService, GamingService {
        String[] movies;
        String[] games;

        public SmartTV(String[] movies, String[] games) {
            this.movies = movies;
            this.games = games;
        }

        @Override
        public void playMovie() {
            System.out.println("Playing movies...");
            for (String m : movies) System.out.println("- " + m);
        }

        @Override
        public void playGame() {
            System.out.println("Launching games...");
            for (String g : games) System.out.println("- " + g);
        }

        @Override
        public void showSubscriptionDetails() {
            StreamingService.super.showSubscriptionDetails();
            GamingService.super.showSubscriptionDetails();
            System.out.println("SmartTV: Combined Plan applied.");
        }
    }

    public static void main(String[] args) {
        String[] movies = {"Inception", "Interstellar"};
        String[] games = {"Minecraft", "The Witcher 3"};

        SmartTV tv = new SmartTV(movies, games);
        tv.playMovie();
        tv.playGame();
        tv.showSubscriptionDetails();
    }
}
