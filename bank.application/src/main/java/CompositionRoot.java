import Bank.Bank;
import Client.ClientCollection;
import Client.ClientConverter;
import Client.ClientFactory;
import Client.ClientEntityCollection;
import Rekening.Betaalrekening.BetaalrekeningFactory;
import Rekening.Spaarrekening.SpaarrekeningFactory;

public class CompositionRoot {
    private final Bank bank;
    private final ClientCollection clientCollection;
    private final ClientEntityCollection clientEntityCollection;
    private final ClientFactory clientFactory;
    private final ClientConverter clientConverter;
    private final BetaalrekeningFactory betaalrekeningFactory;
    private final SpaarrekeningFactory spaarrekeningFactory;

    public Bank getBank() {
        return this.bank;
    }

    public CompositionRoot() {
        String sourceFile = "C:\\users\\884573\\Desktop\\testFile.json";
        this.spaarrekeningFactory = new SpaarrekeningFactory();
        this.betaalrekeningFactory = new BetaalrekeningFactory(spaarrekeningFactory);
        this.clientConverter = new ClientConverter(betaalrekeningFactory);
        this.clientFactory = new ClientFactory(betaalrekeningFactory);
        this.clientEntityCollection = new ClientEntityCollection(sourceFile);
        this.clientCollection = new ClientCollection(clientEntityCollection, clientFactory, clientConverter);
        this.bank = new Bank(clientCollection);
    }
}
