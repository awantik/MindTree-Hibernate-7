package Day2;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ADDRESS")
public class Address {

	@Id
	@GeneratedValue(generator = "gen")

	private long id;

	@Column(name = "address_line1")
	private String addressLine1;

	@Column(name = "zipcode")
	private String zipcode;

	@Column(name = "city")
	private String city;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Employee employee;

        //Getter setter methods

	@Override
	public String toString() {
		return "AddressLine1= " + addressLine1 + ", City=" + city
				+ ", Zipcode=" + zipcode;
	}
}
