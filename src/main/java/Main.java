import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
//        ATM atm = new ATM("HAT_INECOBANK_ATM_021", new RealCash(1000000.00));
//        atm.startATM();

        try {
            FileReader jsonStringReader = new FileReader("src/main/resources/cash_holder.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
