package templatePattern;


import java.io.*;
import java.util.*;

public class CSVFileParser extends FileParser {

    @Override
    protected List<Map<String, Object>> extractData(File file) {
        List<Map<String, Object>> records = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String[] headers = reader.readLine().split(",");
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                Map<String, Object> row = new LinkedHashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    row.put(headers[i].trim(), fields[i].trim());
                }
                records.add(row);
            }
        } catch (IOException e) {
            System.out.println("← Error reading CSV: " + e.getMessage());
        }
        return records;
    }
}
