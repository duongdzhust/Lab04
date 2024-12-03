package lab02;

import hust.soict.dsai.aims.media.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestSearchCart {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);

        cart.addDigitalVideoDisc(dvd1);
        cart.addDigitalVideoDisc(dvd2);
        cart.addDigitalVideoDisc(dvd3);

        DigitalVideoDisc foundDVD = cart.searchCart("Star Wars");
        if (foundDVD != null) {
            System.out.println("Found DVD: " + foundDVD.getTitle());
        } else {
            System.out.println("DVD not found in the cart.");
        }

        foundDVD = cart.searchCart("The Matrix");
        if (foundDVD != null) {
            System.out.println("Found DVD: " + foundDVD.getTitle());
        } else {
            System.out.println("DVD not found in the cart.");
        }
    }
}
