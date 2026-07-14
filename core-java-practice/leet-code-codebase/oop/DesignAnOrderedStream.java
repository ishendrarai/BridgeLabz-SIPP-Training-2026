import java.util.ArrayList;
import java.util.List;

public class DesignAnOrderedStream {
    private String[] stream;
    private int ptr;

    public DesignAnOrderedStream(int n) {
        stream = new String[n];
        ptr = 0;
    }

    public List<String> insert(int idKey, String value) {
        stream[idKey - 1] = value;
        List<String> res = new ArrayList<>();
        while (ptr < stream.length && stream[ptr] != null) {
            res.add(stream[ptr]);
            ptr++;
        }
        return res;
    }
}
