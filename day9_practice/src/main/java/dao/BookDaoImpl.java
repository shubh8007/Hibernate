package dao;

import static utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Author;
import pojos.Book;
public class BookDaoImpl implements BookDao {

	@Override
	public String newBook(Book book,int author_id) {
		String msg="Book added Failed....";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			Author auth=session.get(Author.class, author_id);
			if(auth!=null) {
				auth.addBook(book);
			session.persist(book);
			
			msg="Book added with generated id="+book.getId();
			}
			tx.commit();
		}catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
		}
		return msg;
	}
	
	@Override
	public String removeBook(int bid) {
		String msg="Book remove failed..";
		Session session=getFactory().getCurrentSession();
	Transaction tx=session.beginTransaction();
	try {
		Book book=session.get(Book.class, bid);
		
		if(book!=null) {
			 session.remove(book);
			 msg="book removed..";
		}
		tx.commit();
	}catch (RuntimeException e) {
	     if(tx!=null)
	    	  tx.rollback();
	    	 
	}
		return msg;
	}

	@Override
	public List<Book> displayAllBooks() {
		List<Book> blist=null;
		String  jpql="select b from Book b";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			blist=session.createQuery(jpql,Book.class).getResultList();
			System.out.println("hii");
			tx.commit();
		}catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
		}
		return blist;
	}

	@Override
	public String updateBook(String tle,int bid) {
		String msg="Update book failed...";
		
		
		Session session =getFactory().getCurrentSession();
		String jpql="update Book b set bname=:bm where b.id=:boid";
		Transaction tx=session.beginTransaction();
		try {
			System.out.println("hii");
			//String b=session.createQuery(jpql).setParameter("bm",title).setParameter("bookid", bid).executeUpdate();
			int a =session.createQuery(jpql)
					.setParameter("bm",tle)
					.setParameter("boid",bid)
					.executeUpdate();
			System.out.println("Rows ");
			//int updateCount=session.createQuery(updateJpql)
			//.setParameter("incr", salIncr)
			//.setParameter("dt", joinDate)
			//.executeUpdate();	
			System.out.println("Rows updated "+a);
			tx.commit();
		}catch (RuntimeException e) {
                  if(tx!=null)
                	  tx.rollback();
		}
		return msg;
	}
	

}


