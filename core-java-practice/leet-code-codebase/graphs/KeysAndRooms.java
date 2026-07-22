import java.util.*;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int count = 1;
        while (!q.isEmpty()) {
            int room = q.poll();
            for (int key : rooms.get(room)) {
                if (!visited[key]) {
                    visited[key] = true;
                    q.offer(key);
                    count++;
                }
            }
        }
        return count == rooms.size();
    }
}
