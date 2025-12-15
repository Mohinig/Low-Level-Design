package service;

import enums.ListingType;
import enums.PropertyStatus;
import helper.InputParser;
import models.Property;
import models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PropertyService {
    private  Map<Integer, Property> propertyMap = new HashMap<>();

    public void listProperty(User user, String details) {
        try {
            Map<String, Object> propData = InputParser.parsePropertyDetails(details);
            Property property = new Property(
                    (String) propData.get("title"),
                    (String) propData.get("location"),
                    (Integer) propData.get("price"),
                    (Double) propData.get("size"),
                    (String) propData.get("rooms"),
                    (ListingType) propData.get("type"),
                    (List<String>) propData.get("nearby")
            );
            propertyMap.put(property.getId(), property);
            user.getListedProperties().add(property.getId());
            System.out.println("  <-Property listed successfully with ID: " + property.getId());
        } catch (Exception e) {
            System.out.println("← Error parsing property details: " + e.getMessage());
        }
    }
    public void listProperty(User user, Property property) {

    }

    public Property getPropertyById(int id) {
        return propertyMap.get(id);
    }

    public Map<Integer, Property> getAllProperties() {
        return propertyMap;
    }

    public void viewListed(User user) {
        Set<Integer> listed = user.getListedProperties();
        for (Integer i : listed) {
            Property p = getPropertyById(i);
            System.out.printf("← ID:%d Title:%s Location:%s Price:%d Size:%.2f Rooms:%s Type:%s Status:%s\n",
                    p.getId(), p.getTitle(), p.getLocation(), p.getPrice(), p.getSize(), p.getRooms(),
                    p.getType(), p.getStatus());
        }
    }

    public void markSold(String propertyId,User user) {

        Set<Integer> listed = user.getListedProperties();
        if (listed.contains(Integer.valueOf(propertyId))) {
            Property p = getPropertyById(Integer.parseInt(propertyId));
            p.markSold();
        } else {
            System.out.println("<-Property not listed by " + user.getName());
        }
    }

    public void viewShortlisted(User user) {
        Set<Integer> shortlisted = user.getShortlistedProperties();
        for (Integer i : shortlisted) {
            Property p = getPropertyById(i);
            System.out.printf("← ID:%d Title:%s Location:%s Price:%d Size:%.2f Rooms:%s Type:%s Status:%s\n",
                    p.getId(), p.getTitle(), p.getLocation(), p.getPrice(), p.getSize(), p.getRooms(),
                    p.getType(), p.getStatus());
        }
    }

    public void shortlist(String propertyId,User user) {
        user.getShortlistedProperties().add(Integer.valueOf(propertyId));
        System.out.println("<- Shortlisted");
    }

}
