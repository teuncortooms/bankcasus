package Client;

import Exceptions.ClientNietGevondenException;
import Rekening.Betaalrekening.Betaalrekening;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class ClientCollection {
    private final IClientDTOCollection clientDTOCollection;
    private final IClientFactory clientFactory;
    private final IClientConverter clientConverter;

    public ClientCollection(IClientDTOCollection clientDTOCollection,
                            IClientFactory clientFactory,
                            IClientConverter clientConverter){
        this.clientDTOCollection = clientDTOCollection;
        this.clientFactory = clientFactory;
        this.clientConverter = clientConverter;
    }

    public List<Client> getAllClients() throws IOException {
        List<IClientDTO> dtos = clientDTOCollection.getAll();
        return clientConverter.convertToClients(dtos);
    }

    public Client getClient(UUID clientNummer) throws ClientNietGevondenException, IOException {
        return this.getAllClients().stream()
                .filter((c) -> c.getClientNummer() == clientNummer)
                .findFirst().orElseThrow(ClientNietGevondenException::new);
    }

    public Client addClient(String naam, LocalDate geboortedatum) throws IOException {
        Client client = this.clientFactory.buildNew(naam, geboortedatum);
        IClientDTO clientDTO = clientConverter.convertToClientDTO(client);
        clientDTOCollection.add(clientDTO);
        return client;
    }

    public Client findClient(UUID betaalrekeningNummer) throws ClientNietGevondenException, IOException {
        for (var client : this.getAllClients()) { // TODO: not working: rekeningen are not persisted
            if (clientHasRekening(client, betaalrekeningNummer)) {
                return client;
            }
        }
        throw new ClientNietGevondenException();
    }

    private boolean clientHasRekening(IClient client, UUID betaalrekeningNummer) {
        List<Betaalrekening> rekeningen = client.getBetaalrekeningen();
        for (var rekening : rekeningen) {
            if (rekening.getRekeningnummer() == betaalrekeningNummer) {
                return true;
            }
        }
        return false;
    }
}
