package Client;

import Exceptions.RekeningNietGevondenException;
import Rekening.Betaalrekening.Betaalrekening;
import Rekening.Spaarrekening.ISpaarrekeningFactory;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface IClient {
    UUID getClientNummer();

    List<Betaalrekening> getBetaalrekeningen();

    Betaalrekening getBetaalrekening(UUID betaalrekeningNummer) throws RekeningNietGevondenException;

    Betaalrekening openBetaalrekening(BigDecimal bedrag);

    Betaalrekening openBetaalrekening(BigDecimal bedrag, ISpaarrekeningFactory spaarrekeningFactory);
}
