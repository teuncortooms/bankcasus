package Rekening.Spaarrekening;

import Rekening.Betaalrekening.IBetaalrekening;

public class SpaarrekeningFactory implements ISpaarrekeningFactory {
     @Override
     public Spaarrekening create(IBetaalrekening betaalrekening){
         return new Spaarrekening(betaalrekening);
     }
}
