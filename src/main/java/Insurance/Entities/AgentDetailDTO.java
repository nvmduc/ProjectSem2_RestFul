package Insurance.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

public class AgentDetailDTO {
	@Column(name = "idAgent")
	private Integer idAgent;
	@NotEmpty(message = "Address Agent is not empty")
	@Column(name = "addressAgent")
	private String addressAgent;
	@NotEmpty(message = "Phone is not empty")
	@Column(name = "Phone")
	private String phone;
	@NotEmpty(message = "Email is not empty")
	@Column(name = "email")
	private String email;
	@NotEmpty(message = "ZipCode is not empty")
	@Column(name = "zipcode")
	private String zipcode;
	@Column(name = "status")
	private Integer status;
	@Column(name = "created_at")
	private Date created_at;
	public AgentDetailDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AgentDetailDTO(Integer idAgent, @NotEmpty(message = "Address Agent is not empty") String addressAgent,
			@NotEmpty(message = "Phone is not empty") String phone,
			@NotEmpty(message = "Email is not empty") String email,
			@NotEmpty(message = "ZipCode is not empty") String zipcode, Integer status, Date created_at) {
		super();
		this.idAgent = idAgent;
		this.addressAgent = addressAgent;
		this.phone = phone;
		this.email = email;
		this.zipcode = zipcode;
		this.status = status;
		this.created_at = created_at;
	}
	public Integer getIdAgent() {
		return idAgent;
	}
	public void setIdAgent(Integer idAgent) {
		this.idAgent = idAgent;
	}
	public String getAddressAgent() {
		return addressAgent;
	}
	public void setAddressAgent(String addressAgent) {
		this.addressAgent = addressAgent;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	
}
