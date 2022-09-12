package controller;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.Boleto;
import model.PayPal;
import model.PaymentMethod;
import model.Pix;
import model.User;

/**
 * Classe de controle para o pagamento
 * @author Samuel Ricardo
 * @since release 1
 */
public class ControlPayment {
    private User user;
    private Pix pix;
    private PaymentMethod paymentMethod;
    private PayPal PayPal;
    private Boleto boleto;
    private Date payDate;
    private ControlUser cu;

    public ControlPayment(User user) {
        this.user = user;
    }

    public void setPaymentMethodPix() {
        this.paymentMethod = pix;
    }

    public void setPaymentMethodPayPal() {
        this.paymentMethod = PayPal;
    }

    public void setPaymentMethodBoleto() {
        this.paymentMethod = boleto;
    }

    public PaymentMethod readPayment(PaymentMethod paymentMethod, User user) {
        return user.getPaymentMethod();
    }

    public void payExpense() {}

    public void updatePayment(PaymentMethod paymentMethod, User user) {
        if (paymentMethod == null || user == null) {
            System.out.println("Preencha todos os campos");
        } else {
            user.setPaymentMethod(paymentMethod);
        }
    }

    public void deletePayment(PaymentMethod paymentMethod, User user) {
        user.setPaymentMethod(null);
    }
}
