package Entity;

import java.io.Serializable;

public class Role implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int roleID;
	private String authority;

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Role() {
	}

	public Role(int roleID, String authority) {
		super();
		this.roleID = roleID;
		this.authority = authority;
	}

}
