package pkg;

import java.io.Serializable;
import java.util.*;

//class represent individual tickets
public class KnowledgeBaseBean implements Serializable {

	//data variables
	private String username;
	private String kbID;
	private String kbTicketOpenedTime;
    private String kbTicketClosedTime;
	private String kbTitle;
	private String kbCategory;
	private String kbSubCategory;
	private String kbKeyword;
	private String kbDescription;
    private String kbResolution;
    private String kbComment;


	//constructor
	public KnowledgeBaseBean(){
		this.setUser("");
		this.setID("");
		this.setKbOpened("");
        this.setKbClosed("");
        this.setKbComment("");

		this.setTitle("");
		this.setCategory("");
		this.setSubCategory("");
		this.setKeyword("");
		this.setDescription("");
        this.setResolution("");
	}

	//setters and getters
	public synchronized void setUser(String u){
		this.username=u;
	}

	public String getUser(){
		return this.username;
	}

	public synchronized void setID(String id){
		this.kbID=id;
	}

	public String getID(){
		return this.kbID;
	}

	public synchronized void setKbOpened(String o){
		this.kbTicketOpenedTime=o;
	}

	public String getKbOpened(){
		return this.kbTicketOpenedTime;
	}

    public synchronized void setKbClosed(String c){
		this.kbTicketClosedTime=c;
	}

	public String getKbClosed(){
		return this.kbTicketClosedTime;
	}

    public synchronized void setKbComment(String c){
		this.kbComment=c;
	}

	public String getKbComment(){
		return this.kbComment;
	}





	public synchronized void setTitle(String s){
		this.kbTitle=s;
	}

	public String getTitle(){
		return this.kbTitle;
	}

	public synchronized void setCategory(String c){
		this.kbCategory=c;
	}

	public String getCategory(){
		return this.kbCategory;
	}

	public synchronized void setSubCategory(String sc){
		this.kbSubCategory=sc;
	}

	public String getSubCategory(){
		return this.kbSubCategory;
	}

	public synchronized void setKeyword(String k){
		this.kbKeyword=k;
	}

	public String getKeyword(){
		return this.kbKeyword;
	}

	public synchronized void setDescription(String d){
		this.kbDescription=d;
	}

	public String getDescription(){
		return this.kbDescription;
	}

    public synchronized void setResolution(String r){
		this.kbResolution=r;
	}

	public String getResolution(){
		return this.kbResolution;
	}

}