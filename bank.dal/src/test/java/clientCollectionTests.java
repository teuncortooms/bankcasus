import Client.ClientEntityCollection;
import ClientDTO.IClientDTO;
import Mocks.MockClientEntity;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ClientCollectionTests {

    private String emptyFile =  "target/emptyFile.json";
    private String TEST1 =  "target/TEST1.json";

    @Test
    void getAllFromEmptyFile() {
        ClientEntityCollection r = new ClientEntityCollection(emptyFile);

        try {
            List<IClientDTO> clients = r.getAll();
            assertEquals(0, clients.size());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void getAllFromNonEmptyFileTEST1() {
        ClientEntityCollection r = new ClientEntityCollection(TEST1);

        try {
            List<IClientDTO> clients = r.getAll();
            assertEquals("Teun", clients.get(0).getNaam());
            assertEquals(UUID.fromString("7226c1b5-b44e-494e-a0c7-1acbe0a3b02b"), clients.get(0).getClientNummer());
            assertEquals(LocalDate.of(1985, 9, 6), clients.get(0).getGeboortedatum());
            assertEquals("Pietje", clients.get(1).getNaam());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void addClient() {
        ClientEntityCollection r = new ClientEntityCollection(TEST1);
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
        ClientEntityCollection r = new ClientEntityCollection(TEST1);
        IClientDTO client = new MockClientEntity();

        try {
            r.add(client);
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }
}