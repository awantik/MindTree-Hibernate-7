package Day3;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

//This class will be used as super class
@MappedSuperclass
public class BookSuperClass extends SuperBook{
    @Id
    @GeneratedValue
	Integer id;
    
	String name;
	
	public BookSuperClass() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}