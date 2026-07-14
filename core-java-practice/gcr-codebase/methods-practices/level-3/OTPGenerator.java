import java.util.HashSet;
import java.util.Set;

public class OTPGenerator {
    public static int generateOTP() {
        return (int) (Math.random() * 900000) + 100000;
    }

    public static boolean areUnique(int[] otps) {
        Set<Integer> set = new HashSet<>();
        for (int otp : otps) {
            if (!set.add(otp)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] otps = new int[10];
        for (int i = 0; i < 10; i++) {
            otps[i] = generateOTP();
            System.out.println("OTP " + (i + 1) + ": " + otps[i]);
        }

        if (areUnique(otps)) {
            System.out.println("All 10 OTPs are uniquely generated.");
        } else {
            System.out.println("Duplicate OTPs found.");
        }
    }
}
