package com.untitle.inventory.commons;

import java.util.List;

public class JQGridJSON {
	private String page; 
	private String total; 
	private Integer records; 
	private List<JQGridRow> rows; 
	   
	  /**
	 * @return the page
	 */
	public String getPage() {
		return page;
	}
	/**
	 * @return the total
	 */
	public String getTotal() {
		return total;
	}
	/**
	 * @return the records
	 */
	public Integer getRecords() {
		return records;
	}
	/**
	 * @return the rows
	 */
	public List<JQGridRow> getRows() {
		return rows;
	}
	/**
	 * @param page the page to set
	 */
	public void setPage(String page) {
		this.page = page;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	/**
	 * @param records the records to set
	 */
	public void setRecords(Integer records) {
		this.records = records;
	}
	/**
	 * @param rows the rows to set
	 */
	public void setRows(List<JQGridRow> rows) {
		this.rows = rows;
	}

}
