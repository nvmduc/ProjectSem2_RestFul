package Insurance.Entities;

import java.util.Date;

public class RoleDTO {
	private Integer idRole;
	private String nameRole;
	private Integer statusRole;
	private Date created_at_Role;

	public RoleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoleDTO(Integer idRole, String nameRole, Integer statusRole, Date created_at_Role) {
		super();
		this.idRole = idRole;
		this.nameRole = nameRole;
		this.statusRole = statusRole;
		this.created_at_Role = created_at_Role;
	}

	public Integer getIdRole() {
		return idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	public String getNameRole() {
		return nameRole;
	}

	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}

	public Integer getStatusRole() {
		return statusRole;
	}

	public void setStatusRole(Integer statusRole) {
		this.statusRole = statusRole;
	}

	public Date getCreated_at_Role() {
		return created_at_Role;
	}

	public void setCreated_at(Date created_at_Role) {
		this.created_at_Role = created_at_Role;
	}

}
