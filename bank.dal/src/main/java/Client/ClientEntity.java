package Client;

import java.util.Date;
import java.util.UUID;

public class ClientEntity implements IClientEntity {
    private UUID clientNummer;
    private String naam;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
//    @JsonDeserialize(using = LocalDateDeserializer.class)
//    @JsonSerialize(using = LocalDateSerializer.class)
    private Date geboortedatum;


    @Override
    public String getNaam() {
        return this.naam;
    }

    @Override
    public Date getGeboortedatum() {
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
    public void setGeboortedatum(Date datum) {
        this.geboortedatum = datum;
    }

    @Override
    public void setClientNummer(UUID id) {
        this.clientNummer = id;
    }
}
