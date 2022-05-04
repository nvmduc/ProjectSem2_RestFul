package Insurance.Entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Account_RoleDTO {
	private Integer idAccountRole;
	private Integer idRole;
	private Integer idAccount;
	private Integer status;
	public Integer getIdAccountRole() {
		return idAccountRole;
	}
	public void setIdAccountRole(Integer idAccountRole) {
		this.idAccountRole = idAccountRole;
	}
	public Integer getIdRole() {
		return idRole;
	}
	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}
	public Integer getIdAccount() {
		return idAccount;
	}
	public void setIdAccount(Integer idAccount) {
		this.idAccount = idAccount;
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
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date created_at;
	public Account_RoleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account_RoleDTO(Integer idAccountRole, Integer idRole, Integer idAccount, Integer status, Date created_at) {
		super();
		this.idAccountRole = idAccountRole;
		this.idRole = idRole;
		this.idAccount = idAccount;
		this.status = status;
		this.created_at = created_at;
	}
	
}
