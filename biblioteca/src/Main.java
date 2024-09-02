import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static DefaultListModel<String> bibliotecariosModel = new DefaultListModel<>();
    private static JList<String> bibliotecariosList = new JList<>(bibliotecariosModel);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Biblioteca");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 400);
            frame.setLayout(new BorderLayout());

            // Panel for form
            JPanel formPanel = new JPanel();
            formPanel.setLayout(new GridLayout(6, 2));

            JLabel cpfLabel = new JLabel("CPF:");
            JTextField cpfField = new JTextField();
            JLabel nomeLabel = new JLabel("Nome:");
            JTextField nomeField = new JTextField();
            JLabel senhaLabel = new JLabel("Senha:");
            JTextField senhaField = new JTextField();
            JLabel emailLabel = new JLabel("Email:");
            JTextField emailField = new JTextField();
            JLabel telefoneLabel = new JLabel("Telefone:");
            JTextField telefoneField = new JTextField();
            JButton addButton = new JButton("Adicionar");

            formPanel.add(cpfLabel);
            formPanel.add(cpfField);
            formPanel.add(nomeLabel);
            formPanel.add(nomeField);
            formPanel.add(senhaLabel);
            formPanel.add(senhaField);
            formPanel.add(emailLabel);
            formPanel.add(emailField);
            formPanel.add(telefoneLabel);
            formPanel.add(telefoneField);
            formPanel.add(new JLabel());  // Empty cell
            formPanel.add(addButton);

            // Panel for list
            JPanel listPanel = new JPanel();
            listPanel.setLayout(new BorderLayout());
            listPanel.add(new JScrollPane(bibliotecariosList), BorderLayout.CENTER);

            // Add panels to frame
            frame.add(formPanel, BorderLayout.NORTH);
            frame.add(listPanel, BorderLayout.CENTER);

            // Action listener for button
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String cpf = cpfField.getText();
                    String nome = nomeField.getText();
                    String senha = senhaField.getText();
                    String email = emailField.getText();
                    String telefone = telefoneField.getText();
                    try {
                        Bibliotecario bibliotecario = new Bibliotecario(cpf, nome, senha, email, telefone);
                        bibliotecario.criarBibliotecario();
                        bibliotecariosModel.addElement(bibliotecario.mostrarPerfil());
                    } catch (DadosInvalidosException ex) {
                        JOptionPane.showMessageDialog(frame, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    } catch (BibliotecarioJaCadastradoException ex) {
                        JOptionPane.showMessageDialog(frame, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            frame.setVisible(true);
        });
    }
}
