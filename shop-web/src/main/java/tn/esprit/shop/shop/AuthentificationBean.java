package tn.esprit.shop.shop;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;

import tn.esprit.shop.shop.persistence.Admin;
import tn.esprit.shop.shop.persistence.User;
import tn.esprit.shop.shop.services.UserServiceLocal;

@ManagedBean
//@ApplicationScoped
@SessionScoped
//@ViewScoped
//@RequestScoped
public class AuthentificationBean {
	@EJB
	UserServiceLocal userServiceLocal ;
	
	private User user = new User();
	
	private boolean isLogged = false;
	
	private String userType;	
	
	
//	public String doLogin() {
//		String navTo = "" ;
//		if (login.equals("esprit") && password.equals("esprit"))
//			navTo = "sucess?faces-redirect=true";
//		return navTo ;
//	}
	public String checkLogin() {
		String navTo = "" ;
		User found = userServiceLocal.authenticate(user.getLogin(), user.getPassword()) ;
		if (found != null)
		//	
		{
			if (found instanceof Admin)
			{
				userType="Admin";
		}
			isLogged = true;
			navTo = "success?faces-redirect=true";
			
	}
		
		FacesMessage msg= new FacesMessage("bad credentials!");
		FacesContext.getCurrentInstance().addMessage("form_login:btn_login", msg);
		return navTo;
	}
	
	
	public String doLogout(){
		isLogged = false;
		user=new User();
		return "page/login?faces-redirect=true";
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

	public boolean isLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}
}
