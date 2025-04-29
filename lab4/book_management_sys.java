
import java.util.*;
import java.io.*;


class Book {
    String title;
    String author;
    String hash;
    int year;

    public Book(String title, String author, String hash, int year) {
        this.title = title;
        this.year=year;
        this.author = author;
        this.hash = hash;
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<Book>();
    Set<String> unique_authors = new HashSet<String>();


    public void addBook(Book book) {
        books.add(book);
        unique_authors.add(book.author);

    }

    public void removeBook(String hash) {
        //List<Books> boks=(this.books);
        for (Book book : books) {
            if (book.hash.equals(hash)) {
                books.remove(book);
                break;
            }
        }
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println("Title: " + book.title);
            System.out.println("Author: " + book.author);
            System.out.println("Year: " + book.year);
            System.out.println("hash: " + book.hash);
            System.out.println();
        }
    }

    public void displayBooksByAuthor(String au) {
        boolean found=false;
        for (Book book : books) {
            if (book.author.equals(au))
            {
                System.out.println("Title: " + book.title);
                System.out.println("Author: " + book.author);
                System.out.println("Year: " + book.year);
                System.out.println("hash: " + book.hash);
                System.out.println();
                found = true;
                break;
            }
            }
        if(!found)
        {System.out.println("author not found");}
    }

    public void displayBooksByYear(int yee) {
        for (Book book : books) {
            if(book.year==yee)
            {
                System.out.println("Title: " + book.title);
                System.out.println("Author: " + book.author);
                System.out.println("Year: " + book.year);
                System.out.println("hash: " + book.hash);
                System.out.println();
            }
        }
    }

    public void displayUniqueAuthors() {
        for (String author : unique_authors) {
            System.out.println("Author: " + author);
            System.out.println();
        }
    }

    public void displayStatisticsByAuthor() {
        for (String auu : unique_authors) {
            int counter=0;
            for (Book book : books) {
                if(book.author.equals(auu))
                {counter++;}
            }


            System.out.println("Author: " + auu);
            System.out.println("amount of books: " + counter);
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display Books");
            System.out.println("4. Display Books by author");
            System.out.println("5. Display Books by year");
            System.out.println("6. Display unique authors");
            System.out.println("7. Display author stats");

            System.out.println("8. Exit");

            int choice = scanner.nextInt();

            if (choice == 1) {
                scanner.nextLine();
                System.out.print("Enter title: ");
                String title = scanner.nextLine();

                System.out.print("Enter author: ");
                String author = scanner.nextLine();

                System.out.print("Enter hash: ");
                String hash = scanner.nextLine();

                System.out.print("Enter year: ");
                int year = scanner.nextInt();

                System.out.println("the book added ");
                System.out.println();
                library.addBook(new Book(title, author, hash, year));

            } else if (choice == 2) {
                scanner.nextLine(); 
                System.out.print("Enter hash: ");
                String hash = scanner.nextLine();
                library.removeBook(hash);
                System.out.println("book removed ");
                System.out.println();

            } else if (choice == 3) {
                library.displayBooks();
                System.out.println();

            } else if (choice == 4) {
                System.out.print("Enter author: ");
                String cho = scanner.nextLine();
                String choi = scanner.nextLine();
                library.displayBooksByAuthor(choi);
                System.out.println();

            } else if (choice == 5) {
                System.out.print("Enter year: ");
                int year = scanner.nextInt();
                library.displayBooksByYear(year);
                System.out.println();

            } else if (choice == 6) {
                library.displayUniqueAuthors();
                System.out.println();

            } else if (choice == 7) {
                library.displayStatisticsByAuthor();
                System.out.println();

            } else if (choice == 8) {
                break;
            }
        }

        scanner.close();
    }
}
