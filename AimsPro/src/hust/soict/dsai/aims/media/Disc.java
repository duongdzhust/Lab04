package hust.soict.dsai.aims.media;

public class Disc extends Media {
    private int length;
    private String director;

    // Constructor
    public Disc() {}

    public Disc(int id, String title, String category, float cost, int length, String director) {
        super.setId(id);
        super.setTitle(title);
        super.setCategory(category);
        super.setCost(cost);
        this.length = length;
        this.director = director;
    }

    // Getter methods
    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }
}
