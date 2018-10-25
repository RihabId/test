package tn.esprit.shop.shop;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import tn.esprit.shop.shop.persistence.Category;
import tn.esprit.shop.shop.services.CatalogServiceLocal;

@ManagedBean
public class CategoryBean {
	@EJB
	private CatalogServiceLocal catalogServiceLocal;
	
	private List<Category> listCategories = new ArrayList<Category>();
	
	@PostConstruct
	public void init(){
		listCategories = catalogServiceLocal.findAllCategories();
	}

	public List<Category> getListCategories() {
		return listCategories;
	}

	public void setListCategories(List<Category> listCategories) {
		this.listCategories = listCategories;
	}
	
//	@ManagedProperty(value="#{AuthentificationBean}")
//	private AuthentificationBean authentificationBean;
}
