
package page;

import javax.swing.*;

public class View {
    static String[] usernames = new String[100];
    static String[] passwords = new String[100];
    static int userCount = 0;

    static JFrame frame;
    static JPanel mainPanel;
    static JPanel loginPanel;
    static JPanel registerPanel;
    static JPanel helloPanel;

    static JTextField loginUsername;
    static JPasswordField loginPassword;
    static JTextField registerUsername;
    static JPasswordField registerPassword;
    static JLabel helloLabel;

    public static void main(String[] args) {
        String appName = "Praktikum PBO Minggu 7";

        frame = new JFrame(appName);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        mainPanel = new JPanel(null);
        frame.setContentPane(mainPanel);

        // Halaman Login
        loginPanel = new JPanel(null);
        loginPanel.setBounds(0, 0, 600, 400);

        JLabel loginTitle = new JLabel("Login Page");
        loginTitle.setBounds(250, 35, 100, 30);

        JLabel loginUserLabel = new JLabel("Username");
        loginUserLabel.setBounds(170, 95, 260, 20);

        loginUsername = new JTextField();
        loginUsername.setBounds(170, 120, 260, 30);

        JLabel loginPassLabel = new JLabel("Password");
        loginPassLabel.setBounds(170, 165, 260, 20);

        loginPassword = new JPasswordField();
        loginPassword.setBounds(170, 190, 260, 30);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(170, 245, 260, 35);

        JButton goRegisterButton = new JButton("Belum punya akun? Register");
        goRegisterButton.setBounds(170, 290, 260, 30);

        loginPanel.add(loginTitle);
        loginPanel.add(loginUserLabel);
        loginPanel.add(loginUsername);
        loginPanel.add(loginPassLabel);
        loginPanel.add(loginPassword);
        loginPanel.add(loginButton);
        loginPanel.add(goRegisterButton);

        // page regis
        registerPanel = new JPanel(null);
        registerPanel.setBounds(0, 0, 600, 400);

        JLabel registerTitle = new JLabel("Register Page");
        registerTitle.setBounds(245, 35, 120, 30);

        JLabel registerUserLabel = new JLabel("Username");
        registerUserLabel.setBounds(170, 95, 260, 20);

        registerUsername = new JTextField();
        registerUsername.setBounds(170, 120, 260, 30);

        JLabel registerPassLabel = new JLabel("Password");
        registerPassLabel.setBounds(170, 165, 260, 20);

        registerPassword = new JPasswordField();
        registerPassword.setBounds(170, 190, 260, 30);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(170, 245, 260, 35);

        JButton goLoginButton = new JButton("Back to Page Login");
        goLoginButton.setBounds(170, 290, 260, 30);

        registerPanel.add(registerTitle);
        registerPanel.add(registerUserLabel);
        registerPanel.add(registerUsername);
        registerPanel.add(registerPassLabel);
        registerPanel.add(registerPassword);
        registerPanel.add(registerButton);
        registerPanel.add(goLoginButton);

        // page helo
        helloPanel = new JPanel(null);
        helloPanel.setBounds(0, 0, 600, 400);

        helloLabel = new JLabel("");
        helloLabel.setBounds(100, 150, 400, 30);

        helloPanel.add(helloLabel);

        // nampilin page login
        mainPanel.add(loginPanel);

        // pas lofin
        loginButton.addActionListener(e -> {
            String username = loginUsername.getText();
            String password = new String(loginPassword.getPassword());

            for (int i = 0; i < userCount; i++) {
                if (usernames[i].equals(username) && passwords[i].equals(password)) {

                    helloLabel.setText("Hello " + username + "!");

                    mainPanel.removeAll();
                    mainPanel.add(helloPanel);
                    mainPanel.revalidate();
                    mainPanel.repaint();
                    return;
                }
            }

            JOptionPane.showMessageDialog(frame, "Gagal!");
        });

        // pindah ke page regid
        goRegisterButton.addActionListener(e -> {
            loginUsername.setText("");
            loginPassword.setText("");

            registerUsername.setText("");
            registerPassword.setText("");

            mainPanel.removeAll();
            mainPanel.add(registerPanel);
            mainPanel.revalidate();
            mainPanel.repaint();
        });

        // pas regis
        registerButton.addActionListener(e -> {
            String username = registerUsername.getText();
            String password = new String(registerPassword.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Username dan password harus diisi!");
                return;
            }

            if (userCount >= usernames.length) {
                JOptionPane.showMessageDialog(frame, "Jumlah user sudah mencapai batas!");
                return;
            }

            for (int i = 0; i < userCount; i++) {
                if (usernames[i].equals(username)) {
                    JOptionPane.showMessageDialog(frame, "Username sudah digunakan!");
                    return;
                }
            }

            usernames[userCount] = username;
            passwords[userCount] = password;
            userCount++;

            JOptionPane.showMessageDialog(frame, "Register berhasil!");

            registerUsername.setText("");
            registerPassword.setText("");
            loginUsername.setText("");
            loginPassword.setText("");

            mainPanel.removeAll();
            mainPanel.add(loginPanel);
            mainPanel.revalidate();
            mainPanel.repaint();
        });

        // balik lagi ke login
        goLoginButton.addActionListener(e -> {
            registerUsername.setText("");
            registerPassword.setText("");

            loginUsername.setText("");
            loginPassword.setText("");

            mainPanel.removeAll();
            mainPanel.add(loginPanel);
            mainPanel.revalidate();
            mainPanel.repaint();
        });

        frame.setVisible(true);
    }
}