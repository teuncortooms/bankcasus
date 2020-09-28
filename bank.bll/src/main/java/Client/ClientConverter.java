package Client;

import ClientDTO.ClientDTO;
import ClientDTO.IClientDTO;
import Rekening.Betaalrekening.IBetaalrekeningFactory;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import java.util.LinkedList;
import java.util.List;

public class ClientConverter implements IClientConverter {

    private final IBetaalrekeningFactory betaalrekeningFactory;

    public ClientConverter(IBetaalrekeningFactory betaalrekeningFactory) {
        this.betaalrekeningFactory = betaalrekeningFactory;
    }

    @Override
    public List<Client> convertToClients(List<IClientDTO> clientDTOs) {
        List<Client> clients = new LinkedList<>();
        for (var entity : clientDTOs) {
            clients.add(this.convertToClient(entity));
        }
        return clients;
    }

    @Override
    public Client convertToClient(IClientDTO clientDTO) {
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        Client client = mapper.map(clientDTO, Client.class);
        return client.initAfterMap(this.betaalrekeningFactory);
    }

    @Override
    public List<IClientDTO> convertToClientDTOs(List<IClient> clients) {
        List<IClientDTO> dtos = new LinkedList<>();
        for (var client : clients) {
            dtos.add(this.convertToClientDTO(client));
        }
        return dtos;
    }

    @Override
    public IClientDTO convertToClientDTO(IClient client) {
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        return mapper.map(client, ClientDTO.class);
    }
}
