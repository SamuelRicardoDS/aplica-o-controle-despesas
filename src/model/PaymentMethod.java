package model;

import java.util.Date;

/**
 * classe abstrada para criação da classe pai PaymentMethod, onde serão contidos, valores e métodos para a mesma..
 * @author Samuel Ricardo
 * @since release 1
 * */
public abstract class PaymentMethod {
    private Date payDate;
    private String bank;
    private User payer;
    protected Double amount;

    /**
     * Construtor da classe pai PaymentMethod
     *
     * @param payDate  Data de pagamento
     * @param bank  Banco
     * @param user  Pagador
     * @param amount  Valor
     */
    public PaymentMethod(User user, Double amount) {
        super();
        this.payer = user;
        this.amount = amount;
    }

    /**
     * Método que calcula o valor que cada usuário deve pagar
     * @param group  Grupo de usuários
     * @return Double  Valor que cada usuário deve pagar
     */
    public Double calcSingleValue(Group group) {
        amount = 0.0;
        int integers = group.getMembers().size();
        for (int i = 0; i < integers; i++) {
            amount += group.getExpenses().get(i).getValue();
            
        }
        Double singleValue = amount / integers;
        return singleValue;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public User getPayer() {
        return payer;
    }

    public void setPayer(User payer) {
        this.payer = payer;
    }
}
