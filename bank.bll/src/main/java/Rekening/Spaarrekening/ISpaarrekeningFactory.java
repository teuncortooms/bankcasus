package Rekening.Spaarrekening;

import Rekening.Betaalrekening.IBetaalrekening;

public interface ISpaarrekeningFactory {
    Spaarrekening create(IBetaalrekening betaalrekening);
}
