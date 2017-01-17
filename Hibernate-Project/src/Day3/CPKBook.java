package Day3;

import javax.persistence.*;

@Entity
public class CPKBook {

	@Id
	ISBN id;
	
	@Column
	String name;

	public CPKBook() {
		super();
	}

	public ISBN getId() {
		return id;
	}

	public void setId(ISBN id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
