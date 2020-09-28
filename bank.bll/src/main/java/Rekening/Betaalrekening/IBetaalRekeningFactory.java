package Rekening.Betaalrekening;

import java.math.BigDecimal;

public interface IBetaalrekeningFactory {
    Betaalrekening create(BigDecimal bedrag);
}
