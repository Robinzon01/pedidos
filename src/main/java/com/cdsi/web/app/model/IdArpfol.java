package com.cdsi.web.app.model;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class IdArpfol implements Serializable {
  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String no_cia;
	private String no_orden;
	private String no_arti;
	
	public IdArpfol() {}
	
	public IdArpfol(String no_cia, String no_orden, String no_arti) {	
		this.no_cia = no_cia;
		this.no_orden = no_orden;
		this.no_arti = no_arti;
	}

	public String getNo_cia() {
		return no_cia;
	}

	public void setNo_cia(String no_cia) {
		this.no_cia = no_cia;
	}

	public String getNo_orden() {
		return no_orden;
	}

	public void setNo_orden(String no_orden) {
		this.no_orden = no_orden;
	}

	public String getNo_arti() {
		return no_arti;
	}

	public void setNo_arti(String no_arti) {
		this.no_arti = no_arti;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	
	

}
