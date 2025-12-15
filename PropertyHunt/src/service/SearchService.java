package service;

import enums.PropertyStatus;
import models.Property;
import helper.*;
import java.util.*;
import java.util.stream.Collectors;

public class SearchService {
    private PropertyService propertyService;

    public SearchService(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    public void search(String filtersStr) {
        if (filtersStr.length() == 0) {
            Map<Integer, Property> res = propertyService.getAllProperties();
            if (res.isEmpty()) {
                System.out.println("← No properties found matching filters.");
            }
            for (Map.Entry<Integer, Property> m : res.entrySet()) {
                Property p = m.getValue();
                if(p.getStatus()== PropertyStatus.SOLD)
                    continue;
                System.out.printf("← ID:%d Title:%s Location:%s Price:%d Size:%.2f Rooms:%s Type:%s Status:%s\n",
                        p.getId(), p.getTitle(), p.getLocation(), p.getPrice(), p.getSize(), p.getRooms(),
                        p.getType(), p.getStatus());
            }
        } else {
            Map<String, String> filters = InputParser.parseFilters(filtersStr);
            List<Property> results = search(filters);
            if (results.isEmpty()) {
                System.out.println("← No properties found matching filters.");
            } else {
                System.out.println("← Found " + results.size() + " properties:");
                for (Property p : results) {
                    if(p.getStatus()== PropertyStatus.SOLD)
                        continue;
                    System.out.printf("← ID:%d Title:%s Location:%s Price:%d Size:%.2f Rooms:%s Type:%s Status:%s\n",
                            p.getId(), p.getTitle(), p.getLocation(), p.getPrice(), p.getSize(), p.getRooms(),
                            p.getType(), p.getStatus());
                }
            }
        }
    }
    public List<Property> search(Map<String, String> filters) {
        List<Property> results = new ArrayList<>(propertyService.getAllProperties().values());
        for (Map.Entry<String, String> entry : filters.entrySet()) {
            String key = entry.getKey().toLowerCase();
            String value = entry.getValue().toLowerCase();

            switch (key) {
                case "location":
                    List<String> locations = Arrays.stream(value.split(",")).map(String::trim).toList();
                    results = results.stream()
                            .filter(p -> locations.contains(p.getLocation()) ||
                                    p.getNearbyLocations().stream().anyMatch(locations::contains))
                            .collect(Collectors.toList());
                    break;
                case "pricerange":
                    String[] priceParts = value.split("-");
                    int minP = PriceParser.parse(priceParts[0]);
                    int maxP = priceParts.length > 1 ? PriceParser.parse(priceParts[1]) : Integer.MAX_VALUE;
                    results = results.stream()
                            .filter(p -> p.getPrice() >= minP && p.getPrice() <= maxP)
                            .collect(Collectors.toList());
                    break;
                case "sizerange":
                    String[] sizeParts = value.split("-");
                    double minS = SizeParser.parse(sizeParts[0]);
                    double maxS = sizeParts.length > 1 ? SizeParser.parse(sizeParts[1]) : Double.MAX_VALUE;
                    results = results.stream()
                            .filter(p -> p.getSize() >= minS && p.getSize() <= maxS)
                            .collect(Collectors.toList());
                    break;
                case "type":
                    results = results.stream()
                            .filter(p -> p.getType().toString().equalsIgnoreCase(value))
                            .collect(Collectors.toList());
                    break;
                case "rooms":
                    List<String> rooms = Arrays.asList(value.split(","));
                    results = results.stream()
                            .filter(p -> rooms.contains(p.getRooms()))
                            .collect(Collectors.toList());
                    break;
                case "sort":
                    if (value.equals("price")) {
                        results = results.stream()
                                .sorted(Comparator.comparingInt(Property::getPrice))
                                .collect(Collectors.toList());
                    } else if (value.equals("size")) {
                        results = results.stream()
                                .sorted(Comparator.comparingDouble(Property::getSize))
                                .collect(Collectors.toList());
                    }
                    break;
            }
        }
        results = results.stream()
                .filter(p -> p.getStatus().toString().equalsIgnoreCase("AVAILABLE"))
                .collect(Collectors.toList());
        return results;
    }
}
