package Day3;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class ISBN implements Serializable{
	
	@Column(name="group_number")
	int group;
	
	int publisher;
	int title;
	int checkdigit;
	
	public ISBN() {
		super();
	}
	public int getGroup() {
		return group;
	}
	public void setGroup(int group) {
		this.group = group;
	}
	public int getPublisher() {
		return publisher;
	}
	public void setPublisher(int publisher) {
		this.publisher = publisher;
	}
	public int getTitle() {
		return title;
	}
	public void setTitle(int title) {
		this.title = title;
	}
	public int getCheckdigit() {
		return checkdigit;
	}
	public void setCheckdigit(int checkdigit) {
		this.checkdigit = checkdigit;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + checkdigit;
		result = prime * result + group;
		result = prime * result + publisher;
		result = prime * result + title;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ISBN other = (ISBN) obj;
		if (checkdigit != other.checkdigit)
			return false;
		if (group != other.group)
			return false;
		if (publisher != other.publisher)
			return false;
		if (title != other.title)
			return false;
		return true;
	}
	
	
}
