package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();  // Tạo đối tượng Store mới

        // Tạo các đối tượng DVD để thêm vào cửa hàng
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);

        // Thêm các DVD vào cửa hàng
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        // In thông tin của các DVD trong cửa hàng
        store.printStore();

        // Xóa một DVD khỏi cửa hàng
        store.removeDVD(dvd2);

        // In thông tin lại sau khi xóa DVD
        store.printStore();

        // Thử xóa một DVD không có trong cửa hàng
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Matrix", "Action", "The Wachowskis", 136, 19.99f);
        store.removeDVD(dvd4);

        // Kiểm tra số lượng DVD còn lại trong cửa hàng
        System.out.println("Number of DVDs in store: " + store.getQtyInStore());
    }
}
