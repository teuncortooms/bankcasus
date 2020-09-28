package Client;

import ClientDTO.IClientDTO;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import java.time.LocalDate;
import java.util.UUID;

public class ClientEntity implements IClientDTO {
    private UUID clientNummer;
    private String naam;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate geboortedatum;

    @Override
    public String getNaam() {
        return this.naam;
    }

    @Override
    public LocalDate getGeboortedatum() {
        return this.geboortedatum;
    }

    @Override
    public UUID getClientNummer() {
        return this.clientNummer;
    }

    @Override
    public void setNaam(String naam) {
        this.naam = naam;
    }

    @Override
    public void setGeboortedatum(LocalDate datum) {
        this.geboortedatum = datum;
    }

    @Override
    public void setClientNummer(UUID id) {
        this.clientNummer = id;
    }
}
