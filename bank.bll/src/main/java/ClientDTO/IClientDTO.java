package ClientDTO;
import java.time.LocalDate;
import java.util.UUID;

public interface IClientDTO {
    String getNaam();
    LocalDate getGeboortedatum();
    UUID getClientNummer();

    void setNaam(String naam);
    void setGeboortedatum(LocalDate datum);
    void setClientNummer(UUID id);
}
