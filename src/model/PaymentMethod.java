package model;

import java.util.Date;

public abstract class PaymentMethod {
	private Date payDate;
	private String bank;
	private String payer;


	public PaymentMethod(Date payDate, String bank, String payer) {
		this.payDate = payDate;
		this.bank = bank;
		this.payer = payer;
	}
}
