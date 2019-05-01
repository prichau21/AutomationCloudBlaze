package com.CloudBlaze.PageObjects;

public interface ILoginLogout {
	/*
	 * This is not in use now public String
	 * txtbx_knoxUserName="//*[@id='inlineFormInputGroup1']"; public String
	 * txtbx_KnoxPassword="//*[@id='password']"; public String
	 * btn_KnoxLogIn="//*[@id='signIn']";
	 */

	public String txtbx_UserName = "//*[@id='inlineFormInputGroup1']";
	public String txtbx_Password = "//*[@id='password']";
	public String btn_LogIn = "//*[@id='signIn']";

	public String invalidLoginMsg = "//*[@class='errorMsg']";
	// public String loggedUserNm="//a[@class='nav-link dropdown-toggle text-muted
	// waves-effect waves-dark']";

	//public String userMenu = "//*[@id='main-wrapper']/app-header/header/nav/ul[3]/li/a";
	//public String logoutLnk = "//*[@id='main-wrapper']/app-header/header/nav/ul[3]/li/ul/li/a";
	public String logoutLnk = "//*[@id='main-wrapper']//*[@mattooltip='Logout']";

}
