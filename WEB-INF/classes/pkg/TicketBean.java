package pkg;

import java.io.Serializable;
import java.util.*;

//class represent individual tickets
public class TicketBean implements Serializable {

	//data variables
	private String userAssigned;
	private String ticketStatus;
	private String ticketID;
	private String ticketOpened;

	private String ticketTitle;
	private String ticketCategory;
	private String ticketKeyword;
	private String ticketDescription;


	//constructor
	public TicketBean(){
		this.setUser("");
		this.setStatus("");
		this.setID("");
		this.setOpened("");

		this.setTitle("");
		this.setCategory("");
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
		this.ticketStatus=s;
	}

	public String getStatus(){
		return this.ticketStatus;
	}

	public synchronized void setID(String id){
		this.ticketID=id;
	}

	public String getID(){
		return this.ticketID;
	}

	public synchronized void setOpened(String o){
		this.ticketOpened=o;
	}

	public String getOpened(){
		return this.ticketOpened;
	}

	

	public synchronized void setTitle(String s){
		this.ticketTitle=s;
	}

	public String getTitle(){
		return this.ticketTitle;
	}

	public synchronized void setCategory(String c){
		this.ticketCategory=c;
	}

	public String getCategory(){
		return this.ticketCategory;
	}

	public synchronized void setKeyword(String k){
		this.ticketKeyword=k;
	}

	public String getKeyword(){
		return this.ticketKeyword;
	}

	public synchronized void setDescription(String d){
		this.ticketDescription=d;
	}

	public String getDescription(){
		return this.ticketDescription;
	}

}