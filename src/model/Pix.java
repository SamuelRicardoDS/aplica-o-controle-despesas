package model;
import java.util.Date;

public class Pix extends PaymentMethod{
	private Date payDate;
	private String idTransacao;
	private String payer;
	
	public Pix(Date payDate, String idTransacao, String payer){
		super(payDate, idTransacao, payer);
	}
	
}
