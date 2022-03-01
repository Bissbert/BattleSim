package ch.bissbert.battleSim.data.unit.specific;

import ch.bissbert.battleSim.data.unit.Team;
import ch.bissbert.battleSim.data.unit.RangedUnit;
import ch.bissbert.battleSim.data.weapon.Ak45;

public class AKUnit extends RangedUnit {
    public AKUnit(Team team) {
        super(0, 0, 20, 10, new Ak45(), team);
    }
}
