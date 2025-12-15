package templatePattern;

import java.io.File;
import java.util.List;
import java.util.Map;

public abstract class FileParser {

    public final void parseFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists() || !file.canRead()) {
            System.out.println("← File not found or unreadable: " + filePath);
            return;
        }

        List<Map<String, Object>> records = extractData(file);
        processData(records);
        System.out.println("← Parsing complete: " + filePath);
    }

    protected abstract List<Map<String, Object>> extractData(File file);
    protected void processData(List<Map<String, Object>> records) {
        // Default: Print each record
        for (Map<String, Object> record : records) {
            System.out.println("← " + record);
        }
    }
}
