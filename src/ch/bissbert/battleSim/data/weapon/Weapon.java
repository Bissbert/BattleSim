package ch.bissbert.battleSim.data.weapon;

import ch.bissbert.battleSim.data.AttackSuccess;
import ch.bissbert.battleSim.data.unit.Unit;
import ch.bissbert.battleSim.data.weapon.modifier.Modifier;

import java.util.ArrayList;
import java.util.List;

public abstract class Weapon {
    private final String name;
    private final double attackValue;
    private final double attackDistance;
    private final double perFieldReducer;
    private final List<Modifier> modifiers;
    private Unit owner;

    public Weapon(String name, double attackValue, double attackDistance, double perFieldReducer) {
        this.name = name;
        this.attackValue = attackValue;
        this.attackDistance = attackDistance;
        this.perFieldReducer = perFieldReducer;
        this.modifiers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getAttackValue() {
        return attackValue;
    }

    public double getAttackDistance() {
        return attackDistance;
    }

    public double getPerFieldReducer() {
        return perFieldReducer;
    }

    public Unit getOwner() {
        return owner;
    }

    public void setOwner(Unit owner) {
        this.owner = owner;
    }

    public List<Modifier> getModifiers() {
        return modifiers;
    }

    public AttackSuccess use(Unit unit) {

        double distance = Math.sqrt(
                Math.pow(Math.max(unit.getX(), owner.getX()) - Math.min(unit.getX(), owner.getX()), 2)
                        +
                        Math.pow(Math.max(unit.getY(), owner.getY()) - Math.min(unit.getY(), owner.getY()), 2)
        );

        if (distance > this.attackDistance) {
            return AttackSuccess.MISS;
        }

        double damage = new Damage(this.attackValue, this.attackDistance, this.perFieldReducer)
                .modify(modifiers)
                .calculateDamage(distance);

        if (damage > 0) {
            unit.takeDamage(damage);
            if (unit.getHp() >= unit.getMaxHP() / 2) {
                return AttackSuccess.SKIM;
            }
            return AttackSuccess.SUCCESS;
        }
        return AttackSuccess.MISS;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", attackValue=" + attackValue +
                ", attackDistance=" + attackDistance +
                ", perFieldReducer=" + perFieldReducer +
                '}';
    }
}
