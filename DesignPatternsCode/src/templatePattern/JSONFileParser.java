package templatePattern;

import java.io.*;
import java.util.*;
//import com.fasterxml.jackson.databind.*;

public class JSONFileParser extends FileParser {

    @Override
    protected List<Map<String, Object>> extractData(File file) {
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            return mapper.readValue(file, List.class);
//        } catch (IOException e) {
//            System.out.println("← Error reading JSON: " + e.getMessage());
//            return Collections.emptyList();
//        }
//    }
        List<Map<String, Object>> o = null;
        return o;
    }
}


