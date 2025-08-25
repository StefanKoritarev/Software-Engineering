package MVC.Model;

public class Book extends Observable {
    // TODO: Add attributes, implement constructor, getters and setters

    private String author;
    private String title;
    private String genre;
    private String year;

    private String description;
    private int pageCount;

    public Book(String author, String title, String genre, String year, String description, int pageCount) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.description = description;
        this.pageCount = pageCount;
    }

    // Create empty stub book
    public Book() {
    }


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return this.getAuthor() + " " + this.getTitle();
    }
}
