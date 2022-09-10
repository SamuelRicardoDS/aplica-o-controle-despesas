package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Essa classe é responsável por criar a interface gráfica para adicionar um método de pagamento.
 * 
 * @author Gustavo Henrique
 * @since release 1
 */
public class ViewAddPaymentMethod {
    private JFrame frame;
    private JButton btnPix;
    private JButton btnBoleto;
    private JButton btnPaypal;
    private JLabel background;

    /**
     * Construtor da classe ViewAddPaymentMethod, onde é criada a interface gráfica.
     */
    public ViewAddPaymentMethod() {
        frame = new JFrame();
        frame.setBounds(0, 0, 450, 300);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Forma de Pagamento");
        lblNewLabel.setBounds(140, 45, 155, 15);

        frame.getContentPane().add(lblNewLabel);

        btnPix = new JButton("Pix");
        btnPix.setBounds(22, 149, 117, 25);
        frame.getContentPane().add(btnPix);

        btnBoleto = new JButton("Boleto");
        btnBoleto.setBounds(162, 149, 117, 25);
        frame.getContentPane().add(btnBoleto);

        btnPaypal = new JButton("PayPal");
        btnPaypal.setBounds(300, 149, 117, 25);
        frame.getContentPane().add(btnPaypal);

        background = new JLabel("");
        background.setBounds(173, 111, 70, 15);
        background.setIcon(new ImageIcon(ViewAddPaymentMethod.class.getResource("/images/gustavo.jpg")));
        frame.getContentPane().add(background);

        frame.setLocationRelativeTo(null);
    }

    public JFrame getFrame() {
        return frame;
    }
}
