package com.solvd.onlineshop.customer;

public enum Roles {

	SUPERADMIN,ADMIN,USER;
	
	private boolean  canPost;
	private boolean canGet;
	private boolean canPut;
	private boolean canDelete;
	

}
