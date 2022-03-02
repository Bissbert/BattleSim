package ch.bissbert.battleSim.data.unit;

import ch.bissbert.battleSim.data.AttackSuccess;
import ch.bissbert.battleSim.data.weapon.Weapon;
import ch.bissbert.battleSim.util.MovementUtil;

public abstract class Unit {
    private int x, y;
    private double hp, maxHP;
    protected int moveDistance;
    private Weapon weapon;
    private Team team;
    private Unit target;

    public Unit(int x, int y, int hp, int moveDistance, Weapon weapon, Team team) {
        setX(x);
        setY(y);
        setHp(hp);
        setMaxHP(hp);
        setMoveDistance(moveDistance);
        setWeapon(weapon);
        setTeam(team);
    }

    public Unit() {

    }


    public abstract int getMoveDistance();

    public AttackSuccess attack(Unit unit) {
        return getWeapon().use(unit);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public void setMoveDistance(int moveDistance) {
        this.moveDistance = moveDistance;
    }

    public Unit getTarget() {
        return target;
    }

    public void setTarget(Unit target) {
        this.target = target;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
        weapon.setOwner(this);
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
        if (!team.getMembers().contains(this)) {
            team.addMember(this);
        }
    }

    public double getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(double maxHP) {
        this.maxHP = maxHP;
    }

    public void move(int x, int y) {

        /*System.out.println();

        double totalDistToPoint = Math.sqrt(
                Math.pow(Math.max(x, getX()) - Math.min(x, getX()), 2)
                        +
                        Math.pow(Math.max(y, getY()) - Math.min(y, getY()), 2)
        );

        System.out.println("Distance to point " + totalDistToPoint);

        double x3 = this.getX() + (this.moveDistance / totalDistToPoint) * (x - this.getX());
        double y3 = this.getY() + (this.moveDistance / totalDistToPoint) * (y - this.getY());

        System.out.println("The new coordinates: (" + x3 + "," + y3 + ")");

        //setX((int) x3);
        //setY((int) y3);*/

        double[] newPoint = MovementUtil.pointBetweenV2(new double[]{this.getX(), this.getY()}, new double[]{x, y}, this.getMoveDistance());

        setX((int) Math.round(newPoint[0]));
        setY((int) Math.round(newPoint[1]));

    }

    public void takeDamage(double damage) {
        this.hp -= damage;
        if (this.hp <= 0) {
            this.getTeam().getMembers().remove(this);
        }
    }


    @Override
    public String toString() {
        return "Unit{" +
                "x=" + x +
                ", y=" + y +
                ", hp=" + hp +
                ", maxHP=" + maxHP +
                ", moveDistance=" + moveDistance +
                ", weapon=" + weapon +
                ", team=" + team.getName() +
                '}';
    }
}
