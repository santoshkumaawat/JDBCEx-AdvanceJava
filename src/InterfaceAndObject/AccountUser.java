package InterfaceAndObject;

public class AccountUser {

    public static void main(String[] args) {

        Account acc = AccountCreator.getAccount(5);
        System.out.println(acc);
    }
}
