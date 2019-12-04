import london.recruitmentsystem.*;

public class Main {

    public static void main(String[] args) {
        MySQL.obtainConnection();
        String inputStreet = "";
        String inputPostCode = "";
        String inputCity = "";
        String inputCountry = "";
        String inputEmail = "";
        String inputPassword = "";
        String inputTelephoneNumber = "";
        String inputCompanyName = "";
        
        Address inputAddress = new Address(inputStreet, inputPostCode, inputCity, inputCountry);
        Account inputAccount = new Account(inputEmail, inputPassword, inputTelephoneNumber, inputAddress);
        Company inputCompany = new Company(inputAccount, inputCompanyName);
        
        inputCompany.registerCompany();
        
    }
    
}