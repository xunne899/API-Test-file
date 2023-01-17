package com.accenture.api.model;



public class Pricing {
	
	
	
	private int baseprice = 3;

	public int getBaseprice() {
		return baseprice;
	}

	public void setBaseprice(int baseprice) {
		this.baseprice = baseprice;
	}

	
	public Pricing() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pricing(int baseprice) {
		super();
		this.baseprice = baseprice;
	}

	@Override
	public String toString() {
		return "Pricing [baseprice=" + baseprice + "]";
	}
	
	

}
