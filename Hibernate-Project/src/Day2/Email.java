package Day2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;

@Entity(name="newemail23")
public class Email {
	
	@Id
	//@SequenceGenerator(name="seq1",sequenceName="HIB")
	//Code more compatible with different databases
	@TableGenerator(name="tablegen",table="ID_TABLE",pkColumnName="ID",valueColumnName="NEXT_ID",initialValue=5)
	@GeneratedValue(strategy = GenerationType.TABLE)
	Long id;
	
	@Column
	String subject;
	
	@OneToOne(mappedBy = "email")
	Message message;
	
	public Email(){
		
	}

	public Email(String subject) {
		super();
		this.subject = subject;

	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}	

}
