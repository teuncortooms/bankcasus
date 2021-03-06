package Rekening.Spaarrekening;

import Exceptions.SaldoTeLaagException;
import Rekening.Betaalrekening.IBetaalrekening;
import Rekening.Rekening;

import java.math.BigDecimal;

public class Spaarrekening extends Rekening implements ISpaarrekening {
    private final IBetaalrekening tegenrekening;

    public Spaarrekening(IBetaalrekening tegenrekening) {
        this.tegenrekening = tegenrekening;
    }

    public void opnemen(BigDecimal bedrag) throws SaldoTeLaagException {
        this.afschrijven(bedrag);
        tegenrekening.bijschrijven(bedrag);
    }

    public void inleggen(BigDecimal bedrag) throws SaldoTeLaagException {
        tegenrekening.afschrijven(bedrag);
        this.bijschrijven(bedrag);
    }

    @Override
    public String toString() {
        return String.format("Spaarrekening met rekeningnummer %s heeft een saldo van %s euro.",
                rekeningnummer.toString(), saldo.toString());
    }
}
