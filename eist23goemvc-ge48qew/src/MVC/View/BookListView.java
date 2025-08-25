package MVC.View;

import MVC.Controller.Controller;
import MVC.Model.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class BookListView extends Stage implements Observer {

    private static final int SCENE_WIDTH = 400;
    private static final int SCENE_HEIGHT = 400;

    // model
    private final ObservableList<Book> books;

    //GUI Objects
    private final ListView<Book> bookListView;
    // controller
    private final Controller controller;
    private Button createButton;

    public BookListView(Controller controller, List<Book> bookList) {
        this.controller = controller;
        this.books = FXCollections.observableArrayList(bookList);
        for (Book book : books) {
            book.addObserver(this);
        }
        this.bookListView = new ListView<>(books);
        generateUserInterface();
        controller.setBookListView(this);
    }
    //



    private void readBook(Book book) {
        book.addObserver(this);
        controller.displayBook(book);
    }

    // TODO: Implement writeBook(). This method should inform the controller about the creation process of a new book
    private void writeBook() {
        Book book = new Book("Stefan", "Is Ronaldo the goat", "newspaper article", "2008", "Very inspiring", 2007);
        controller.saveBook(book);
    }

    public void publishBook(Book book) {
        if (!books.contains(book)) {
            this.books.add(book);
            book.addObserver(this);
        }
    }

    @Override
    public void update() {
        displayBooks();
    }

    private void displayBooks() {
        bookListView.refresh();
    }

    private void generateUserInterface() {
        VBox vbox = new VBox();

        createButton = new Button("Write a book");
        createButton.setOnAction(event -> writeBook());

        Label bookListLabel = new Label("Book List");
        bookListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        bookListView.setOnMouseClicked(event -> readBook(bookListView.getSelectionModel().getSelectedItem()));
        vbox.getChildren().addAll(bookListLabel, bookListView, createButton);

        Scene scene = new Scene(vbox, SCENE_WIDTH, SCENE_HEIGHT);
        setScene(scene);
        setTitle("Book List");
        displayBooks();
    }
}

