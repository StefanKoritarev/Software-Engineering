package MVC.Controller;

import MVC.Model.Book;
import MVC.View.BookDetailView;
import MVC.View.BookListView;
import MVC.View.Observer;

public class Controller {

    private BookListView bookListView;
    private BookDetailView bookDetailView;

    // TODO: Implement saveBook(). This method should add the book to the list view and notify the observers
    public void saveBook(Book book) {
        bookListView.publishBook(book);
        book.notifyObservers();
    }

    // TODO: Implement displayBook(). This method should initialize bookDetailView and display it
    public void displayBook(Book book) {
        bookDetailView = new BookDetailView(this, book);
        bookDetailView.show();
    }


    public void setBookListView(BookListView bookListView) {
        this.bookListView = bookListView;
    }
}
