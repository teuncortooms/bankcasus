package Rekening.Betaalrekening;

import Rekening.Spaarrekening.ISpaarrekeningFactory;

import java.math.BigDecimal;

public class BetaalrekeningFactory implements IBetaalrekeningFactory {

    private final ISpaarrekeningFactory spaarrekeningFactory;

    public BetaalrekeningFactory(ISpaarrekeningFactory spaarrekeningFactory){
        this.spaarrekeningFactory = spaarrekeningFactory;
    }

    @Override
    public Betaalrekening create(BigDecimal bedrag)
    {
        return new Betaalrekening(bedrag, this.spaarrekeningFactory);
    }
}
