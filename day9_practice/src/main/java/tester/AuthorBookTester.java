package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.internal.build.AllowSysOut;

import dao.AuthorDaoImpl;
import dao.BookDaoImpl;
import pojos.Author;
import pojos.Book;
public class AuthorBookTester {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory();
				Scanner sc=new Scanner (System.in);){
			boolean exit=false;
			AuthorDaoImpl dao=new AuthorDaoImpl();
			BookDaoImpl dao1=new BookDaoImpl();
			while(!exit) {
				System.out.println("Enter 0.exit,1.addAuthor,2.addbook,3.removeBook,4.show book details");
				switch(sc.nextInt()) {
				
				case 1:
					System.out.println("Enter: fname,  lname,  email,  password");
					System.out.println(	dao.newAuthor(new Author(sc.next(),sc.next(),sc.next(),sc.next())));
					break;
				
				case 2:
					System.out.println("Enter book title and price .... ");
					dao1.newBook(new Book(sc.next(),sc.nextDouble()),sc.nextInt());
					break;
					
				case 3:
					System.out.println("Enter Book ID to remove Book...");
					dao1.removeBook(sc.nextInt());
					System.out.println("Book Removed....");
			
					break;
				case 4:
					System.out.println("Show book details..");
					dao1.displayAllBooks().forEach(s->System.out.println(s));
					
					break;
				case 5:
					System.out.println("update book..");
					dao1.updateBook(sc.next(),sc.nextInt());
					System.out.println("Book updated sucessfully..");
					break;
					
					
				case 0:
					exit=true;
					break;
					default:
						System.out.println("Please enter the correct choice...");
				}
			}
		}catch (Exception e) {
		e.printStackTrace();
		}

	}

}
