package Rekening.Betaalrekening;

import Exceptions.RekeningNietGevondenException;
import Exceptions.SaldoTeLaagException;
import Rekening.IRekening;
import Rekening.Spaarrekening.Spaarrekening;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface IBetaalrekening extends IRekening {

    List<Spaarrekening> getSpaarrekeningen();

    Spaarrekening getSpaarrekening(UUID spaarrekeningNummer) throws RekeningNietGevondenException;

    void overboeken(BigDecimal bedrag, IBetaalrekening tegenrekening)
            throws SaldoTeLaagException, IllegalArgumentException;

    Spaarrekening openSpaarrekening();

    void storten(BigDecimal bedrag);

}