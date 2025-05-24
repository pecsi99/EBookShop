package org.example.modell;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Objects;
//@Component("EBook")
@Setter
@Getter
public class EBook {
    public int id;
    public String title;
    public String author;
    public int pages;
    public int price;
    public String genre;

    public EBook(int id, String title, String author, int pages, int price, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EBook eBook = (EBook) o;
        return id == eBook.id && pages == eBook.pages && price == eBook.price && Objects.equals(title, eBook.title) && Objects.equals(author, eBook.author) && Objects.equals(genre, eBook.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, pages, price);
    }

    @Override
    public String toString() {
        return "EBook{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", price=" + price +
                ", genre='" + genre + '\'' +
                '}';
    }
}
