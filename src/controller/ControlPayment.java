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
    
    }

}
