import Bank.IBank;
import Client.IClient;
import Exceptions.ClientNietGevondenException;
import Exceptions.SaldoTeLaagException;
import Rekening.Betaalrekening.IBetaalrekening;
import Rekening.Spaarrekening.ISpaarrekening;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        try {
            CompositionRoot root = new CompositionRoot();
            IBank bank = root.getBank();

            IClient client1 = bank.getClient(UUID.fromString("a6db2f93-a21a-4adb-a9bf-a03c0561c0bd"));
            IClient client2 = bank.aanmeldenClient("Pietje",
                    LocalDate.of(1990, 9, 6));

            IBetaalrekening betaalrekening1 = client1.openBetaalrekening(BigDecimal.ONE);
            IBetaalrekening betaalrekening2 = client2.openBetaalrekening(BigDecimal.ONE);
            ISpaarrekening spaarrekening = betaalrekening2.openSpaarrekening();

            // acties betaalrekeningen
            betaalrekening1.storten(BigDecimal.valueOf(30.00));
            betaalrekening1.overboeken(BigDecimal.valueOf(60.00), betaalrekening2);

            // acties spaarrekening
            spaarrekening.inleggen(BigDecimal.valueOf(40.00));
            spaarrekening.opnemen(BigDecimal.valueOf(10.00));

            System.out.println(betaalrekening1);
            System.out.println(betaalrekening2);
            System.out.println(spaarrekening);

        } catch (IOException e) {
            System.out.println("Er is een fout opgetreden. " +
                    "Het databestand kan niet worden gelezen. " +
                    "Neem contact op met de beheerder.");
            e.printStackTrace();
        } catch (SaldoTeLaagException e) {
            System.out.println("Saldo te laag");
            e.printStackTrace();
        } catch (ClientNietGevondenException e) {
            System.out.println("Er is een fout opgetreden. " +
                    "De cliënt kon niet worden gevonden. " +
                    "Neem contact op met de beheerder.");
            e.printStackTrace();
        } catch (URISyntaxException e) {
            System.out.println("Er is een fout opgetreden. " +
                    "De configuratiefile kan niet worden gelezen. " +
                    "Neem contact op met de beheerder.");
            e.printStackTrace();
        }
    }
}
