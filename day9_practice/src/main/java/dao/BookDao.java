package dao;

import java.util.List;

import pojos.Book;

public interface BookDao {
String newBook(Book book,int author_id);
String removeBook(int bid);
List<Book> displayAllBooks();
String updateBook(String title,int id);
}
