import Bank.Bank;
import Client.ClientFactory;
import Client.ClientRepository;
import Exceptions.FileReaderException;
import Rekening.Betaalrekening.BetaalrekeningFactory;
import Rekening.Spaarrekening.SpaarrekeningFactory;

import java.io.IOException;

public class CompositionRoot {
    private Bank bank;

    public Bank getBank() {
        return this.bank;
    }

    public CompositionRoot() throws IOException, FileReaderException {
        this.bank = new Bank(
                new ClientRepository("/clients.json"),
                new ClientFactory(
                        new BetaalrekeningFactory(
                                new SpaarrekeningFactory()
                        )
                )
        );
    }
}
