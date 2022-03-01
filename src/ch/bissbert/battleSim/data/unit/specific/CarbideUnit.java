package ch.bissbert.battleSim.data.unit.specific;

import ch.bissbert.battleSim.data.unit.Team;
import ch.bissbert.battleSim.data.unit.Unit;
import ch.bissbert.battleSim.data.weapon.Carbide;

public class CarbideUnit extends Unit {
    public CarbideUnit(Team team) {
        super(0, 0, 35, 15, new Carbide(), team);
    }

    @Override
    public int getMoveDistance() {
        return 0;
    }
}
