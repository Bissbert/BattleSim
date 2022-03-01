package ch.bissbert.battleSim.data;

import ch.bissbert.battleSim.data.unit.Team;
import ch.bissbert.battleSim.data.unit.Unit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Field {
    private List<Team> teamsOnField = new ArrayList<>();

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
