import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyURL {
    private Map<String, String> urlToCode = new HashMap<>();
    private Map<String, String> codeToUrl = new HashMap<>();
    private String base = "http://tinyurl.com/";
    private int counter = 0;

    public String encode(String longUrl) {
        if (urlToCode.containsKey(longUrl)) {
            return base + urlToCode.get(longUrl);
        }
        String code = String.valueOf(counter++);
        urlToCode.put(longUrl, code);
        codeToUrl.put(code, longUrl);
        return base + code;
    }

    public String decode(String shortUrl) {
        String code = shortUrl.replace(base, "");
        return codeToUrl.get(code);
    }
}
