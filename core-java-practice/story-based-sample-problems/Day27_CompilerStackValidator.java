import java.util.Stack;
import java.util.Arrays;

public class Day27_CompilerStackValidator {
    public static void main(String[] args) {
        String code = "{ [ ( ) ] }";
        System.out.println("Is code balanced? " + isBalanced(code));
        
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        System.out.println("Prices: " + Arrays.toString(prices));
        System.out.println("Next Greater Price: " + Arrays.toString(nextGreaterElement(prices)));
        System.out.println("Stock Span: " + Arrays.toString(calculateSpan(prices)));
    }
    
    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ' ') continue;
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    
    public static int[] nextGreaterElement(int[] prices) {
        int[] res = new int[prices.length];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] < prices[i]) {
                res[stack.pop()] = prices[i];
            }
            stack.push(i);
        }
        return res;
    }
    
    public static int[] calculateSpan(int[] prices) {
        int[] span = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        return span;
    }
}
