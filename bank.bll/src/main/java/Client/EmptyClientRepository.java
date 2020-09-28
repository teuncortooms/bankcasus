package Client;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class EmptyClientRepository implements IClientRepository {

    public List<IClientEntity> getAll() {
        return new LinkedList<IClientEntity>();
    }

    public void addClient(IClientEntity client) throws IOException {

    }
}
