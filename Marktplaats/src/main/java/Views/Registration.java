package Views;

import DAOS.UserDao;
import Entities.Address;
import Entities.User;
import Util.Validation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registration extends JFrame implements ActionListener {

    private JFrame frame;
    private JLabel titleLabel = new JLabel("Registratie formulier");
    private JLabel usernameLabel = new JLabel("Username");
    private JLabel mailLabel = new JLabel("Mail");
    private JLabel passwordLabel = new JLabel("Wachtwoord");
    private JLabel confirmPasswordLabel = new JLabel("Bevestig wachtwoord");
    private JLabel addressLabel = new JLabel("Adres");
    private JLabel streetLabel = new JLabel("Straatnaam");
    private JLabel numberLabel = new JLabel("Huisnummer");
    private JLabel cityLabel = new JLabel("Woonplaats");
    private JLabel zipcodeLabel = new JLabel("Postcode");
    private String[] shipmentMethods={ "Thuis afhalen", "Versturen", "Magazijn afhalen", "Versturen onder remours"};
    private JLabel shipLabel = new JLabel("Verzending");
    private JComboBox shipmentMethodsComboBox = new JComboBox(shipmentMethods);
    private JTextField usernameTextField = new JTextField();
    private JTextField mailTextField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JPasswordField confirmPasswordField = new JPasswordField();
    private JTextField streetTextField = new JTextField();
    private JTextField numberTextField = new JTextField();
    private JTextField cityTextField = new JTextField();
    private JTextField zipcodeTextField = new JTextField();
    private JButton registerButton = new JButton("Registreren");
    private JButton resetButton = new JButton("Reset");

    public Registration(){
        makeFrame();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }

    public void makeFrame() {

        frame = new JFrame();
        frame.setTitle("Marktplaats");
        frame.setBounds(40, 40, 500, 600);
        frame.getContentPane().setBackground(Color.decode("#8fcae7"));
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public void setLocationAndSize() {

        titleLabel.setBounds(185, 5, 160, 50);
        usernameLabel.setBounds(20,40,80,70);
        usernameTextField.setBounds(200,63,230,23);
        mailLabel.setBounds(20, 80,40, 70);
        mailTextField.setBounds(200,103, 230, 23);
        passwordLabel.setBounds(20,120,80, 70);
        passwordField.setBounds(200, 143, 230,23);
        confirmPasswordLabel.setBounds(20, 160, 140, 70);
        confirmPasswordField.setBounds(200, 183, 230, 23);
        addressLabel.setBounds(20, 200, 50,70);
        streetLabel.setBounds(20, 240, 100, 70);
        streetTextField.setBounds(200, 263, 230,23);
        numberLabel.setBounds(20, 280, 100, 70);
        numberTextField.setBounds(200, 303, 40,23);
        zipcodeLabel.setBounds(275, 280, 80,70);
        zipcodeTextField.setBounds(350, 303, 80, 23);
        cityLabel.setBounds(20,320, 100, 70);
        cityTextField.setBounds(200, 343, 230,23);
        shipLabel.setBounds(20,360, 100,70);
        shipmentMethodsComboBox.setBounds(200, 383, 230, 23);
        registerButton.setBounds(100, 500, 120, 23);
        resetButton.setBounds(270, 500, 120, 23);

    }

    private void addComponentsToFrame() {

        frame.add(titleLabel);
        frame.add(usernameLabel);
        frame.add(usernameTextField);
        frame.add(mailLabel);
        frame.add(mailTextField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(confirmPasswordLabel);
        frame.add(confirmPasswordField);
        frame.add(addressLabel);
        frame.add(streetLabel);
        frame.add(streetTextField);
        frame.add(numberLabel);
        frame.add(numberTextField);
        frame.add(zipcodeLabel);
        frame.add(zipcodeTextField);
        frame.add(cityLabel);
        frame.add(cityTextField);
        frame.add(shipLabel);
        frame.add(shipmentMethodsComboBox);
        frame.add(registerButton);
        frame.add(resetButton);

    }

    public void actionEvent(){
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==registerButton) {

            if(inputIsValid()) {

                this.createNewUser();
            }
        } //TODO add reset button function.

    }

    private boolean inputIsValid() {

        Validation valid = new Validation();

        if (!valid.usernameValid(usernameTextField.getText())) return false;
        if (!valid.mailValid(mailTextField.getText())) return false;
        if (!valid.passwordValid(passwordField.getText())) return false;
        if (!valid.passwordConfirmedValid(passwordField.getText(), confirmPasswordField.getText())) return false;
        if (!valid.streetValid(streetTextField.getText())) return false;
        if (!valid.numberValid(numberTextField.getText())) return false;
        if (!valid.zipcodeValid(zipcodeTextField.getText())) return false;
        if (!valid.cityValid(cityTextField.getText())) return false;


        return true;
    }

    private void createNewUser() {

        int number = Integer.parseInt(numberTextField.getText());

        Address address = new Address(
                streetTextField.getText(),
                number,
                zipcodeTextField.getText(),
                cityTextField.getText()
        );



        User user = new User(
                usernameTextField.getText(),
                passwordField.getText(),
                mailTextField.getText(),
                shipmentMethodsComboBox.getActionCommand(),
                address
        );

        //TODO Hibernate dialect issue.
        UserDao ud = new UserDao();
        ud.insertUser(user);
    }

}
