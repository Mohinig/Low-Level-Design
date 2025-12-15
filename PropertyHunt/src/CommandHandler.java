import enums.PropertyStatus;
import helper.InputParser;
import models.Property;
import models.User;
import service.PropertyService;
import service.SearchService;
import service.UserService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CommandHandler {
    UserService userService = new UserService();
    PropertyService propertyService = new PropertyService();
    SearchService searchService = new SearchService(propertyService);

    Scanner scanner = new Scanner(System.in);
    public void handle(){
        while (true) {
            System.out.print("→ ");
            String cmd = scanner.nextLine().trim().toLowerCase();

            switch (cmd) {
                case "register" -> {
                    System.out.print("<-Enter name: ");
                    String name = scanner.nextLine().trim();
                    userService.register(name);
                }
                case "login" -> {
                    System.out.print("<-Enter name: ");
                    String name = scanner.nextLine().trim();
                    userService.login(name);
                }
                case "logout" -> userService.logout();

                case "listproperty" -> {
                    User user = userService.getActiveUser();
                    if (user == null) {
                        System.out.println("← Please login first.");
                        continue;
                    }
                    System.out.println("<-Enter details (title, location, price, size, rooms, type, nearby1|nearby2|...):");
                    String details = scanner.nextLine();
                    propertyService.listProperty(user,details);
                }

                case "search" -> {
                    System.out.println("<-Enter filters (e.g., location=baner,pune pricerange=50k-1cr type=sell rooms=2bhk,3bhk):");
                    String filtersStr = scanner.nextLine();
                    searchService.search(filtersStr);
                }
                case "shortlist" -> {
                    System.out.print("<-Enter propertyId: ");
                    String propertyId = scanner.nextLine().trim();
                    User user=userService.getActiveUser();
                    propertyService.shortlist(propertyId,user);
                }
                case "viewshortlisted" -> {
                    User user = userService.getActiveUser();
                    propertyService.viewShortlisted(user);
                }
                case "viewlisted" -> {
                    User user = userService.getActiveUser();
                    propertyService.viewListed(user);
                }
                case "marksold" -> {
                    System.out.print("<-Enter propertyId: ");
                    String propertyId = scanner.nextLine().trim();
                    User user = userService.getActiveUser();
                    propertyService.markSold(propertyId,user);
                }
                case "exit" -> {
                    System.out.println("← Exiting...");
                    return;
                }

                default -> System.out.println("← Invalid command");
            }
        }
    }

}
