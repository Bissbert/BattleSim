package ch.bissbert.battleSim.data.action;

import ch.bissbert.battleSim.data.unit.Unit;

@FunctionalInterface
public interface Action {
    public ActionSuccess doAction(Unit unit);
}
