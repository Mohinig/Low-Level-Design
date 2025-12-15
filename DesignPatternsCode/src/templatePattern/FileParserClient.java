package templatePattern;


import templatePattern.CSVFileParser;
import templatePattern.FileParser;
import templatePattern.JSONFileParser;

public class FileParserClient {
    public static void main(String[] args) {
        FileParser csvParser = new CSVFileParser();
        csvParser.parseFile("data/sample.csv");

        FileParser jsonParser = new JSONFileParser();
        jsonParser.parseFile("data/sample.json");
    }
}

