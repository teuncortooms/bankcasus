import Bank.Bank;
import Client.ClientCollection;
import Client.ClientConverter;
import Client.ClientFactory;
import Client.ClientEntityRepository;
import Rekening.Betaalrekening.BetaalrekeningFactory;
import Rekening.Spaarrekening.SpaarrekeningFactory;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

public class CompositionRoot {
    private final Bank bank;

    public Bank getBank() {
        return this.bank;
    }

    public CompositionRoot() throws IOException, URISyntaxException {
        var betaalrekeningFactory = new BetaalrekeningFactory(
                new SpaarrekeningFactory()
        );

        this.bank = new Bank(
                new ClientCollection(
                        new ClientEntityRepository(getSourceFile()),
                        new ClientFactory(betaalrekeningFactory),
                        new ClientConverter(betaalrekeningFactory)
                ));
    }

    private String getSourceFile() throws IOException, URISyntaxException {
        URL configFileUrl = getClass().getClassLoader().getResource("config.properties");
        if (configFileUrl == null) throw new IllegalArgumentException("File not found!");
        File configFile = new File(configFileUrl.toURI());
        try (FileReader reader = new FileReader(configFile)) {
            Properties props = new Properties();
            props.load(reader);
            return props.getProperty("clientsource");
        }
    }
}
