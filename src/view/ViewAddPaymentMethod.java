// essa view era pra efetuar o pagamento, mas não conseguimos terminar a tempo
// package view;

// import controller.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import javax.swing.ImageIcon;
// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JLabel;

// /**
//  * Essa classe é responsável por criar a interface gráfica para adicionar um método de pagamento.
//  *
//  * @author Gustavo Henrique
//  * @since release 1
//  */
// public class ViewAddPaymentMethod {
//     private JFrame frame;
//     private JButton btnPix;
//     private JButton btnBoleto;
//     private JButton btnPaypal;
//     private JLabel background;
//     private ControlUser cu;
//     private ControlPayment cp;

//     /**
//      * Construtor da classe ViewAddPaymentMethod, onde é criada a interface gráfica.
//      */
//     public ViewAddPaymentMethod(int selectedExpenses) {
//         cu = new ControlUser();
//         cp = new ControlPayment(cu.readOne(cu.getUsername()));

//         frame = new JFrame();
//         frame.setBounds(0, 0, 450, 300);
//         frame.getContentPane().setLayout(null);
//         frame.setLocationRelativeTo(null);
//         frame.setVisible(true);

//         JLabel lblNewLabel = new JLabel("Forma de Pagamento");
//         lblNewLabel.setBounds(140, 45, 155, 15);

//         frame.getContentPane().add(lblNewLabel);

//         btnPix = new JButton("Pix");
//         btnPix.setBounds(22, 149, 117, 25);
//         frame.getContentPane().add(btnPix);

//         btnPix.addActionListener(
//             new ActionListener() {

//                 public void actionPerformed(ActionEvent e) {
//                     frame.dispose();
//                 }
//             }
//         );

//         btnBoleto = new JButton("Boleto");
//         btnBoleto.setBounds(162, 149, 117, 25);
//         frame.getContentPane().add(btnBoleto);

//         btnBoleto.addActionListener(
//             new ActionListener() {

//                 public void actionPerformed(ActionEvent e) {
//                     frame.dispose();
//                 }
//             }
//         );

//         btnPaypal = new JButton("PayPal");
//         btnPaypal.setBounds(300, 149, 117, 25);
//         frame.getContentPane().add(btnPaypal);

//         btnPaypal.addActionListener(
//             new ActionListener() {

//                 public void actionPerformed(ActionEvent e) {
//                     frame.dispose();
//                 }
//             }
//         );

//         background = new JLabel(new ImageIcon(ViewShowExpenses.class.getResource("/images/gustavo.jpg")));
//         background.setBounds(-151, -47, 800, 400);
//         frame.getContentPane().add(background);
//     }

//     public JFrame getFrame() {
//         return frame;
//     }
// }
