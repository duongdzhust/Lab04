package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    // Constructor
    public Store() {}
}

public void addMedia(Media media) {
    if (!itemsInStore.contains(media)) {
        itemsInStore.add(media);
        System.out.println(media.getTitle() + " has been added to the store.");
    } else {
        System.out.println(media.getTitle() + " is already in the store.");
    }
}


public void removeMedia(Media media) {
    if (itemsInStore.contains(media)) {
        itemsInStore.remove(media);
        System.out.println(media.getTitle() + " has been removed from the store.");
    } else {
        System.out.println(media.getTitle() + " is not in the store.");
    }
}

