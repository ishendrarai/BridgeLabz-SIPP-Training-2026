import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for (int[] p : prerequisites) adj.get(p[1]).add(p[0]);
        int[] state = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && dfs(i, adj, state)) return false;
        }
        return true;
    }
    private boolean dfs(int node, List<List<Integer>> adj, int[] state) {
        if (state[node] == 1) return true;
        if (state[node] == 2) return false;
        state[node] = 1;
        for (int next : adj.get(node)) {
            if (dfs(next, adj, state)) return true;
        }
        state[node] = 2;
        return false;
    }
}
