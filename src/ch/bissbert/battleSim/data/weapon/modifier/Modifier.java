package ch.bissbert.battleSim.data.weapon.modifier;

import ch.bissbert.battleSim.data.weapon.Damage;

@FunctionalInterface
public interface Modifier {
    public void modify(Damage damage);
}
