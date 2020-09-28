package Client;

import Rekening.Betaalrekening.IBetaalrekeningFactory;
import java.time.LocalDate;

public class ClientFactory implements IClientFactory {

    private final IBetaalrekeningFactory betaalrekeningFactory;

    public ClientFactory(IBetaalrekeningFactory betaalrekeningFactory){
        this.betaalrekeningFactory = betaalrekeningFactory;
    }

    @Override
    public Client buildNew(String naam, LocalDate geboortedatum) {
        return new Client(naam, geboortedatum, this.betaalrekeningFactory);
    }
}
