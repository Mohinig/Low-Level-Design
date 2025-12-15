package helper;

public class SizeParser {
    public static double parse(String sizeStr) {
        sizeStr = sizeStr.toLowerCase().replace(" ", "");
        double factor = 1.0;
        if (sizeStr.contains("sqm")) factor = 10.7639;
        else if (sizeStr.contains("sqyd")) factor = 9;
        String digits = sizeStr.replaceAll("[^\\d.]", "");
        return Double.parseDouble(digits) * factor;
    }
}
