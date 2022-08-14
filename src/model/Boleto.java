package model;
import java.util.Date;

public class Boleto extends PaymentMethod{
  
  private int code;
  private Date expirationDate;
  
public Boleto(Date payDate, String bank, String payer, int code, Date expirationDate) {
	super(payDate, bank, payer);
	this.code = code;
	this.expirationDate = expirationDate;
}

 
}
