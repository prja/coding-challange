package prja.leetcode.challange.lambda;
import java.util.Arrays;
import java.util.List;

public class Book {
    private String title;
    private String author;
    private String genre;
    private int publicationYear;
    private double rating;

    public Book(String title, String author, String genre, int publicationYear, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", publicationYear=" + publicationYear +
                ", rating=" + rating +
                '}';
    }
}
