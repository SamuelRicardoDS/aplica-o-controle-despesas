package model;

import java.util.Date;

public class Boleto extends PaymentMethod {

	private int code;
	private Date expirationDate;

	public Boleto(Date payDate, String bank, String payer, int code, Date expirationDate) {
		super(payDate, bank, payer);
		this.code = code;
		this.expirationDate = expirationDate;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

}
