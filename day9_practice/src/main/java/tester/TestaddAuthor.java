package tester;
import static utils.HibernateUtils.*;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.AuthorDaoImpl;
import dao.BookDaoImpl;
import pojos.Author;

public class TestaddAuthor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(SessionFactory session =getFactory();
				Scanner sc = new Scanner(System.in)){
			AuthorDaoImpl dao =new AuthorDaoImpl();
			Author a = new Author(sc.next(),sc.next(),sc.next(),sc.next());
			System.out.println(dao.newAuthor(a));
		}
	}

}
