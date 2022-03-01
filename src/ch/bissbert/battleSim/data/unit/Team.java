package ch.bissbert.battleSim.data.unit;

import ch.bissbert.battleSim.data.Field;
import ch.bissbert.battleSim.data.player.AiPlayer;
import ch.bissbert.battleSim.data.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Unit> members;
    private List<Player> players;
    private final String color;
    private final Field field;

    public Team(String name, String color, Field field) {
        this.name = name;
        this.color = color;
        this.field = field;
        field.getTeamsOnField().add(this);
        this.members = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Unit> getMembers() {
        return members;
    }

    public void setMembers(List<Unit> members) {
        this.members = members;
    }

    public String getColor() {
        return color;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Field getField() {
        return field;
    }

    public void addMember(Unit unit, Player player) {
        this.getMembers().add(unit);
        this.getPlayers().add(player);
    }

    public void addMember(Unit unit) {
        this.addMember(unit, new AiPlayer(this.getField(), unit));
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", members=" + members.stream().map(unit -> unit.getClass().getSimpleName()).toList() +
                ", color='" + color + '\'' +
                '}';
    }
}
