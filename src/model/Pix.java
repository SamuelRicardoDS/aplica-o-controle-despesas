package model;
import java.util.Date;

public class Pix extends PaymentMethod{
	private String idTransacao;
	
	public Pix(Date payDate, String bank, String payer, String idTransacao) {
		super(payDate, bank, payer);
		this.idTransacao = idTransacao;
	}

	public String getIdTransacao() {
		return idTransacao;
	}

	public void setIdTransacao(String idTransacao) {
		this.idTransacao = idTransacao;
	}
	
}
