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

    public void createPayment(User user) {
        PaymentMethod paymentMethod = new PaymentMethod();
        Pix pix = new Pix(null, null, null, null);
        PayPal PayPal = new PayPal(null, null, null, null, null);
        Boleto boleto = new Boleto(null, null, null, null, null);

        if(PaymentMethod paymentMethod = pix) {
            user.getPaymentMethods().add(paymentMethod);
        } else if(PaymentMethod paymentMethod = PayPal) {
            user.getPaymentMethods().add(paymentMethod);
        } else if(PaymentMethod paymentMethod = boleto) {
            user.getPaymentMethods().add(paymentMethod);
        }
    }
}
