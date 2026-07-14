public class AddDigits {
    public static int addDigits(int num) {
        if (num < 10) return num;
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return addDigits(sum);
    }

    public static void main(String[] args) {
        System.out.println("Add digits 38: " + addDigits(38));
        System.out.println("Add digits 0: " + addDigits(0));
    }
}
