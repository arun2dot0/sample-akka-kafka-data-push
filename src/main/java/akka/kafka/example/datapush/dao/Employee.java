package akka.kafka.example.datapush.dao;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "employee")
public class Employee  {
	
	@Id
	@Column(name = "id")
	long id ;
	@Column(name = "first_name")
	String firstName;
	@Column(name = "last_name")
	String lastName;
	@Column(name = "title")
	String title;
	
	@Column(name = "data_sent_flag")
	String dataSentFlag;
	

	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	Date createdDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_date")
	Date modifiedDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}



	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getDataSentFlag() {
		return dataSentFlag;
	}

	public void setDataSentFlag(String dataSentFlag) {
		this.dataSentFlag = dataSentFlag;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", title=" + title
				+ ", dataSentFlag=" + dataSentFlag + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate
				+ "]";
	}

	
	
	
	
	

	
}
