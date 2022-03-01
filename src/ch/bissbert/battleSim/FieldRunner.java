package ch.bissbert.battleSim;

import ch.bissbert.battleSim.data.Field;
import ch.bissbert.battleSim.data.unit.Team;
import ch.bissbert.battleSim.data.unit.Unit;
import ch.bissbert.battleSim.data.unit.specific.AKUnit;
import ch.bissbert.battleSim.data.unit.specific.CarbideUnit;
import ch.bissbert.battleSim.data.weapon.modifier.Modifier;
import ch.bissbert.battleSim.data.weapon.modifier.Modifiers;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class FieldRunner extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("/ch/bissbert/battleSim/fxml/Main.fxml"));
        Scene scene = new Scene(parent);

        stage.setTitle("Bissberts Battler");
        stage.setScene(scene);
        stage.show();
    }
}
