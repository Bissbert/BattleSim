package ch.bissbert.battleSim.data.unit;

import ch.bissbert.battleSim.data.weapon.Gun;
import ch.bissbert.battleSim.data.weapon.Weapon;

public class RangedUnit extends Unit {

    public RangedUnit(int x, int y, int hp, int moveDistance, Gun weapon, Team team) {
        super(x, y, hp, moveDistance, weapon, team);
    }

    @Override
    public int getMoveDistance() {
        return moveDistance;
    }

    @Override
    public void setWeapon(Weapon weapon) {
        if (weapon instanceof Gun)
            super.setWeapon(weapon);
        else
            throw new RuntimeException("weapon for ranged unit has to be a Gun");
    }
}
