package Client;

import org.dozer.DozerBeanMapper;

import java.util.LinkedList;
import java.util.List;

public class ClientConverter implements IClientConverter {

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
        DozerBeanMapper mapper = new DozerBeanMapper();
        return mapper.map(clientDTO, Client.class);
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
        DozerBeanMapper mapper = new DozerBeanMapper();
        return mapper.map(client, ClientDTO.class);
    }
}
