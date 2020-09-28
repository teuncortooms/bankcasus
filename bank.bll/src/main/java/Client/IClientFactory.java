package Client;

import java.time.LocalDate;
import java.util.List;

public interface IClientFactory {
    Client buildNew(String naam, LocalDate geboortedatum);
}
