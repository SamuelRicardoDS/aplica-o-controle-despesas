package model;

import java.util.Date;

public class Boleto extends PaymentMethod {

	private String code;
	private Date expirationDate;

	public Boleto(Date payDate, String bank, String payer, String code, Date expirationDate, Double amount) {
		super(payDate, bank, payer, amount);
		this.code = code;
		this.expirationDate = expirationDate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

}
