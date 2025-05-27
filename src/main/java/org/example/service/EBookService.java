package org.example.service;

import org.example.modell.EBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EBookService {

    private List<EBook> books = new ArrayList<>(List.of(
            new EBook(1, "The Martian", "Andy Weir",387, 3084, "Sci-fi"),
            new EBook(2, "1984", "George Orwell", 328, 3280, "Dystopian"),
            new EBook(3, "Dune", "Frank Herbert", 800, 8960, "Sci-fi"),
            new EBook(4, "The Hobbit", "J.R.R. Tolkien", 310, 3100, "Fantasy"),
            new EBook(5, "Becoming", "Michelle Obama", 500, 4000, "Biography"),
            new EBook(6, "Clean Code", "Robert C. Martin", 452, 4604, "Programming"),
            new EBook(7, "The Alchemist", "Paulo Coelho", 155, 2008, "Fiction"),
            new EBook(8, "Sapiens", "Yuval Noah Harari", 423, 4908, "History"),
            new EBook(9, "Neuromancer", "William Gibson", 271, 2701, "Cyberpunk"),
            new EBook(10, "Atomic Habits", "James Clear", 515, 3200, "Self-help")
    ));
    private int nextId = 1;

//
//    public void addEbook(String title, String author, int price, int pages, String genre) {
//        EBook book = new EBook(nextId, title, author, pages, price, genre);
//        books.add(book);
//        nextId++;
//    }
//    public void addEbook(String title, String author, int price, int pages, String genre) {
//        int newId = books.stream()
//                .map(EBook::getId)
//                .max(Integer::compareTo)
//                .orElse(0) + 1;
//
//        books.add(new EBook(newId, title, author, price, pages, genre));
//    }
public void addEbook(String title, String author, int price, int pages, String genre) {
    int newId = books.stream()
            .map(EBook::getId)
            .max(Integer::compareTo)
            .orElse(0) + 1;

    // helyesen: pages, price
    books.add(new EBook(newId, title, author, pages, price, genre));
}

    public boolean removeById(int id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.remove(i);
                return true;
            }
        }
        return false;
    }

    public EBook findById(int id) {
        for (EBook book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public List<EBook> filterByAuthor(String author) {
        List<EBook> result = new ArrayList<>();
        for (EBook book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<EBook> filterByGenre(String genre) {
        List<EBook> result = new ArrayList<>();
        for (EBook book : books) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<EBook> sortByPriceAscending() {
        List<EBook> sorted = new ArrayList<>(books);
        for (int i = 0; i < sorted.size(); i++) {
            for (int j = i + 1; j < sorted.size(); j++) {
                if (sorted.get(i).getPrice() > sorted.get(j).getPrice()) {
                    EBook temp = sorted.get(i);
                    sorted.set(i, sorted.get(j));
                    sorted.set(j, temp);
                }
            }
        }
        return sorted;
    }

    public List<EBook> sortByPriceDescending() {
        List<EBook> sorted = new ArrayList<>(books);
        for (int i = 0; i < sorted.size(); i++) {
            for (int j = i + 1; j < sorted.size(); j++) {
                if (sorted.get(i).getPrice() < sorted.get(j).getPrice()) {
                    EBook temp = sorted.get(i);
                    sorted.set(i, sorted.get(j));
                    sorted.set(j, temp);
                }
            }
        }
        return sorted;
    }

    public List<EBook> sortByPageDescending() {
        List<EBook> sorted = new ArrayList<>(books);
        for (int i = 0; i < sorted.size(); i++) {
            for (int j = i + 1; j < sorted.size(); j++) {
                if (sorted.get(i).getPages() < sorted.get(j).getPages()) {
                    EBook temp = sorted.get(i);
                    sorted.set(i, sorted.get(j));
                    sorted.set(j, temp);
                }
            }
        }
        return sorted;
    }

    public List<EBook> listAll() {
        return new ArrayList<>(books);
    }
    public void printBooks(List<EBook> booksToPrint) {
        if (booksToPrint == null || booksToPrint.isEmpty()) {
            System.out.println("Nincs megjeleníthető könyv.");
            return;
        }

        System.out.printf("%-5s | %-20s | %-20s | %-6s | %-6s | %-12s%n",
                "ID", "Cím", "Szerző", "Oldal", "Ár", "Műfaj");
        System.out.println("----------------------------------------------------------------------");

        for (EBook book : booksToPrint) {
            System.out.printf("%-5d | %-20s | %-20s | %-6d | %-6d | %-12s%n",
                    book.getId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getPages(),
                    book.getPrice(),
                    book.getGenre());
        }
    }

}
