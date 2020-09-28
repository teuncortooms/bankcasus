import Bank.Bank;
import Client.ClientCollection;
import Client.ClientConverter;
import Client.ClientFactory;
import Client.ClientEntityCollection;
import Rekening.Betaalrekening.BetaalrekeningFactory;
import Rekening.Spaarrekening.SpaarrekeningFactory;
import java.io.IOException;

public class CompositionRoot {
    private Bank bank;

    public Bank getBank() {
        return this.bank;
    }

    public CompositionRoot() throws IOException {
        this.bank = new Bank(
                new ClientCollection(
                        new ClientEntityCollection("C:\\users\\884573\\Desktop\\testFile.json"),
                        new ClientFactory(
                                new BetaalrekeningFactory(
                                        new SpaarrekeningFactory()
                                )
                        ),
                        new ClientConverter()
                )
        );
    }
}
