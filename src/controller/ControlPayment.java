package controller;

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

    public ControlPayment(User user) {
        this.user = user;
    }

    public void createPayment(PaymentMethod paymantMethod, User user) {
        Pix pix = new Pix(null, null, null, null, null);
        PayPal PayPal = new PayPal(null, null, null, null, null, null);
        Boleto boleto = new Boleto(null, null, null, null, null, null);

        if (paymantMethod == null || user == null) {
            System.out.println("Preencha todos os campos");
        } else {
            if (paymantMethod == pix) {
                pix = new Pix(null, null, null, null, null);
                user.setPaymentMethod(pix);
            } else if (paymantMethod == PayPal) {
                PayPal = new PayPal(null, null, null, null, null, null);
                user.setPaymentMethod(PayPal);
            } else if (paymantMethod == boleto) {
                boleto = new Boleto(null, null, null, null, null, null);
                user.setPaymentMethod(boleto);
            }
        }

    }

    public PaymentMethod readPayment(PaymentMethod paymantMethod, User user) {
        return user.getPaymentMethod();
    }

    public void updatePayment(PaymentMethod paymantMethod, User user) {
        if (paymantMethod == null || user == null) {
            System.out.println("Preencha todos os campos");
        } else {
            user.setPaymentMethod(paymantMethod);
        }
    }

    public void deletePayment(PaymentMethod paymantMethod, User user) {
        user.setPaymentMethod(null);
    }
}
