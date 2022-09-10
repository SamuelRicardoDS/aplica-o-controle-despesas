package model;

import java.util.Date;

/**
 * classe para objetos do tipo Pix, que é uma subclasse de PaymentMethod, onde serão contidos, valores e métodos para o mesmo.
 * @author Samuel Ricardo
 * @since release 1
 * @see PaymentMethod
 */

public class Pix extends PaymentMethod {
    private String idTransacao;

    /**
     * Construtor da classe Pix
     *
     * @param idTransacao  Id da transação
     */
    public Pix(User user, Double amount) {
        super(user, amount);
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(String idTransacao) {
        this.idTransacao = idTransacao;
    }
}
