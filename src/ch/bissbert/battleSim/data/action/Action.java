package ch.bissbert.battleSim.data.action;

import ch.bissbert.battleSim.data.unit.Unit;

/**
 * Action to be executed by on/by a {@link Unit}.
 *
 * @author Bissbert
 * @since 1.0
 * @version 1.0
 */
@FunctionalInterface
public interface Action {
    /**
     * Executes the action on the given {@link Unit}.
     * @param unit the {@link Unit} to execute the action on
     * @return the result of the action
     */
    public ActionSuccess doAction(Unit unit);
}
