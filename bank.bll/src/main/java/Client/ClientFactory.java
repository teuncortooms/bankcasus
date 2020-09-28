package Client;

import Rekening.Betaalrekening.IBetaalRekeningFactory;
import org.dozer.DozerBeanMapper;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class ClientFactory implements IClientFactory {

    private final IBetaalRekeningFactory betaalrekeningFactory;

    public ClientFactory(IBetaalRekeningFactory betaalrekeningFactory){
        this.betaalrekeningFactory = betaalrekeningFactory;
    }

    @Override
    public Client buildNew(String naam, LocalDate geboortedatum) {
        return new Client(naam, geboortedatum, this.betaalrekeningFactory);
    }

    @Override
    public Client build(IClientEntity clientEntity) {
        DozerBeanMapper mapper = new DozerBeanMapper();
        return mapper.map(clientEntity, Client.class);
    }

    @Override
    public List<Client> buildList(List<IClientEntity> entities) {
        List<Client> clients = new LinkedList<>();
        for (var entity : entities) {
            clients.add(this.build(entity));
        }
        return clients;
    }

}
