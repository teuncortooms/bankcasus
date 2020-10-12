package Client;

import ClientDTO.IClientDTO;
import ClientDTO.IClientDTORepository;
import Exceptions.ClientNietGevondenException;
import Rekening.Betaalrekening.Betaalrekening;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class ClientCollection {
    private final IClientDTORepository clientDTOCollection;
    private final IClientFactory clientFactory;
    private final IClientConverter clientConverter;

    public ClientCollection(IClientDTORepository clientDTOCollection,
                            IClientFactory clientFactory,
                            IClientConverter clientConverter) {
        this.clientDTOCollection = clientDTOCollection;
        this.clientFactory = clientFactory;
        this.clientConverter = clientConverter;
    }

    public List<Client> getAllClients() throws IOException {
        List<IClientDTO> dtos = clientDTOCollection.getAll();
        return clientConverter.convertToClients(dtos);
    }

    public Client getClient(UUID clientNummer) throws ClientNietGevondenException, IOException {
        List<Client> clients = this.getAllClients();
        return clients.stream()
                .filter((c) -> c.getClientNummer().equals(clientNummer))
                .findFirst().orElseThrow(ClientNietGevondenException::new);
    }

    public Client getClient(String naam) throws ClientNietGevondenException, IOException {
        List<Client> clients = this.getAllClients();
        for (var client : clients) {
            String clientNaam = client.getNaam();
            if (clientNaam.equalsIgnoreCase(naam)) return client;
        }
        throw new ClientNietGevondenException();
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
