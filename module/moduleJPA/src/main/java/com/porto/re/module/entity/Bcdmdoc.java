package com.porto.re.module.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bcdmdoc database table.
 * 
 */
@Entity
@NamedQuery(name="Bcdmdoc.findAll", query="SELECT b FROM Bcdmdoc b")
public class Bcdmdoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int empcod;

	private String aplnumdig;

	private String cssodmnum;

	private String ramcod;

	private String sgdirbcod;

	private String succod;

	public Bcdmdoc() {
	}

	public int getEmpcod() {
		return this.empcod;
	}

	public void setEmpcod(int empcod) {
		this.empcod = empcod;
	}

	public String getAplnumdig() {
		return this.aplnumdig;
	}

	public void setAplnumdig(String aplnumdig) {
		this.aplnumdig = aplnumdig;
	}

	public String getCssodmnum() {
		return this.cssodmnum;
	}

	public void setCssodmnum(String cssodmnum) {
		this.cssodmnum = cssodmnum;
	}

	public String getRamcod() {
		return this.ramcod;
	}

	public void setRamcod(String ramcod) {
		this.ramcod = ramcod;
	}

	public String getSgdirbcod() {
		return this.sgdirbcod;
	}

	public void setSgdirbcod(String sgdirbcod) {
		this.sgdirbcod = sgdirbcod;
	}

	public String getSuccod() {
		return this.succod;
	}

	public void setSuccod(String succod) {
		this.succod = succod;
	}

}