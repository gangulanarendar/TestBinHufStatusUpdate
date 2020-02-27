package com.tm.model;

import java.sql.Date;


public class BinHufStatus {

	private Integer int_binid;

	private Integer int_countryId;
	
	private String chr_status;

	private String str_agent_name;

	private Date last_updated;

	public String issuingBank;

	public String getIssuingBank() {
		return issuingBank;
	}

	public void setIssuingBank(String issuingBank) {
		this.issuingBank = issuingBank;
	}

	public Integer getInt_binid() {
		return int_binid;
	}

	public void setInt_binid(Integer int_binid) {
		this.int_binid = int_binid;
	}

	public Integer getInt_countryId() {
		return int_countryId;
	}

	public void setInt_countryId(Integer int_countryId) {
		this.int_countryId = int_countryId;
	}

	public String getChr_status() {
		return chr_status;
	}

	public void setChr_status(String chr_status) {
		this.chr_status = chr_status;
	}

	public String getStr_agent_name() {
		return str_agent_name;
	}

	public void setStr_agent_name(String str_agent_name) {
		this.str_agent_name = str_agent_name;
	}

	public Date getLast_updated() {
		return last_updated;
	}

	public void setLast_updated(Date last_updated) {
		this.last_updated = last_updated;
	}

	@Override
	public String toString() {
		return "BinHufStatus [int_binid=" + int_binid + ", int_countryId=" + int_countryId + ", chr_status="
				+ chr_status + ", str_agent_name=" + str_agent_name + ", last_updated=" + last_updated + "]";
	}

	

}
