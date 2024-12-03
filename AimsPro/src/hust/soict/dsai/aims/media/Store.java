package hust.soict.dsai.aims.media;

public class Store {
    private DigitalVideoDisc[] itemsInStore;  // Mảng lưu trữ các DVD trong cửa hàng
    private int qtyInStore;  // Số lượng DVD trong cửa hàng
    private static final int MAX_CAPACITY = 50;  // Giới hạn số lượng DVD có thể có trong cửa hàng

    public Store() {
        itemsInStore = new DigitalVideoDisc[MAX_CAPACITY];
        qtyInStore = 0;
    }

    // Phương thức để thêm DVD vào cửa hàng
    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < MAX_CAPACITY) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println(dvd.getTitle() + " has been added to the store.");
        } else {
            System.out.println("Cannot add more DVDs. The store is full.");
        }
    }

    // Phương thức để xóa DVD khỏi cửa hàng
    public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i].getTitle().equals(dvd.getTitle())) {
                found = true;
                // Di chuyển các DVD còn lại sang trái để lấp đầy khoảng trống
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;
                System.out.println(dvd.getTitle() + " has been removed from the store.");
                break;
            }
        }
        if (!found) {
            System.out.println("The DVD " + dvd.getTitle() + " is not in the store.");
        }
    }

    // Phương thức để lấy số lượng DVD hiện có trong cửa hàng
    public int getQtyInStore() {
        return qtyInStore;
    }

    // Phương thức để in thông tin DVD trong cửa hàng
    public void printStore() {
        System.out.println("************* STORE *************");
        for (int i = 0; i < qtyInStore; i++) {
            DigitalVideoDisc dvd = itemsInStore[i];
            System.out.println((i + 1) + ". DVD - " + dvd.getTitle() + " - " 
                               + dvd.getCategory() + " - " 
                               + dvd.getDirector() + " - " 
                               + dvd.getLength() + ": " 
                               + dvd.getCost() + "$");
        }
        System.out.println("********************************");
    }
}
