package helper;

import enums.ListingType;

import java.util.*;

public class InputParser {

   public static Map<String, Object> parsePropertyDetails(String input) throws IllegalArgumentException {
        String[] parts = input.split(",");
       if (parts.length < 7) {
           throw new IllegalArgumentException("<-Incomplete property details. Expected format: title, location, price, size, rooms, type, nearby1|nearby2|...");
       }
        String title = parts[0].trim();
        String location = parts[1].trim().toLowerCase();
        int price = PriceParser.parse(parts[2].trim());
        double size = SizeParser.parse(parts[3].trim());
        String rooms = parts[4].trim().toLowerCase();
        ListingType type = ListingType.valueOf(parts[5].trim().toUpperCase());
        List<String> nearby = Arrays.asList(parts[6].trim().toLowerCase().split("\\|"));

        Map<String, Object> propertyData = new HashMap<>();
        propertyData.put("title", title);
        propertyData.put("location", location);
        propertyData.put("price", price);
        propertyData.put("size", size);
        propertyData.put("rooms", rooms);
        propertyData.put("type", type);
        propertyData.put("nearby", nearby);
        return propertyData;
    }

     public static Map<String, String> parseFilters(String input) {
        Map<String, String> filters = new HashMap<>();
        String[] parts = input.trim().split("\\s+");
        for (String part : parts) {
            if (part.contains("=")) {
                String[] kv = part.split("=", 2);
                filters.put(kv[0].toLowerCase(), kv[1].toLowerCase());
            }
        }
        return filters;
    }
}
