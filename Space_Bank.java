import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Space_Bank extends JFrame {
    private JPanel pnlBanco;
    private JLabel lblTitulo;
    private JButton btnLogin;
    private JButton btnCadastrar;
    private JButton btnVerTabela;


    public Space_Bank() {
        AddListeners();
        iniciarComponentes();

    }
    public void iniciarComponentes () {
        setTitle("SPACEBANK");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(pnlBanco);
        setVisible(true);
    }

    public void AddListeners () {


        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                loginBank loginbank = new loginBank();
                loginbank.setVisible(true);
                dispose();
            }

        });


    }

    public static void main (String[]args){
        Space_Bank spacebank = new Space_Bank();
    }

    }



