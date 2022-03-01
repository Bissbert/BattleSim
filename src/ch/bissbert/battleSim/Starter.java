package ch.bissbert.battleSim;

import ch.bissbert.battleSim.data.Field;
import ch.bissbert.battleSim.data.unit.Team;
import ch.bissbert.battleSim.data.unit.RangedUnit;
import ch.bissbert.battleSim.data.unit.Unit;
import ch.bissbert.battleSim.data.weapon.Ak45;

public class Starter {
    public static void main(String[] args) {
        Field field = new Field(10, 10);

        Team russia = new Team("Russia", "#ffffff", field);
        System.out.println(russia);

        spacer();

        Unit unit = new RangedUnit(0,0, 10, 15, new Ak45(), russia);
        Unit unit2 = new RangedUnit(10,5, 10, 15, new Ak45(), russia);
        System.out.println(russia);
        System.out.println(unit2.attack(unit));

        spacer();

        unit.move(30,25);
        System.out.println(unit);

        spacer();

        System.out.println(russia);
    }

    static void spacer(){
        System.out.println("\n");
        System.out.println("---------------------\n\n");
    }
}
