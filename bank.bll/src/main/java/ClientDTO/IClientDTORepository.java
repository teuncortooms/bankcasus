package ClientDTO;

import java.io.IOException;
import java.util.List;

public interface IClientDTORepository {
    List<IClientDTO> getAll() throws IOException;
    void add(IClientDTO client) throws IOException;
}
