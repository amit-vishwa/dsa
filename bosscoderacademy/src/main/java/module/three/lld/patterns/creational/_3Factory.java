package module.three.lld.patterns.creational;

interface Book {
    void read();
}

class Fiction implements Book {
    @Override
    public void read() {
        System.out.println("Reading a fiction book");
    }
}

class Thriller implements Book {
    @Override
    public void read() {
        System.out.println("Reading a thriller book");
    }
}

class BookFactory {
    public static Book getBook(String book) {
        return "fiction".equalsIgnoreCase(book) ? new Fiction() : new Thriller();
    }
}

/**
 * Factory Design pattern provides a way to create objects without specifying the exact class of object that will be created.
 * It encapsulates object creation logic, making code flexible and extensible.
 * */
public class _3Factory {

    public static void main(String[] args) {
        Book fictionBook = BookFactory.getBook("fiction");
        fictionBook.read();
        Book thrillerBook = BookFactory.getBook("thriller");
        thrillerBook.read();
    }

}
