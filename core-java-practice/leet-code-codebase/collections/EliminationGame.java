public class EliminationGame {
    public int lastRemaining(int n) {
        int head = 1, step = 1, remain = n;
        boolean left = true;
        while (remain > 1) {
            if (left || remain % 2 == 1) {
                head += step;
            }
            remain /= 2;
            step *= 2;
            left = !left;
        }
        return head;
    }
}
