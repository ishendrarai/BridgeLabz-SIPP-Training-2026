import java.util.Arrays;

public class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            int split1 = log1.indexOf(" ");
            String id1 = log1.substring(0, split1);
            String content1 = log1.substring(split1 + 1);

            int split2 = log2.indexOf(" ");
            String id2 = log2.substring(0, split2);
            String content2 = log2.substring(split2 + 1);

            boolean isDigit1 = Character.isDigit(content1.charAt(0));
            boolean isDigit2 = Character.isDigit(content2.charAt(0));

            if (!isDigit1 && !isDigit2) {
                int cmp = content1.compareTo(content2);
                if (cmp != 0) return cmp;
                return id1.compareTo(id2);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }
}
