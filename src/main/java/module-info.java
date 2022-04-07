module de.atiw.karteikartensystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens de.atiw.karteikartensystem to javafx.fxml;
    exports de.atiw.karteikartensystem;
}