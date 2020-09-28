package Bank;

import Client.*;
import Exceptions.ClientNietGevondenException;
import Exceptions.RekeningNietGevondenException;
import Rekening.Betaalrekening.Betaalrekening;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Bank implements IBank {
    private final ClientCollection clientCollection;

    public Bank(ClientCollection clientCollection) {
        this.clientCollection = clientCollection;
    }

    public List<Client> getAllClients() throws IOException {
        return clientCollection.getAllClients();
    }

    public Client getClient(UUID clientNummer) throws ClientNietGevondenException, IOException {
        return clientCollection.getClient(clientNummer);
    }

    public Client aanmeldenClient(String naam, LocalDate geboortedatum) throws IOException {
        return clientCollection.addClient(naam, geboortedatum);
    }

    public Betaalrekening findRekening(UUID betaalrekeningNummer) throws ClientNietGevondenException, RekeningNietGevondenException, IOException {
        IClient client = clientCollection.findClient(betaalrekeningNummer);
        return client.getBetaalrekening(betaalrekeningNummer);
    }
}