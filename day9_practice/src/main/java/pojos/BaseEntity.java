package pojos;

import javax.annotation.processing.Generated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@MappedSuperclass //common field i.e common super class 
public class BaseEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
public BaseEntity() {
	
}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
}
