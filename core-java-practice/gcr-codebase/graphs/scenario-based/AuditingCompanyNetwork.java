import java.util.*;

public class AuditingCompanyNetwork {
    int countNetworkSegments(Map<Integer, List<Integer>> network, int n) {
        Set<Integer> visited = new HashSet<>();
        int segments = 0;
        for (int server = 0; server < n; server++) {
            if (!visited.contains(server)) {
                segments++;
                dfsMark(network, server, visited);
            }
        }
        return segments;
    }
    
    void dfsMark(Map<Integer, List<Integer>> network, int node, Set<Integer> visited) {
        visited.add(node);
        for (int neighbor : network.getOrDefault(node, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                dfsMark(network, neighbor, visited);
            }
        }
    }
}
