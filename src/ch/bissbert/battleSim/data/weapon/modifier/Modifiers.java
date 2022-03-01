package ch.bissbert.battleSim.data.weapon.modifier;

import ch.bissbert.battleSim.data.weapon.Damage;

public enum Modifiers implements Modifier {
    REDUCE_ATTACK_BY_10(damage -> damage.setAttackValue(damage.getAttackValue() - 10)),
    BETTER_SCOPE(damage -> damage.setAttackDistance(damage.getAttackDistance() * 1.2));

    private final Modifier modifier;

    Modifiers(Modifier modifier) {
        this.modifier = modifier;
    }

    @Override
    public void modify(Damage damage) {
        this.modifier.modify(damage);
    }
}
