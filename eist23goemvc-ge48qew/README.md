# Model View Controller. "AuthorHub: A Platform for Writers to Manage and Publish Books"

AuthorHub is a web-oriented platform designed exclusively for authors, providing a structured and efficient environment to manage and publish their books, as well as read books from other authors. The platform enables authors to create, update, and delete their books while tracking the progress of their publications. 

To maintain organization and efficiency in system operations, AuthorHub follows the Model-View-Controller (MVC) design pattern.

### Part 1: Model

The first task is to modify the Book model. At present, the Book model doesn't have any attributes. To make this model more meaningful for an authoring platform, we need to add several attributes to this model.

**You have the following tasks:**

1. **Implement the Book class:**
Update the Book class by adding the following attributes: `author, title, genre, year, description` (all of type `String`), and `pageCount` (of type `Integer`). Implement the `constructor` to set all attributes and fill the corresponding `getters and setters` for each attribute.


### Part 2: Controller

The "list view" typically refers to a type of user interface which presents a list of items or options to the user. In this case, the BookListView is a user interface view that displays a list of books.

In the next task you need to implement two methods in the `Controller` class: `saveBook()` and `displayBook()`. 

**You have the following tasks:**

1. **Implement saveBook in Controller:**
Implement the `saveBook(Book)` method in the `Controller`. Make sure that the book gets added to the list view and all observers get notified about this.

2. **Implement displayBook in Controller:**
Implement the `displayBook(Book)` method in the `Controller`. This method should open up the 'BookDetailView' for the selected book, allowing the user to read it.

<ins>Hint</ins>: You can display a view by calling the method `show()`.

### Part 3: View
The final part is to implement the `BookListView` and `BookDetailView` view components. 

**You have the following tasks:**

1. **Implement readBook in BookListView:**
In `BookListView`, implement a `readBook()` method. The `readBook()` method in `BookListView` appears to be a user-triggered action that tells the Controller to display details of the selected book.

2. **Implement writeBook in BookListView:**
In `BookListView`, implement a `writeBook()` method to initiate the book creation process where the controller will be notified about a new book instance.

3. **Implement save method in BookDetailView:**
Implement `save()` method in `BookDetailView`. This method should update the book with the information entered by the user and save it using the controller.

4. **Constructor BookDetailView:**
Make sure that the view is an observer of each book in `BookDetailView`.



@startuml

hide circle
hide empty methods
hide empty members

package "model" {
    class Book {
        -author: String 
        -title: String
        -genre: String
        - year: String
        - description: String
        - pageCount: int
        +addObserver(Observer):void
        -removeObserver(Observer):void
    }
}

package "view" {
    interface Observer <<interface>> {
        +update():void
    }
    
    class BookDetailView{
        +generateUserInterface():void
        +update():void
        -save():void
    }
    
    class BookListView{
        +generateUserInterface():void
        +update():void
        -readBook(Book):void
        -writeBook():void
        +publishBook(Book):void
    }
}

package "controller" {
    class Controller {
        +saveBook(Book):void
        +displayBook(Book):void
    }
}

BookListView -up-|> Observer
BookDetailView -up-|> Observer

BookDetailView -right-> Controller
BookDetailView -right-> Book

BookListView -right-> Controller
BookListView -down-> "*" Book

Controller .down.> Book

hide BookListView fields
hide BookDetailView fields
hide Controller fields
hide Observer fields

@enduml


