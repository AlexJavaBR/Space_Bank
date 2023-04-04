import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginBank extends JFrame {
    private JLabel lblCPF;
    private JLabel lblSenha;
    private JTextField textCPF;
    private JPasswordField pswSenha;
    private JButton btnEntrar;
    private JPanel pnlLogin;

    public loginBank() {
        iniciarComponentes();
        AddListeners();
    }

    public void iniciarComponentes() {
        setTitle("Login SpaceBank");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(pnlLogin);
        setVisible(true);
    }

    public void AddListeners() {
        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String CPF = textCPF.getText();
                String Senha = new String((pswSenha.getPassword()));

                if (CPF.equals("123") && Senha.equals("3418")) {
                    telaPrincipal telaprincipal = new telaPrincipal();
                    telaprincipal.setVisible(true);
                    dispose();


                } else {
                    JOptionPane.showMessageDialog(btnEntrar, "CPF ou senha incorretos!");
                }
            }


        });


    }
}


