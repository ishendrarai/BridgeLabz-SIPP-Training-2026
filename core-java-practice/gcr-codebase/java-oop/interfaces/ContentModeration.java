public class ContentModeration {
    interface TextModeration {
        boolean isOffensive(String post);
        default void displayModerationPolicy() {
            System.out.println("TextModeration: We do not allow offensive words.");
        }
        
        static boolean containsRestrictedWords(String post) {
            String[] restricted = {"badword1", "badword2", "hate"};
            for (String word : restricted) {
                if (post.toLowerCase().contains(word)) return true;
            }
            return false;
        }
    }

    interface SpamDetection {
        boolean isSpam(String post);
        default void displayModerationPolicy() {
            System.out.println("SpamDetection: Links and repeated messages are spam.");
        }
    }

    static class ContentModerator implements TextModeration, SpamDetection {
        @Override
        public boolean isOffensive(String post) {
            return TextModeration.containsRestrictedWords(post);
        }

        @Override
        public boolean isSpam(String post) {
            return post.contains("http") || post.contains("buy now");
        }

        @Override
        public void displayModerationPolicy() {
            TextModeration.super.displayModerationPolicy();
            SpamDetection.super.displayModerationPolicy();
        }
    }

    public static void main(String[] args) {
        String[] posts = {
            "Hello everyone, how are you?",
            "Click here to buy now: http://spam.com",
            "This is a hate message.",
            "I love this community!"
        };

        ContentModerator mod = new ContentModerator();
        mod.displayModerationPolicy();
        System.out.println("--- Analysis ---");

        for (String post : posts) {
            System.out.print("Post: '" + post + "' -> ");
            if (mod.isSpam(post)) System.out.println("SPAM");
            else if (mod.isOffensive(post)) System.out.println("OFFENSIVE");
            else System.out.println("VALID");
        }
    }
}
