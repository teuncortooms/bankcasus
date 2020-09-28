package Client;

import ClientDTO.IClientDTO;
import ClientDTO.IClientDTOCollection;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ClientEntityCollection implements IClientDTOCollection {
    private final String filename;

    public ClientEntityCollection(String filename) {
        this.filename = filename;
    }

    public List<IClientDTO> getAll() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile = new File(filename);

        if (!jsonFile.exists()) {
            try {
                createDummyFile(jsonFile);
                System.out.println("JSON file not found: new file with dummy data created at " + jsonFile.getAbsolutePath());
            } catch (Exception e) {
                System.out.println("JSON file not found. Failed to create dummy file. Please edit the filepath in CompositionRoot.");
            }
        }

        try (InputStream is = new FileInputStream(filename)) {
            ClientEntity[] array = mapper.readValue(is, ClientEntity[].class);
            return new LinkedList<>(Arrays.asList(array));
        }
    }

    private void createDummyFile(File jsonFile) throws IOException {
        jsonFile.createNewFile();
        String str = "[{\"naam\":\"Jan\"},{\"naam\":\"Jorrit\"}]";
        writeToFile(str);
    }

    public void add(IClientDTO entity) throws IOException {
        List<IClientDTO> clients = this.getAll();
        clients.add(entity);
        writeToFile(clients);
    }

    private void writeToFile(List<IClientDTO> entities) throws IOException {
        File jsonFile = new File(filename);
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.writeValue(jsonFile, entities);
    }

    private void writeToFile(String str) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(str);
        }
    }
}
