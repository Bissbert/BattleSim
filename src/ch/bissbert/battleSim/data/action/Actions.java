package ch.bissbert.battleSim.data.action;

import ch.bissbert.battleSim.data.AttackSuccess;
import ch.bissbert.battleSim.data.unit.Unit;

import java.util.Optional;

public enum Actions implements Action {
    ATTACK(unit -> {
        AttackSuccess attackSuccess = unit.attack(unit.getTarget());
        return attackSuccess == AttackSuccess.SUCCESS ? ActionSuccess.SUCCESS : (attackSuccess == AttackSuccess.SKIM ? ActionSuccess.PARTIAL : ActionSuccess.FAIL);
    });

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    @Override
    public ActionSuccess doAction(Unit unit) {
        return action.doAction(unit);
    }
}
