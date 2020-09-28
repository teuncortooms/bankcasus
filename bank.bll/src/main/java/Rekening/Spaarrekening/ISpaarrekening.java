package Rekening.Spaarrekening;

import Exceptions.SaldoTeLaagException;
import Rekening.IRekening;

import java.math.BigDecimal;

public interface ISpaarrekening extends IRekening {

    void opnemen(BigDecimal bedrag) throws SaldoTeLaagException;

    void inleggen(BigDecimal bedrag) throws SaldoTeLaagException;

}
