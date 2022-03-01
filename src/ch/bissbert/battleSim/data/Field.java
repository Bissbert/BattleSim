package ch.bissbert.battleSim.data;

import ch.bissbert.battleSim.data.unit.Team;
import ch.bissbert.battleSim.data.unit.Unit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Field {
    private List<Team> teamsOnField = new ArrayList<>();
    private final int x, y;

    public Field(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public List<Team> getTeamsOnField() {
        return teamsOnField;
    }

    public void setTeamsOnField(List<Team> teamsOnField) {
        this.teamsOnField = teamsOnField;
    }

    @Override
    public String toString() {
        return "Field{" +
                "teamsOnField=" + teamsOnField +
                '}';
    }

    public List<Unit> getAllUnits() {
        return teamsOnField.stream().flatMap(team -> team.getMembers().stream())
                .collect(Collectors.toList());
    }
}
