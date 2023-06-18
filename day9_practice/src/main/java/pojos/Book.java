package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book extends BaseEntity{
	@Column(name="bname",length=30)
	private String title;
	@Column(name="price")
	private double price;
	
	
	@ManyToOne
	@JoinColumn(name="author_id")
	private Author author_id;
	
	
	public Book() {
		
	}


	public Book(String title, double price) {
		super();
		this.title = title;
		this.price = price;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Author getAuthor_id() {
		return author_id;
	}


	public void setAuthor_id(Author author_id) {
		this.author_id = author_id;
	}


	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + ", author_id=" + author_id + "]";
	}
	

}
