
package com.tm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BincodeJsonResponse {

	@SerializedName("bin")
	@Expose
	private String bin;
	@SerializedName("bank")
	@Expose
	private String bank;
	@SerializedName("card")
	@Expose
	private String card;
	@SerializedName("type")
	@Expose
	private String type;
	@SerializedName("level")
	@Expose
	private String level;
	@SerializedName("country")
	@Expose
	private String country;
	@SerializedName("countrycode")
	@Expose
	private String countrycode;
	@SerializedName("website")
	@Expose
	private String website;
	@SerializedName("phone")
	@Expose
	private String phone;
	@SerializedName("valid")
	@Expose
	private String valid;

	public String getBin() {
		return bin;
	}

	public void setBin(String bin) {
		this.bin = bin;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	@Override
	public String toString() {
		return "BincodeJsonResponse [bin=" + bin + ", bank=" + bank + ", card=" + card + ", type=" + type + ", level="
				+ level + ", country=" + country + ", countrycode=" + countrycode + ", website=" + website + ", phone="
				+ phone + ", valid=" + valid + "]";
	}

}
