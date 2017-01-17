package Day3;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
		name="customer",
		uniqueConstraints = {@UniqueConstraint(columnNames="name")}
)
@SecondaryTable(name = "customer_details")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public String name;
	
	@Column(table = "customer_details")
	public String address;

	public Customer() {
		
	}
}  
