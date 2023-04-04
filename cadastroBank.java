import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class cadastroBank extends JFrame{
    private JPanel pnlCadastrar;
    private JLabel lblNome;
    private JLabel lblCPF;
    private JLabel lblEndereco;
    private JLabel lblProfissao;
    private JLabel lblRenda;
    private JLabel lblSenha;
    private JPasswordField pswSenhaCad;
    private JTextField textRenda;
    private JTextField textProfissao;
    private JTextField textEndereco;
    private JTextField textCPF;
    private JTextField textNome;
    private JButton btnCadastrar;
    private JButton btnVoltar;
    private JButton btnlimpar;
    final String URL = "jdbc:mysql://localhost:3306/spaceBank";

    final String USER = "root";

    final String PASSWORD = "root99";

    final String INSERIR = "INSERT INTO usuarios (Nome, CPF, Endereco, Profissao, Renda, Senha) VALUES (?, ?, ?, ?, ?, ?)";

    public cadastroBank() {
        iniciarComponentes();
        Conecta();

    }


    public void Conecta () {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado!");

            final PreparedStatement stmtInserir;

            stmtInserir = connection.prepareStatement(INSERIR);

            btnCadastrar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String nome = textNome.getText();
                    String CPFStr = textCPF.getText();
                    String endereco = textEndereco.getText();
                    String profissao = textProfissao.getText();
                    String renda = textRenda.getText();
                    String senhacad = pswSenhaCad.getText();

                    try {
                        int CPF = Integer.parseInt(CPFStr);
                        stmtInserir.setString(1, nome);
                        stmtInserir.setInt(2, CPF);
                        stmtInserir.setString(3, endereco);
                        stmtInserir.setString(4, profissao );
                        stmtInserir.setString(5, renda);
                        stmtInserir.setString(6, senhacad);

                        stmtInserir.executeUpdate();
                        System.out.println("Dados inseridos!");
                        JOptionPane.showMessageDialog(btnCadastrar, "Dados inseridos!");
                        textNome.setText("");
                        textCPF.setText("");
                        textEndereco.setText("");
                        textProfissao.setText("");
                        textRenda.setText("");
                        pswSenhaCad.setText("");

                    } catch (NumberFormatException ex) {
                        System.out.println("O CPF informado não é um número!");
                    } catch (Exception ex) {
                        System.out.println("Erro ao inserir dados no banco!");
                    }
                }
            });
        } catch (Exception ex) {
            System.out.println("Erro ao conectar ao banco de dados!");
        }

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                telaPrincipal telaprincipal = new telaPrincipal();
                telaprincipal.setVisible(true);
                dispose();

            }
        });

        btnlimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textNome.setText("");
                textCPF.setText("");
                textEndereco.setText("");
                textProfissao.setText("");
                textRenda.setText("");
                pswSenhaCad.setText("");
            }
        });
    }
    public void iniciarComponentes () {
        setTitle("Cadastro de Usuários");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(pnlCadastrar);
        setVisible(true);
    }

    }






