package lab02;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestClassMembers {
    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Cinderella");

        System.out.println("DVD 1 - Title: " + dvd1.getTitle() + ", ID: " + dvd1.getId());
        System.out.println("DVD 2 - Title: " + dvd2.getTitle() + ", ID: " + dvd2.getId());
)
        System.out.println("Total DVDs created: " + DigitalVideoDisc.getNbDigitalVideoDiscs());
    }
}
