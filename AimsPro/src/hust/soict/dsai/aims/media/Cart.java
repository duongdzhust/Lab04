package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    // Constructor
    public Cart() {}
}
public void addMedia(Media media) {
    if (!itemsOrdered.contains(media)) {
        itemsOrdered.add(media);
        System.out.println(media.getTitle() + " has been added to the cart.");
    } else {
        System.out.println(media.getTitle() + " is already in the cart.");
    }
}

public void removeMedia(Media media) {
    if (itemsOrdered.contains(media)) {
        itemsOrdered.remove(media);
        System.out.println(media.getTitle() + " has been removed from the cart.");
    } else {
        System.out.println(media.getTitle() + " is not in the cart.");
    }
}
public float totalCost() {
    float total = 0;
    for (Media media : itemsOrdered) {
        total += media.getCost();
    }
    return total;
}


