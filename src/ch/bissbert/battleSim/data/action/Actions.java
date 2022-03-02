package ch.bissbert.battleSim.data.action;

import ch.bissbert.battleSim.data.AttackSuccess;
import ch.bissbert.battleSim.data.unit.Unit;

import java.util.Optional;

/**
 * This enum contains some implementations of the {@link Action} interface to be used in the simulation.
 *
 * @author Bissbert
 * @version 1.0
 * @since 1.0
 */
public enum Actions implements Action {
    ATTACK(unit -> {
        AttackSuccess attackSuccess = unit.attack(unit.getTarget());
        return attackSuccess == AttackSuccess.SUCCESS ? ActionSuccess.SUCCESS : (attackSuccess == AttackSuccess.SKIM ? ActionSuccess.PARTIAL : ActionSuccess.FAIL);
    });

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ActionSuccess doAction(Unit unit) {
        return action.doAction(unit);
    }
}
