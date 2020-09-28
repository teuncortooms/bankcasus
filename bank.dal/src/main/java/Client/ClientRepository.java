package Client;

import Exceptions.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ClientRepository implements IClientRepository {
    private final String filename;

    public ClientRepository(String resource) {
        this.filename = resource;
    }

    public List<IClientEntity> getAll() throws FileReaderException {
        ObjectMapper mapper = new ObjectMapper();

        try {
            InputStream is = ClientRepository.class.getResourceAsStream(filename);
            ClientEntity[] array = mapper.readValue(is, ClientEntity[].class);
            return new LinkedList<>(Arrays.asList(array));
        } catch (IOException e) {
            throw new FileReaderException(e);
        }
    }

    public void addClient(IClientEntity client) throws FileReaderException, FileWriterException {
        List<IClientEntity> clients = this.getAll();
        clients.add(client);
        writeToFile(clients);
    }

    private void writeToFile(List<IClientEntity> clients) throws FileWriterException {
        String path = ClientRepository.class.getResource(this.filename).getPath(); // TODO: wrong path?
        File clientsFile = new File(path);
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(clientsFile, clients);
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileWriterException(e);
        }
    }
}
