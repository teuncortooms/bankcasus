import Client.ClientEntityCollection;
import Client.IClientDTO;
import Mocks.MockClientEntity;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class clientCollectionTests {

    private String testfile1 =  "target/TEST1.json";

    @Test
    void getAllFromEmptyFile() {
    }

    @Test
    void getAllFromNonEmptyFileTEST1() {
        ClientEntityCollection r = new ClientEntityCollection(testfile1);

        try {
            List<IClientDTO> clients = r.getAll();
            assertEquals("Teun", clients.get(0).getNaam());
            assertEquals("Pietje", clients.get(1).getNaam());
            assertEquals(UUID.fromString("7225c1b5-b44e-494e-a0c7-1acbe0a3b02b"), clients.get(1).getClientNummer());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void addClient() {
        ClientEntityCollection r = new ClientEntityCollection(testfile1);
        IClientDTO client = new MockClientEntity();

        try {
            r.add(client);
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void addClientInEmptyFile() {
        ClientEntityCollection r = new ClientEntityCollection(testfile1);
        IClientDTO client = new MockClientEntity();

        try {
            r.add(client);
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }
}