package Client;

import ClientDTO.IClientDTO;

import java.util.List;

public interface IClientConverter {
    List<Client> convertToClients(List<IClientDTO> entities);

    Client convertToClient(IClientDTO clientEntity);

    List<IClientDTO> convertToClientDTOs(List<IClient> clients);

    IClientDTO convertToClientDTO(IClient client);
}
