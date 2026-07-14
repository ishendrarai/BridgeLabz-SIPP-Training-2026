import java.util.Stack;

public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int maxLen = 0;
        String[] lines = input.split("\n");
        for (String s : lines) {
            int level = s.lastIndexOf("\t") + 1;
            while (stack.size() > level + 1) stack.pop();
            int len = stack.peek() + s.length() - level + 1;
            stack.push(len);
            if (s.contains(".")) {
                maxLen = Math.max(maxLen, len - 1);
            }
        }
        return maxLen;
    }
}
