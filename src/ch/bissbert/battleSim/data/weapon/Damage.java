package ch.bissbert.battleSim.data.weapon;

import ch.bissbert.battleSim.data.weapon.modifier.Modifier;

import java.util.List;

public class Damage {
    private double attackValue;
    private double attackDistance;
    private double perFieldReducer;

    public Damage(double attackValue, double attackDistance, double perFieldReducer) {
        this.attackValue = attackValue;
        this.attackDistance = attackDistance;
        this.perFieldReducer = perFieldReducer;
    }

    public Damage() {
    }

    public double getAttackValue() {
        return attackValue;
    }

    public void setAttackValue(double attackValue) {
        this.attackValue = attackValue;
    }

    public double getAttackDistance() {
        return attackDistance;
    }

    public void setAttackDistance(double attackDistance) {
        this.attackDistance = attackDistance;
    }

    public double getPerFieldReducer() {
        return perFieldReducer;
    }

    public void setPerFieldReducer(double perFieldReducer) {
        this.perFieldReducer = perFieldReducer;
    }

    public double calculateDamage(double distance) {
        return this.getAttackValue() - (this.getPerFieldReducer() * distance);
    }

    public Damage modify(List<Modifier> modifiers) {
        modifiers.forEach(modifier -> modifier.modify(this));
        return this;
    }
}
