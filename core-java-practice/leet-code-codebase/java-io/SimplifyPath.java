import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");
        
        for (String comp : components) {
            if (comp.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (!comp.isEmpty() && !comp.equals(".")) {
                stack.push(comp);
            }
        }
        
        StringBuilder res = new StringBuilder();
        for (String dir : stack) {
            res.append("/").append(dir);
        }
        return res.length() > 0 ? res.toString() : "/";
    }
}
