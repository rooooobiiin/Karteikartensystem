module de.atiw.karteikartensystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    exports de.atiw.karteikartensystem.UI;
    opens de.atiw.karteikartensystem.UI to javafx.fxml;
}