package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="author")
public class Author extends BaseEntity {
	@Column(name="author_fname",length=30)
	private String fname;
	@Column(name="author_lname",length=30)
	private String lname;
	
	@Column(name="email",unique=true)
	private String email;
	@Column(name="password",length=30)
	private String password;
	
	@OneToMany(mappedBy = "author_id",cascade=CascadeType.ALL)
	private  List<Book> blist=new ArrayList<>();

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Author(String fname, String lname, String email, String password) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		
	}

	@Override
	public String toString() {
		return "Autor [fname=" + fname + ", lname=" + lname + ", email=" + email + ", password=" + password + "]";
	}
	
	
public void addBook(Book b) {
	blist.add(b);
	b.setAuthor_id(this);
	
	
}
public void removeBook(Book b) {
	blist.remove(b);
	b.setAuthor_id(null);
	
}
}
