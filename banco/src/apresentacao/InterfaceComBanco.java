package apresentacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class InterfaceComBanco extends JFrame {
    private JTextField nomeField, emailField;
    private JButton salvarButton;

    public InterfaceComBanco() {
        setTitle("Cadastro de Usuários");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Nome:"));
        nomeField = new JTextField();
        add(nomeField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salvarUsuario(nomeField.getText(), emailField.getText());
            }
        });
        add(salvarButton);
    }

    private void salvarUsuario(String nome, String email) {
        String url = "jdbc:mysql://localhost:3306/meu_banco"; 
        String user = ""; 
        String password = ""; 

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO usuarios (nome, email) VALUES (?, ?)")) {
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Usuário salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InterfaceComBanco frame = new InterfaceComBanco();
            frame.setVisible(true);
        });
    }
}