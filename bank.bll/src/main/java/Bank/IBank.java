package Bank;

import Client.Client;
import Exceptions.ClientNietGevondenException;
import Exceptions.RekeningNietGevondenException;
import Rekening.Betaalrekening.Betaalrekening;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface IBank {
    Client getClient(UUID clientNummer) throws ClientNietGevondenException, IOException;
    Client getClient(String naam) throws ClientNietGevondenException, IOException;
    List<Client> getAllClients() throws IOException;
    Client aanmeldenClient(String naam, LocalDate geboortedatum) throws IOException;
    Betaalrekening findRekening(UUID betaalrekeningNummer) throws ClientNietGevondenException, RekeningNietGevondenException, IOException;
}