import Client.ClientRepository;
import Client.IClientEntity;
import Exceptions.FileReaderException;
import Exceptions.FileWriterException;
import Mocks.MockClientEntity;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientRepositoryTests {

    private String testfile1 =  "/TEST1.json";

    @Test
    void getAllFromEmptyFile() {
    }

    @Test
    void getAllFromNonEmptyFileTEST1() {
        ClientRepository r = new ClientRepository(testfile1);

        try {
            List<IClientEntity> clients = r.getAll();
            assertEquals(clients.get(0).getNaam(), "Teun");
            assertEquals(clients.get(1).getNaam(), "Pietje");
        } catch (FileReaderException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void addClient() {
        ClientRepository r = new ClientRepository(testfile1);
        IClientEntity client = new MockClientEntity();

        try {
            r.addClient(client);
        } catch (FileWriterException | FileReaderException e) {
            fail();
            // integration test: check resource!
        }
    }

    @Test
    void addClientInEmptyFile() {
        ClientRepository r = new ClientRepository(testfile1);
        IClientEntity client = new MockClientEntity();

        try {
            r.addClient(client);
        } catch (FileReaderException | FileWriterException e) {
            fail();
            // integration test: check resource!
        }
    }

}