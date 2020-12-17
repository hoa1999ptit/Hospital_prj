package hospitals.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medicines")
public class Medicine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	//tên thuốc : 
	@Column(name = "name")
	private String name;
	
	
	//dạng của thuốc : viên nang, viên nén, viên tròn
	@Column(name = "form")
	private String form;
	
	
	//ngày hết hạn của thuốc
	@Column(name = "expirationDate")
	private Date expirationDate;
	
	// giá tiền
	@Column(name = "price")
	private String price;

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

}
