package controller;

import model.Boleto;
import model.PayPal;
import model.PaymentMethod;
import model.Pix;
import model.User;

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
        Pix pix = new Pix(null, null, null, null);
        PayPal PayPal = new PayPal(null, null, null, null, null);
        Boleto boleto = new Boleto(null, null, null, null, null);

        if(paymentMethod = pix) {
            user.getPaymentMethod().add(paymentMethod);
        } else if(paymentMethod = PayPal) {
            user.getPaymentMethod().add(paymentMethod);
        } else if(paymentMethod = boleto) {
            user.getPaymentMethod().add(paymentMethod);
        }
    }
}
