import java.util.Arrays;
import java.util.Comparator;

public class EmployeeAttendanceRanking {
    public int[] topKEmployees(int[] employeeIds, int[] attendance, int k) {
        Integer[] indices = new Integer[employeeIds.length];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> {
            if (attendance[a] != attendance[b]) {
                return Integer.compare(attendance[b], attendance[a]); // Descending
            }
            return Integer.compare(employeeIds[a], employeeIds[b]); // Ascending
        });
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = employeeIds[indices[i]];
        }
        return result;
    }
}
