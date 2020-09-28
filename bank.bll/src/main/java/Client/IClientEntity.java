package Client;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public interface IClientEntity {
    String getNaam();
    Date getGeboortedatum();
    UUID getClientNummer();

    void setNaam(String naam);
    void setGeboortedatum(Date datum);
    void setClientNummer(UUID id);
}
