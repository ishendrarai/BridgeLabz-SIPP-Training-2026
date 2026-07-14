import java.util.ArrayList;
import java.util.List;

public class GenerateSubsets {
    public static void generateSubsets(int[] arr, int index, List<Integer> currentSubset) {
        if (index == arr.length) {
            System.out.println(currentSubset);
            return;
        }

        // Exclude current element
        generateSubsets(arr, index + 1, currentSubset);

        // Include current element
        currentSubset.add(arr[index]);
        generateSubsets(arr, index + 1, currentSubset);
        currentSubset.remove(currentSubset.size() - 1); // backtrack
    }

    public static void main(String[] args) {
        int[] arr = {1, 2};
        System.out.println("Input:\n[1,2]");
        System.out.println("Output:");
        generateSubsets(arr, 0, new ArrayList<>());
    }
}
