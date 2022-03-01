package ch.bissbert.battleSim.data.player;

import ch.bissbert.battleSim.data.Field;
import ch.bissbert.battleSim.data.unit.Unit;

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

    abstract void move();

    abstract void attack();
}
