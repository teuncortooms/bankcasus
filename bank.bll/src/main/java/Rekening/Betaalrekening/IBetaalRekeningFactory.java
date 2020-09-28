package Rekening.Betaalrekening;

import java.math.BigDecimal;

public interface IBetaalRekeningFactory {
    Betaalrekening create(BigDecimal bedrag);
}
