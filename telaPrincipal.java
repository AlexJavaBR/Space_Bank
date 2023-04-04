import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class telaPrincipal extends JFrame {
    private JButton btnVerTabela;
    private JPanel pnlPrincipal;
    private JLabel lblSpacebank;
    private JButton btnCadastrar;
    private JButton btnvoltar;


    public telaPrincipal() {
        iniciarComponentes();
        AddListeners();


    }
    public void iniciarComponentes () {
        setTitle("SPACEBANK");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(pnlPrincipal);
        setVisible(true);
    }

    public void AddListeners () {
        btnVerTabela.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabelaBank tabelabank = new tabelaBank();
                tabelabank.setVisible(true);
                dispose();
            }
        });

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastroBank cadastrobank = new cadastroBank();
                cadastrobank.setVisible(true);
                dispose();

            }
        });

        btnvoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            Space_Bank spaceBank = new Space_Bank();
            spaceBank.setVisible(true);
            dispose();
            }
        });
}
}
