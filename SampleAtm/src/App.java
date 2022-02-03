public class App extends atm{
    public static void main(String[] args) throws Exception {
        atm a = new atm();
        a.connect();
        String num= a.accnt_num();
        System.out.println("Your account number is "+ num);
    }
}
