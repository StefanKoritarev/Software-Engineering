package MVC.View;

import MVC.Controller.Controller;
import MVC.Model.Book;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BookDetailView extends Stage implements Observer {

    private static final int PADDING = 10;
    private static final int SCENE_HEIGHT = 300;
    private static final int SCENE_WIDTH = 300;

    private static final int GRID_VGAP = 8;

    private static final int GRID_HGAP = 10;
    // controller
    private Controller controller;
    // model
    private final Book book;

    //GUI Objects
    private final TextField authorTextField;
    private final TextField titleTextField;

    private final TextField descriptionTextField;

    private final TextField yearTextField;

    private final TextField pageCountTextField;
    private final TextField genreTextField;

    private Button saveButton;

    public BookDetailView(Controller controller, Book book) {
        this.book = book;
        this.controller = controller;
        this.authorTextField = new TextField(book.getAuthor());
        this.titleTextField = new TextField(book.getTitle());
        this.genreTextField = new TextField(book.getGenre());
        this.yearTextField = new TextField(book.getYear());
        this.descriptionTextField = new TextField(book.getDescription());
        this.pageCountTextField = new TextField(Integer.toString(book.getPageCount()));
        book.addObserver(this);

        generateUserInterface();
    }

    // TODO:Implement method save(). This method should update the book with the information entered by the user and save it using the controller
    private void save() {
        update();
        controller.saveBook(book);
    }

    @Override
    public void update() {
        this.authorTextField.setText(book.getAuthor());
        this.titleTextField.setText(book.getTitle());
        this.genreTextField.setText(book.getGenre());
        this.yearTextField.setText(book.getYear());
        this.descriptionTextField.setText(book.getDescription());
        this.pageCountTextField.setText(Integer.toString(book.getPageCount()));
        this.setTitle(book.toString());
    }

    private void generateUserInterface() {
        VBox vbox = new VBox();

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(PADDING));
        grid.setVgap(GRID_VGAP);
        grid.setHgap(GRID_HGAP);

        Label authorLabel = new Label("Author: ");
        GridPane.setConstraints(authorLabel, 0, 0);
        GridPane.setConstraints(authorTextField, 1, 0);

        Label titleLabel = new Label("Title ");
        GridPane.setConstraints(titleLabel, 0, 1);
        GridPane.setConstraints(titleTextField, 1, 1);

        Label genreLabel = new Label("Genre: ");
        GridPane.setConstraints(genreLabel, 0, 2);
        GridPane.setConstraints(genreTextField, 1, 2);

        Label yearLabel = new Label("Year: ");
        GridPane.setConstraints(yearLabel, 0, 3);
        GridPane.setConstraints(yearTextField, 1, 3);

        Label descriptionLabel = new Label("Description: ");
        GridPane.setConstraints(descriptionLabel, 0, 4);
        GridPane.setConstraints(descriptionTextField, 1, 4);

        Label pageCountLabel = new Label("Page count: ");
        GridPane.setConstraints(pageCountLabel, 0, 5);
        GridPane.setConstraints(pageCountTextField, 1, 5);

        saveButton = new Button("Save changes");
        GridPane.setConstraints(saveButton, 0, 6);
        saveButton.setOnAction(event -> save());

        grid.getChildren().addAll(authorLabel, titleLabel, genreLabel, yearLabel, descriptionLabel, pageCountLabel);
        grid.getChildren().addAll(authorTextField, titleTextField, genreTextField, yearTextField, descriptionTextField, pageCountTextField);
        grid.getChildren().add(saveButton);
        vbox.getChildren().add(grid);

        Scene scene = new Scene(vbox, SCENE_WIDTH, SCENE_HEIGHT);
        setScene(scene);
        if (this.book.getTitle() != null) {
            setTitle(this.book.getAuthor() + " " + this.book.getTitle());
        } else {
            setTitle("Write a new book");
        }
    }
}
