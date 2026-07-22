import java.util.*;

public class MergeCustomerRecords {
    public int[] mergeLists(int[] list1, int[] list2) {
        int n = list1.length, m = list2.length;
        int[] merged = new int[n + m];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (list1[i] <= list2[j]) merged[k++] = list1[i++];
            else merged[k++] = list2[j++];
        }
        while (i < n) merged[k++] = list1[i++];
        while (j < m) merged[k++] = list2[j++];
        return merged;
    }
}
