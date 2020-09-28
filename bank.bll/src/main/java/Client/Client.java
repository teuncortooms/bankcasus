package Client;

import Exceptions.RekeningNietGevondenException;
import Rekening.Betaalrekening.Betaalrekening;
import Rekening.Betaalrekening.IBetaalrekeningFactory;
import Rekening.Spaarrekening.ISpaarrekeningFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Client implements IClient {
    private String naam;
    private LocalDate geboortedatum;
    private UUID clientNummer;
    private List<Betaalrekening> betaalrekeningen;
    private IBetaalrekeningFactory betaalRekeningFactory;

    public Client(String naam, LocalDate geboortedatum, IBetaalrekeningFactory betaalRekeningFactory) {
        this.clientNummer = UUID.randomUUID();
        this.naam = naam;
        this.geboortedatum = geboortedatum;
        this.betaalrekeningen = new LinkedList<>();
        this.betaalRekeningFactory = betaalRekeningFactory;
    }

    public Client() {
        // used for mapping from DTO
    }

    @Override
    public Client initAfterMap(IBetaalrekeningFactory betaalrekeningFactory) {
        this.betaalRekeningFactory = betaalrekeningFactory;
        this.betaalrekeningen = new LinkedList<>();
        return this;
    }

    public String getNaam() {
        return this.naam;
    }

    public LocalDate getGeboortedatum() {
        return this.geboortedatum;
    }

    public UUID getClientNummer() {
        return this.clientNummer;
    }

    public void setNaam(String value){this.naam = value;}
    public void setGeboortedatum(LocalDate value){this.geboortedatum = value;}
    public void setClientNummer(UUID value){this.clientNummer = value;}


    public List<Betaalrekening> getBetaalrekeningen() {
        return this.betaalrekeningen;
    }

    public Betaalrekening getBetaalrekening(UUID betaalrekeningNummer) throws RekeningNietGevondenException {
        return this.getBetaalrekeningen().stream()
                .filter((c) -> c.getRekeningnummer() == betaalrekeningNummer)
                .findFirst().orElseThrow(RekeningNietGevondenException::new);
    }

    public Betaalrekening openBetaalrekening(BigDecimal bedrag) {
        Betaalrekening nieuweRekening = this.betaalRekeningFactory.create(bedrag);
        this.betaalrekeningen.add(nieuweRekening);
        return nieuweRekening;
    }

    public Betaalrekening openBetaalrekening(BigDecimal bedrag, ISpaarrekeningFactory spaarrekeningFactory) {
        Betaalrekening nieuweRekening = this.betaalRekeningFactory.create(bedrag);
        this.betaalrekeningen.add(nieuweRekening);
        return nieuweRekening;
    }

}
