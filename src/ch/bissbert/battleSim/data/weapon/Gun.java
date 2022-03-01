package ch.bissbert.battleSim.data.weapon;

import ch.bissbert.battleSim.data.unit.Unit;
import ch.bissbert.battleSim.exception.OutOfRangeException;

public class Gun extends Weapon{
    public Gun(String name, double attackValue, double attackDistance, double perFieldReducer) {
        super(name, attackValue, attackDistance, perFieldReducer);
        if (attackDistance < 20){
            throw new OutOfRangeException(attackDistance);
        }
    }
}

