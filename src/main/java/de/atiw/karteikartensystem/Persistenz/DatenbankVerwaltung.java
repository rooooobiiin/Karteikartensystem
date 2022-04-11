package de.atiw.karteikartensystem.Persistenz;

import de.atiw.karteikartensystem.Datas.Karteikarte;
import de.atiw.karteikartensystem.Datas.Stapel;

import java.io.File;
import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;

import java.sql.*;

public class DatenbankVerwaltung {
    private static DatenbankVerwaltung Instance;
    private String Username;
    private String Password;

    private DatenbankVerwaltung(String username, String password) throws InvalidParameterException {
        try {
            this.Username = username;
            this.Password = password;
            Connection con = connectToDB();
            con.close();
        }catch(SQLException sqlEx) {
            throw new InvalidParameterException("Benutzername oder Passwort ist falsch. " + sqlEx);
        }
    }

    public static void createInstance(String username, String password) throws InvalidParameterException {
        Instance = new DatenbankVerwaltung(username, password);
    }

    private Connection connectToDB() throws InvalidParameterException {
        //TODO: implementieren
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@db-server.s-atiw.de:1521:atiwora", this.Username, this.Password);
            return conn;
        }catch(SQLException sqlEx) {
            throw new InvalidParameterException("Benutzername oder Passwort ist falsch");
        }

    }

    /***
     * Sucht in der Datenbank alle vorhandenen Stapel.
     * @return Liste von gefundenen Stapeln.
     * @throws SQLException
     */
    public static List<Stapel> readStapelliste() throws SQLException {
        LinkedList<Stapel> stapelListe = new LinkedList<>();
        Connection con = Instance.connectToDB();
        Statement statement = con.createStatement();
        ResultSet results = statement.executeQuery("SELECT * FROM \"Cardtiw_Stapel\"");
        while(results.next()) {
            stapelListe.add(new Stapel(
                results.getInt(1),
                    results.getString(2)
            ));
        }
        return stapelListe;
    }

    /***
     * Fügt den übergebenen Stapel der Datenbank hinzu.
     * @param stapel Ein einzufügender Stapel.
     * @throws SQLException wird bei einem
     */
    public static void createStapel(Stapel stapel) throws InvalidParameterException {
        //TODO: implementieren
        try {
            Connection con = Instance.connectToDB();
            String sql = "INSERT INTO \"Cardtiw_Stapel\"(Name) VALUES (?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, stapel.getName());
            statement.executeUpdate();
        }catch(SQLException sqlEx) {
            throw new InvalidParameterException("Ungültiger Stapel: " + sqlEx);
        }
    }

    /***
     * Erhält eine StapelID und sammelt aus der Datenbank Karteikarten, die diesem Stapel zugewiesen sind.
     * @param stapelID Die ID des Stapels, die einen Stapel representiert.
     * @return Eine Liste von Karteikarten, die dem Stapel zugewiesen sind.
     * @throws SQLException wird geworfen, wenn die übergebene StapelID nicht gefunden wird.
     */
    public static List<Karteikarte> readStapel(int stapelID) throws SQLException {
        LinkedList<Karteikarte> liste = new LinkedList<>();
        Connection con = Instance.connectToDB();
        String sql = "SELECT karte.ID, szk.Stufe, karte.Vorderseite, karte.Rückseite FROM \"Cardtiw_StapelZuKarte\" szk, \"Cardtiw_Karte\" karte WHERE szk.SID=? AND karte.ID=szk.KID";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1,stapelID);
        ResultSet results = statement.executeQuery();
        while(results.next()) {
            liste.add(new Karteikarte(
                results.getInt("ID"),
                results.getString("Vorderseite"),
                results.getString("Rückseite"),
                results.getByte("Stufe")
            ));
        }
        return liste;
    }

    public static void updateStapel(Stapel stapel) {
        //TODO: implementieren
    }

    public static void deleteStapel(Stapel stapel) {
        //TODO: implementieren
    }

    public static void createKarteikarte(Karteikarte karte) {
        //TODO: implementieren
    }

    public static void updateKarteikarte(Karteikarte karte, String vorderseiteNeu, String rueckseiteNeu) {
        //TODO: implementieren
    }

    public static void deleteKarteikarte(Karteikarte karte) {
        //TODO: implementieren
    }

    public static void stapelSynchronisieren(Stapel stapel) {
        //TODO: implementieren
    }


    public static Stapel readCSV(File file) {
        //TODO: implementieren
        return null;
    }

    public static void writeCSV(File file) {
        //TODO: implementieren
    }
}
