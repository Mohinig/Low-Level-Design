package helper;

public class PriceParser {
    public static int parse(String priceStr) {
        priceStr = priceStr.toLowerCase().replace(",", "").trim();
        if (priceStr.endsWith("k")) return Integer.parseInt(priceStr.replace("k", "")) * 1000;
        if (priceStr.endsWith("l")) return Integer.parseInt(priceStr.replace("l", "")) * 100000;
        if (priceStr.endsWith("cr")) return Integer.parseInt(priceStr.replace("cr", "")) * 10000000;
        return Integer.parseInt(priceStr);
    }
}
