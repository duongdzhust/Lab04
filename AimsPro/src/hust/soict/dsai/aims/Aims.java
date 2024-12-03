package hust.soict.dsai.aims;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class Aims {
    private static final Store store = new Store();
    private static final Cart cart = new Cart();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1 -> viewStore(scanner);
                case 2 -> updateStore(scanner);
                case 3 -> seeCurrentCart(scanner);
                case 0 -> System.out.println("Exiting AIMS. Goodbye!");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    private static void viewStore(Scanner scanner) {
        int choice;
        do {
            store.printStore(); // Display all items in the store
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1 -> seeMediaDetails(scanner); // View details of a media
                case 2 -> addMediaToCart(scanner); // Add media to cart
                case 3 -> playMedia(scanner); // Play a media
                case 4 -> seeCurrentCart(scanner); // View the current cart
                case 0 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
    }

    private static void updateStore(Scanner scanner) {
        System.out.println("1. Add a media");
        System.out.println("2. Remove a media");
        System.out.println("Choose an option:");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            System.out.println("Enter media details (id, title, category, cost):");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            String title = scanner.nextLine();
            String category = scanner.nextLine();
            float cost = scanner.nextFloat();
            Media media = new Media(id, title, category, cost);
            store.addMedia(media);
        } else if (choice == 2) {
            System.out.println("Enter media title to remove:");
            String title = scanner.nextLine();
            store.removeMedia(title);
        } else {
            System.out.println("Invalid choice!");
        }
    }

    private static void seeCurrentCart(Scanner scanner) {
        cart.printCart();
        int choice;
        do {
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1 -> filterCart(scanner); // Filter media in cart
                case 2 -> sortCart(scanner); // Sort media in cart
                case 3 -> removeFromCart(scanner); // Remove media from cart
                case 4 -> playMedia(scanner); // Play a media
                case 5 -> placeOrder(); // Place an order
                case 0 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
    }

    private static void seeMediaDetails(Scanner scanner) {
        System.out.println("Enter media title:");
        String title = scanner.nextLine();
        Media media = store.getMediaByTitle(title);
        if (media != null) {
            System.out.println(media.toString());
            mediaDetailsMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1 -> cart.addMedia(media);
                case 2 -> {
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                }
                case 0 -> System.out.println("Returning to store menu...");
                default -> System.out.println("Invalid choice!");
            }
        } else {
            System.out.println("Media not found!");
        }
    }

    private static void addMediaToCart(Scanner scanner) {
        System.out.println("Enter media title:");
        String title = scanner.nextLine();
        Media media = store.getMediaByTitle(title);
        if (media != null) {
            cart.addMedia(media);
        } else {
            System.out.println("Media not found!");
        }
    }

    private static void playMedia(Scanner scanner) {
        System.out.println("Enter media title:");
        String title = scanner.nextLine();
        Media media = store.getMediaByTitle(title);
        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    private static void filterCart(Scanner scanner) {
        System.out.println("Filter by:");
        System.out.println("1. ID");
        System.out.println("2. Title");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        cart.filter(choice);
    }

    private static void sortCart(Scanner scanner) {
        System.out.println("Sort by:");
        System.out.println("1. Title");
        System.out.println("2. Cost");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (choice == 1) {
            cart.sortByTitleCost();
        } else if (choice == 2) {
            cart.sortByCostTitle();
        } else {
            System.out.println("Invalid choice!");
        }
    }

    private static void removeFromCart(Scanner scanner) {
        System.out.println("Enter media title to remove:");
        String title = scanner.nextLine();
        cart.removeMediaByTitle(title);
    }

    private static void placeOrder() {
        System.out.println("Order placed successfully!");
        cart.clear();
    }
}
