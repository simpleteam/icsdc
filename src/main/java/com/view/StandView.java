package com.view;

import com.entity.Stand;

public class StandView {

	private long id;
	private String number;
	private String alternativeNumber;

	public StandView() {

	}

	public StandView(Stand stand) {
		this.id = stand.getId();
		this.number = stand.getNumber();
		this.alternativeNumber = stand.getAlternativeNumber();
	}

	public StandView(long id, String number, String alternativeNumber) {
		super();
		this.id = id;
		this.number = number;
		this.alternativeNumber = alternativeNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAlternativeNumber() {
		return alternativeNumber;
	}

	public void setAlternativeNumber(String alternativeNumber) {
		this.alternativeNumber = alternativeNumber;
	}

}
