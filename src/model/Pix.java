package model;
import java.util.Date;

/**
 * classe para objetos do tipo Pix, que é uma subclasse de PaymentMethod, onde serão contidos, valores e métodos para o mesmo.
 * @author Samuel Ricardo
 * @since release 1 */
 

public class Pix extends PaymentMethod{
	private String idTransacao;
	
	public Pix(Date payDate, String bank, String payer, String idTransacao, Double amount) {
		super(payDate, bank, payer, amount);
		this.idTransacao = idTransacao;
	}

	public String getIdTransacao() {
		return idTransacao;
	}

	public void setIdTransacao(String idTransacao) {
		this.idTransacao = idTransacao;
	}
	
}
