package Util;

import javax.swing.*;

public class Validation {

    public boolean usernameValid(String username){
        return validateNotNull(username, "username");
        //TODO could add regex as an other check.
        //TODO could check for existing username if database issue is resolved.
    }

    public boolean mailValid(String mail) {
        return validateNotNull(mail, "mailadres");
    }

    public boolean passwordValid(String password) {
        return validateNotNull(password, "wachtwoord");
    }

    public boolean passwordConfirmedValid(String password, String passwordConfirm) {
        if ( password.equals(passwordConfirm)) {
            return true;
        } else {
            passwordEqualMessage();
            return false;
        }
    }

    public boolean streetValid(String street) {
        return validateNotNull(street, "straatnaam");
    }

    public boolean numberValid(String number) {
        return validateNotNull(number, "huisnummer");
    }

    public boolean zipcodeValid(String zipcode) {
        return validateNotNull(zipcode, "postcode");
    }

    public boolean cityValid(String city) {
        return validateNotNull(city, "woonplaats");
    }

    private boolean validateNotNull(String x, String field) {
        if ( x.isEmpty()) {
            notNullMessage(field);
            return false;
        } else {
            return true;
        }
    }

    private void notNullMessage(String field) {
        Object[] options = { "OK"};
        String message = "gelieve een " + field + " in te vullen.";
        JOptionPane.showOptionDialog(null,
                message,
                "Marktplaats",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);
    }

    private void passwordEqualMessage(){
        Object[] options = { "OK"};
        String message = "Wachtwoorden moeten gelijk zijn.";
        JOptionPane.showOptionDialog(null,
                message,
                "Marktplaats",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);
    }

}
