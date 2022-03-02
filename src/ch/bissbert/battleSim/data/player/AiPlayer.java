package ch.bissbert.battleSim.data.player;

import ch.bissbert.battleSim.data.Field;
import ch.bissbert.battleSim.data.unit.Unit;
import ch.bissbert.battleSim.util.MovementUtil;

import java.util.List;

/**
 * An AI player to control a single unit.
 *
 * @author Bissbert
 * @version 1.0
 * @since 1.0
 */
public class AiPlayer extends Player {

    public AiPlayer(Field field, Unit unit) {
        super(field, unit);
    }

    /**
     * Moves the unit to the nearest other unit on the field.
     * If there is no other unit, the unit will not move.
     */
    @Override
    public void move() {
        Unit nearestUnit = getNearestUnit();
        if (nearestUnit != null) {
            getUnit().move(nearestUnit.getX(), nearestUnit.getY());
        }
    }

    /**
     * Attacks the nearest unit on the field.
     * If there is no other unit, the unit will not attack.
     */
    @Override
    public void attack() {
        Unit nearestUnit = getNearestUnit();
        if (nearestUnit != null) {
            this.getUnit().attack(nearestUnit);
        }
    }

    /**
     * Returns the nearest unit on the field.
     *
     * @return the nearest unit on the field
     */
    private Unit getNearestUnit() {
        List<Unit> allUnitsOnBoard = getField().getAllUnits();
        Unit me = getUnit();
        return allUnitsOnBoard
                .stream()
                .min((o1, o2) -> (int) Math.round(MovementUtil.distanceBetween(me, o1) - MovementUtil.distanceBetween(me, o2)))
                .orElse(null);
    }
}
