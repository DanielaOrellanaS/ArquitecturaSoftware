package com.banquito.corepasivos.utils;

public class Validations {

    public static Boolean validateIdentificationByType(String identification, String identificationType)
            throws Exception {
        if (identificationType.equals("DNI"))
            return validateDNI(identification);

        if (identificationType.equals("RUC"))
            return validateRUC(identification);

        if (identificationType.equals("PAS"))
            return validatePassport(identification);

        return false;
    }

    private static Boolean isNumeric(String value) {
        if (value.chars().allMatch(Character::isDigit))
            return true;
        return false;
    }

    protected static Boolean validatePassport(String passport) throws Exception {
        if (passport.length() > 16 || passport.length() <= 0)
            throw new RuntimeException("The passport: " + passport + " is too long.");
        return true;
    }

    protected static Boolean validateRUC(String ruc) throws Exception {
        if (ruc.length() != 13)
            throw new RuntimeException("The identification: " + ruc + " doesn't have correct length");

        try {
            validateInitial(ruc);
            validateProvinceCode(ruc.substring(0, 2));
            validateThirdDigit(String.valueOf(ruc.charAt(2)));
            validateEstablishmentCode(ruc.substring(10, 13));
            validateDigits(ruc.substring(0, 9), Integer.parseInt(String.valueOf(ruc.charAt(9))));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    protected static boolean validateEstablishmentCode(String rucEstablishmentCode) throws Exception {
        if (Integer.parseInt(rucEstablishmentCode) < 1) {
            throw new Exception("The establishment dode shouldn't be 0");
        }
        return true;
    }

    protected static Boolean validateDNI(String dni) throws Exception {
        if (dni.length() != 10)
            throw new RuntimeException("The identification: " + dni + " doesn't have correct length");

        try {
            validateInitial(dni);
            validateProvinceCode(dni.substring(0, 2));
            validateThirdDigit(String.valueOf(dni.charAt(2)));
            validateDigits(dni, Integer.parseInt(String.valueOf(dni.charAt(9))));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    protected static Boolean validateInitial(String dni) throws Exception {
        if (!isNumeric(dni)) {
            throw new Exception("The identification just can have digits");
        }
        return true;
    }

    protected static Boolean validateProvinceCode(String codeProvinceDNI) throws Exception {
        if (Integer.parseInt(codeProvinceDNI) < 0 || Integer.parseInt(codeProvinceDNI) > 24) {
            throw new Exception("The province code shouldn't be greater than 24 nor less than 0");
        }
        return true;
    }

    protected static Boolean validateThirdDigit(String thirdDigitDNI) throws Exception {
        if (Integer.parseInt(thirdDigitDNI) < 0 || Integer.parseInt(thirdDigitDNI) > 5) {
            throw new Exception("The third digit of DNI should be greater or equal 0 and less 6 ");
        }
        return true;
    }

    protected static Boolean validateDigits(String digits, int checkDigit) throws Exception {
        Integer[] arrayCoefficients = new Integer[] { 2, 1, 2, 1, 2, 1, 2, 1, 2 };

        Integer[] initialDigits = new Integer[digits.length()];
        int index = 0;
        for (char digit : digits.toCharArray()) {
            initialDigits[index] = Integer.parseInt(String.valueOf(digit));
            index++;
        }

        int total = 0;
        int key = 0;
        for (Integer digit : initialDigits) {
            if (key < arrayCoefficients.length) {
                digit = (initialDigits[key] * arrayCoefficients[key]);

                if (digit >= 10) {
                    char[] digitSplit = String.valueOf(digit).toCharArray();
                    digit = (Integer.parseInt(String.valueOf(digitSplit[0])))
                            + (Integer.parseInt(String.valueOf(digitSplit[1])));

                }
                total = total + digit;
            }

            key++;
        }

        int residue = total % 10;
        int result;

        if (residue == 0) {
            result = 0;
        } else {
            result = 10 - residue;
        }

        if (result != checkDigit)
            throw new Exception("Dígitos iniciales no validan contra Dígito Idenficador");

        return true;
    }
}
