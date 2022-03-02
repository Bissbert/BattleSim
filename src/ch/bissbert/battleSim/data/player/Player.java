package ch.bissbert.battleSim.data.player;

import ch.bissbert.battleSim.data.Field;
import ch.bissbert.battleSim.data.unit.Unit;

/**
 * A player in a game that controls a single unit.
 *
 * @author Bissbert
 * @version 1.0
 * @since 1.0
 */
public abstract class Player {

    private final Field field;
    private final Unit unit;

    protected Player(Field field, Unit unit) {
        this.field = field;
        this.unit = unit;
    }

    public Field getField() {
        return field;
    }

    public Unit getUnit() {
        return unit;
    }

    /**
     * Moves the unit as defined in the implementation.
     */
    abstract void move();

    /**
     * The unit uses an action as defined in the implementation.
     */
    abstract void attack();
}
