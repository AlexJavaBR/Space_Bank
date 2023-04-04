import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class tabelaBank extends JFrame {
    private JTable tblBank;
    private JButton btnExcluir;
    private JButton btnVoltar;
    private JPanel pnlbank;

    final String URL = "jdbc:mysql://localhost:3306/spaceBank";
    final String USER = "root";
    final String PASSWORD = "root99";
    final String CONSULTAR = "SELECT * FROM usuarios";
    final String EXCLUIR = "DELETE FROM usuarios WHERE CPF = ?";

    public tabelaBank(){
        iniciarComponentes();
        AddListener();
    }
    public void AddListener () {

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                telaPrincipal telaprincipal = new telaPrincipal();
                telaprincipal.setVisible(true);
                dispose();

            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                Connection connection = null;

                try {
                    int linhaSelecionada = tblBank.getSelectedRow();
                    if (linhaSelecionada < 0) {
                        JOptionPane.showMessageDialog(null,
                                "Selecione uma linha para excluir");
                        return;
                    }
                    int CPF = (int) tblBank.getValueAt(linhaSelecionada, 1);
                    connection = DriverManager.getConnection(URL, USER, PASSWORD);
                    PreparedStatement stmt = connection.prepareStatement(EXCLUIR);
                    stmt.setInt(1, CPF);
                    int resultado = stmt.executeUpdate();

                    if (resultado == 1) {
                        JOptionPane.showMessageDialog(null,
                                "Registro excluído com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Erro ao excluir registro!");
                    }
                    DefaultTableModel Nome = (DefaultTableModel) tblBank.getModel();
                    Nome.removeRow(linhaSelecionada);
                } catch (SQLException ex) {
                    System.out.println("Erro ao excluir registro: " +
                            ex.getMessage());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Selecione uma linha para excluir!");

                }
            }

        });

        DefaultTableModel usuarios = new DefaultTableModel();
        usuarios.addColumn("Nome");
        usuarios.addColumn("CPF");
        usuarios.addColumn("Endereco");
        usuarios.addColumn("Profissao");
        usuarios.addColumn("Renda");
        usuarios.addColumn("Senha");
        tblBank.setModel(usuarios);

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = null;
            stmt = connection.createStatement();

            ResultSet rs = null;
            rs = stmt.executeQuery(CONSULTAR);

            while (rs.next()) {
                Object[] row = new Object[6];
                row[0] = rs.getObject(1);
                row[1] = rs.getObject(2);
                row[2] = rs.getObject(3);
                row[3] = rs.getObject(4);
                row[4] = rs.getObject(5);
                row[5] = rs.getObject(6);
                usuarios.addRow(row);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void iniciarComponentes () {
        setTitle("Tabela SpaceBank");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(pnlbank);
        setVisible(true);

    }




}



