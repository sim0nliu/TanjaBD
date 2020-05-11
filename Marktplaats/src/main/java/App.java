import Views.Registration;

import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) {
        start();
    }


    private static void start() {
        Object[] options = { "Afsluiten", "Registreren", "Inloggen"};
        Object selectedValue = JOptionPane.showOptionDialog(null,
                "Wilt u registreren of inloggen?",
                "Marktplaats",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[2]);

        if (selectedValue.equals(2)) {
            startInloggen();
        }
        else if (selectedValue.equals(1)) {
            startRegistreren();
        }

    }

    public static void startRegistreren() {
        new Registration();
    }

    private static void startInloggen() {
        functionNotAvailable();
    }

    private static void functionNotAvailable() {
        Object[] options = { "Afsluiten"};
        JOptionPane.showOptionDialog(null,
                "Deze functie is helaas nog niet beschikbaar.",
                "Marktplaats",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);
    }

}
