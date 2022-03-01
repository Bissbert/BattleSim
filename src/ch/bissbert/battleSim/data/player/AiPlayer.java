package ch.bissbert.battleSim.data.player;

import ch.bissbert.battleSim.data.Field;
import ch.bissbert.battleSim.data.unit.Unit;
import ch.bissbert.battleSim.util.MovementUtil;

import java.util.List;

public class AiPlayer extends Player {

    public AiPlayer(Field field, Unit unit) {
        super(field, unit);
    }

    @Override
    public void move() {
        Unit nearestUnit = getNearestUnit();
        getUnit().move(nearestUnit.getX(), nearestUnit.getY());
    }

    @Override
    public void attack() {
        Unit nearestUnit = getNearestUnit();
        this.getUnit().attack(nearestUnit);
    }

    private Unit getNearestUnit() {
        List<Unit> allUnitsOnBoard = getField().getAllUnits();
        Unit me = getUnit();
        return allUnitsOnBoard
                .stream()
                .min((o1, o2) -> (int) Math.round(MovementUtil.distanceBetween(me, o1) - MovementUtil.distanceBetween(me, o2)))
                .orElse(null);
    }
}
