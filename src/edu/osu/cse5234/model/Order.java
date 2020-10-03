package edu.osu.cse5234.model;
import java.util.*;
public class Order {
	List<Item> itemlist = new ArrayList<Item>();

	public List<Item> getItemlist() {
		return itemlist;
	}

	public void setItemlist(List<Item> itemlist) {
		this.itemlist = itemlist;
	} 
	
}
