package com.Electricity.Billing.System.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CalculateBill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int billno;
	String name;
	int units;
	double bill;

	public CalculateBill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CalculateBill(String name, int units, double bill) {
		super();
		this.name = name;
		this.units = units;
		this.bill = bill;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public double getBill() {
		return bill;
	}

	public void setBill(double bill) {
		this.bill = bill;
	}

	@Override
	public String toString() {
		return "CalculateBill [name=" + name + ", units=" + units + ", bill=" + bill + "]";
	}

}
