package pkg;

import java.io.Serializable;
import java.util.*;

//class represent individual tickets
public class TicketBean implements Serializable {

	//data variables
	private String userAssigned;
	private String status;

	private String title;
	private String category;
	private String subCategory;
	private String keywords;
	private String description;


	//constructor
	public TicketBean(){
		this.setUser("");
		this.setStatus("");

		this.setTitle("");
		this.setCategory("");
		this.setSubCategory("");
		this.setKeyword("");
		this.setDescription("");
	}

	//setters and getters
	public synchronized void setUser(String u){
		this.userAssigned=u;
	}

	public String getUser(){
		return this.userAssigned;
	}

	public synchronized void setStatus(String s){
		this.status=s;
	}

	public String getStatus(){
		return this.status;
	}

	

	public synchronized void setTitle(String s){
		this.title=s;
	}

	public String getTitle(){
		return this.title;
	}

	public synchronized void setCategory(String c){
		this.category=c;
	}

	public String getCategory(){
		return this.category;
	}

	public synchronized void setSubCategory(String sc){
		this.subCategory=sc;
	}

	public String getSubCategory(){
		return this.subCategory;
	}

	public synchronized void setKeyword(String k){
		this.keywords=k;
	}

	public String getKeyword(){
		return this.keywords;
	}

	public synchronized void setDescription(String d){
		this.description=d;
	}

	public String getDescription(){
		return this.description;
	}

}