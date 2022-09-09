package model;

import java.util.Date;

/**
 * classe para objetos do tipo Boleto, que é uma subclasse de PaymentMethod, onde serão contidos, valores e métodos para a mesma.
 * @author Samuel Ricardo
 * @since release 1 
 * @see PaymentMethod
 */

public class Boleto extends PaymentMethod {

	private String code;
	private Date expirationDate;

	/**
	 * Construtor da classe Boleto
	 *
	 * @param code  Código do boleto
	 * @param expirationDate  Data de expiração do boleto
	 */
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
