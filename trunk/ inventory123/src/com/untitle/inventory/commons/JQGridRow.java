package com.untitle.inventory.commons;

import java.util.List;

public class JQGridRow {
	  private String id; 
	  public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getCell() {
		return cell;
	}
	public void setCell(List<String> cell) {
		this.cell = cell;
	}
	private List<String> cell;
	 

}
