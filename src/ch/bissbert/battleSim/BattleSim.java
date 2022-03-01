package ch.bissbert.battleSim;

import ch.bissbert.battleSim.data.Field;
import ch.bissbert.battleSim.data.unit.Team;
import ch.bissbert.battleSim.data.unit.Unit;
import ch.bissbert.battleSim.data.unit.specific.AKUnit;
import ch.bissbert.battleSim.data.unit.specific.CarbideUnit;
import ch.bissbert.battleSim.data.weapon.modifier.Modifier;
import ch.bissbert.battleSim.data.weapon.modifier.Modifiers;
import javafx.application.Application;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BattleSim {
    private static Field FIELD;

    public static void main(String[] args) {

        System.out.println(Arrays.toString(args));

        Field field = new Field(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        Random obj = new Random();

        int i = 2;

        for (; i < args.length; i++) {
            String teamString = args[i];

            String[] teamSplit = teamString.split("=");
            final String teamName = teamSplit[0];

            int rand_num = obj.nextInt(0xffffff + 1);
            String colorCode = String.format("#%06x", rand_num);

            Team team = new Team(teamName, colorCode, field);

            for (String units : teamSplit[1].split(",")) {
                createUnits(units, team);
            }
        }

        FIELD = field;

        Application.launch(FieldRunner.class);
    }

    private static void createUnits(String units, Team team) {
        int count = Integer.parseInt(units.substring(1));
        Class<? extends Unit> unitClass;
        List<Modifier> modifiers = new ArrayList<>();

        switch (units.charAt(0)) {
            case 's':
                modifiers.add(Modifiers.BETTER_SCOPE);
            case 'a':
                unitClass = AKUnit.class;
                break;
            case 'c':
            default:
                unitClass = CarbideUnit.class;
        }

        for (int i = 0; i < count; i++) {
            try {
                Unit unit = unitClass.getDeclaredConstructor(Team.class).newInstance(team);
                unit.getWeapon().getModifiers().addAll(modifiers);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

    }
}
