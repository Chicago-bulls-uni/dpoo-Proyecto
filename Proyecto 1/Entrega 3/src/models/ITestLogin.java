package models;

import seguridad.Autenticador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ITestLogin extends JFrame implements ActionListener {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    private static final int MAX_INTENTOS = 3;
    private static int intentos = 0;
    private static boolean logeado = false;
    private static Autenticador autenticador = new Autenticador();

    public ITestLogin() {
        super("Login");

        JPanel panel = new JPanel(new GridLayout(3, 2));
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");

        loginButton.addActionListener(this);

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(loginButton);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ITestLogin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (autenticador.autenticar(username, password)) {
                logeado = true;
            } else {
                intentos++;
                if (intentos < MAX_INTENTOS) {
                    JOptionPane.showMessageDialog(this, "Por favor, intenta de nuevo.");
                } else {
                    JOptionPane.showMessageDialog(this, "Usuario no logeado. Número máximo de intentos alcanzado.");
                    dispose(); //intentos maximos
                }
            }
            
            if (logeado) {
                JOptionPane.showMessageDialog(this, "Usuario logeado exitosamente.");
                
                dispose(); // sysout
            }
        }
    }
}
