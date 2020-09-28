package ClientDTO;

import java.time.LocalDate;
import java.util.UUID;

public class ClientDTO implements IClientDTO {
    private UUID clientNummer;
    private String naam;
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
