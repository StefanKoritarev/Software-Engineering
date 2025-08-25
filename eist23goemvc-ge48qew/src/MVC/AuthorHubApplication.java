package MVC;
import java.util.*;
import MVC.Controller.Controller;
import MVC.Model.Book;
import MVC.View.BookListView;
import javafx.application.Application;
import javafx.stage.Stage;

public final class AuthorHubApplication extends Application {

    /**
     * main method in order to be called from AuthorHub Main.
     */
    public static void startApp(String[] args) {
        launch(args);
    }

    /**
     * This method is setting up everything for local testing.
     * Uncomment it.
     */
    @Override
    public void start(Stage primaryStage) {

        List<Book> books = new ArrayList<>();
        Book orwell = new Book("George Orwell", "1984", "Dystopian", "1949", "A dystopian novel set in Airstrip One, formerly Great Britain, a province of the superstate Oceania", 328);
        books.add(orwell);
        Book colleen = new Book("Colleen Hoover", "It Ends with Us", "Romance", "2016", "A powerful novel that delivers a very personal message about domestic violence", 376);
        books.add(colleen);
        Book rowling = new Book("J.K. Rowling", "Harry Potter and the Philosopher's Stone", "Fantasy", "1997", "A young wizard's magical education and fight against evil", 223);
        books.add(rowling);
        Book jane = new Book("Jane Austen", "Pride and Prejudice", "Classic", "1813", "A comedy of manners in early 19th-century England", 279);
        books.add(jane);


        Controller controller = new Controller();

        BookListView bookListView = new BookListView(controller, books);
        bookListView.show();

    }

}
