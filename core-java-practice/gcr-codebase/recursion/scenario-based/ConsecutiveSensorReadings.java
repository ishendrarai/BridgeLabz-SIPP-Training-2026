public class ConsecutiveSensorReadings {
    public static boolean isStrictlyIncreasing(int[] readings, int index) {
        if (index == readings.length - 1) return true;
        if (readings[index] >= readings[index + 1]) return false;
        return isStrictlyIncreasing(readings, index + 1);
    }

    public static void main(String[] args) {
        int[] input1 = {12, 15, 18, 22, 30};
        System.out.println("Output: " + isStrictlyIncreasing(input1, 0));

        int[] input2 = {12, 15, 14, 22};
        System.out.println("Output: " + isStrictlyIncreasing(input2, 0));
    }
}
