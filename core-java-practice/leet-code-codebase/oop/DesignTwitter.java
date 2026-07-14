import java.util.*;

public class DesignTwitter {
    private static int timeStamp = 0;
    
    private Map<Integer, User> userMap;

    private class Tweet {
        public int id;
        public int time;
        public Tweet next;

        public Tweet(int id) {
            this.id = id;
            time = timeStamp++;
            next = null;
        }
    }

    private class User {
        public int id;
        public Set<Integer> followed;
        public Tweet tweetHead;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id); // first follow itself
            tweetHead = null;
        }

        public void follow(int id) {
            followed.add(id);
        }

        public void unfollow(int id) {
            followed.remove(id);
        }

        public void post(int id) {
            Tweet t = new Tweet(id);
            t.next = tweetHead;
            tweetHead = t;
        }
    }

    public DesignTwitter() {
        userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        userMap.putIfAbsent(userId, new User(userId));
        userMap.get(userId).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();
        if (!userMap.containsKey(userId)) return res;

        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> q = new PriorityQueue<>(users.size(), (a, b) -> (b.time - a.time));
        
        for (int user : users) {
            Tweet t = userMap.get(user).tweetHead;
            if (t != null) {
                q.add(t);
            }
        }
        
        int n = 0;
        while (!q.isEmpty() && n < 10) {
            Tweet t = q.poll();
            res.add(t.id);
            n++;
            if (t.next != null) {
                q.add(t.next);
            }
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        userMap.putIfAbsent(followerId, new User(followerId));
        userMap.putIfAbsent(followeeId, new User(followeeId));
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followerId == followeeId) return;
        userMap.get(followerId).unfollow(followeeId);
    }
}
