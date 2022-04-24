package de.atiw.karteikartensystem.Persistenz;

import de.atiw.karteikartensystem.Datas.Karteikarte;
import de.atiw.karteikartensystem.Datas.Stapel;

import java.io.*;
import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;

import java.sql.*;
import java.util.Scanner;

public class DatenbankVerwaltung {
    public static final String ConnectionString = "jdbc:mysql://82.165.240.186:3306/Cardtiw_DB";
    private static DatenbankVerwaltung Instance;
    private String Username;
    private String Password;

    /***
     * Privater Konstruktor, der überprüft, ob die Anmeldedaten korrekt sind und eine Verbindung zur
     * Datenbank aufgebaut werden kann.
     * @param username Benutzername für den Datenbankaccount.
     * @param password Passwort für den Datenbankaccount.
     * @throws InvalidParameterException wird geworfen, falls die Anmeldedaten ungültig sind.
     */
    private DatenbankVerwaltung(String username, String password) throws InvalidParameterException {
        try {
            //Attribute setzten
            this.Username = username;
            this.Password = password;
            //Überprüfe, ob man sich verbinden kann.
            Connection con = connectToDB();
            con.close();
        }catch(SQLException sqlEx) {
            throw new InvalidParameterException("Benutzername oder Passwort ist falsch. " + sqlEx);
        }
    }

    /***
     * Erstellt eine Instanz, die die Zugriffsdaten für die Datenbank speichert.
     * @param username Benutzername für den Datenbankzugriff.
     * @param password Passwort für den Datenbankzugriff.
     * @throws InvalidParameterException wird geworfen, falls ein Verbindungsfehler entsteht.
     */
    public static void createInstance(String username, String password) throws InvalidParameterException {
        Instance = new DatenbankVerwaltung(username, password);
    }

    /***
     * Baut eine einmalige Datenbankverbindung auf.
     * @return Eine offene Verbindung zur Datenebank.
     * @throws InvalidParameterException wird geworfen, falls ein Verbindungsfehler entsteht.
     */
    private Connection connectToDB() throws InvalidParameterException {
        try{
            Connection conn = DriverManager.getConnection(ConnectionString, this.Username, this.Password);
            return conn;
        }catch(SQLException sqlex) {
            throw new InvalidParameterException("Ungültige Benutzername und Passwort Kombination.");
        }


    }

    /***
     * Sucht in der Datenbank alle vorhandenen Stapel.
     * @return Liste von gefundenen Stapeln.
     * @throws SQLException
     */
    public static List<Stapel> readStapelliste() throws SQLException {
        LinkedList<Stapel> stapelListe = new LinkedList<>();
        Connection con = Instance.connectToDB(); //Verbinden mit der Datenbank
        Statement statement = con.createStatement(); //Erstellen eines SQL Statements
        ResultSet results = statement.executeQuery("SELECT * FROM Cardtiw_Stapel"); //Ausführen
        //Für jede Zeile soll ein Stapel Objekt erstellt werden.
        while(results.next()) {
            stapelListe.add(new Stapel(
                results.getInt("ID"),
                    results.getString("Name")
            ));
        }
        return stapelListe;
    }

    /***
     * Fügt den übergebenen Stapel der Datenbank hinzu.
     * @param stapelName Der Name des einzufügenden Stapels
     * @throws SQLException wird bei einem
     */
    public static void createStapel(String stapelName) throws InvalidParameterException {
        try {
            Connection con = Instance.connectToDB(); //Mit Datenbank verbinden
            String sql = "INSERT INTO Cardtiw_Stapel(Name) VALUES (?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, stapelName);
            statement.executeUpdate();//SQL Statement ausführen
        }catch(SQLException sqlEx) {
            throw new InvalidParameterException("Ungültiger Stapel: " + sqlEx);
        }
    }

    /***
     * Findet die letzte hinzugefügte ID in der Stapel Tabelle von der Datenbank.
     * @return Ganzzahl, die die ID representiert.
     */
    private static int getStapelLastID() {
        try {
            //Verbinde zur DB
            Connection con = Instance.connectToDB();
            String sql = "SELECT max(ID) AS \"Last ID\" FROM Cardtiw_Stapel cs";
            Statement statement = con.createStatement();
            //Lese Resultate, sollte nur eine Zeile sein
            ResultSet result = statement.executeQuery(sql);
            result.next();
            return result.getInt("Last ID");
        }catch(SQLException sqlEx) {
            throw new InvalidParameterException("Ungültiger Stapel: " + sqlEx);
        }
    }

    /***
     * Erhält eine StapelID und inititialisiert den Stapel inklusive der enthaltenen Karteikarten.
     * @param stapelID Die ID des Stapels, die einen Stapel repräsentiert.
     * @return Eine Liste von Karteikarten, die dem Stapel zugewiesen sind.
     * @throws SQLException wird geworfen, wenn die übergebene StapelID nicht gefunden wird.
     */
    public static Stapel readStapel(int stapelID) throws SQLException {
        //Erhalte die Informationen des Stapels
        Connection con = Instance.connectToDB(); //Verbinde zur DB
        String sql = "SELECT * FROM Cardtiw_Stapel WHERE ID=?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, stapelID);
        ResultSet results = statement.executeQuery();
        results.next(); //Nur eine Zeile wird erwartet
        Stapel stapel = new Stapel(results.getInt("ID"), results.getString("Name"));

        //Neue SQL Abfrage, um Karteikarten für den Stapel zu finden.
        con = Instance.connectToDB(); //Erneutes Verbinden mit der DB.
        sql = "SELECT karte.ID, szk.Stufe, karte.Vorderseite, karte.Rueckseite FROM Cardtiw_StapelZuKarten szk, Cardtiw_Karten karte WHERE szk.SID=? AND karte.ID=szk.KID";
        statement = con.prepareStatement(sql);
        statement.setInt(1,stapelID); //Setzt den Parameter ID
        results = statement.executeQuery();
        //Für jede Zeile Query-Resultat, soll ein neues Karteikartenobjekt erstellt werden.
        //Und wird dem Stapel hinzugefügt.
        while(results.next()) {
            stapel.addKarteikarte(new Karteikarte(
                results.getInt("ID"),
                results.getString("Vorderseite"),
                results.getString("Rueckseite"),
                results.getByte("Stufe")
            ));
        }
        return stapel;
    }

    /***
     * Updatet die Attribute eines Stapels.
     * @param stapel der geupdatet werden soll.
     * @throws InvalidParameterException wird geworfen, wenn die Datenbank nicht in der Lage ist, den Stapel zu updaten.
     */
    public static void updateStapel(Stapel stapel) throws InvalidParameterException {
        try {
            Connection con = Instance.connectToDB();//Verbinde mit DB
            String sql = "UPDATE Cardtiw_Stapel SET Name=? WHERE ID=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, stapel.getName()); //Setzt neuen Namen
            statement.setInt(2, stapel.getStapelID()); //Setzt ID
            statement.executeUpdate();
        }catch(SQLException sqlEx){
            throw new InvalidParameterException(sqlEx.getMessage());
        }
    }

    /***
     * Löscht den übergebenen Stapel aus der Datenbank.
     * @param stapel der gelöscht werden soll.
     * @throws InvalidParameterException wird geworfen, wenn die Datenbank den Stapel nicht löschen konnte.
     */
    public static void deleteStapel(Stapel stapel) throws InvalidParameterException {
        try {
            //Zuerst den Key constraint löschen
            Connection con = Instance.connectToDB();
            String sql = "DELETE FROM Cardtiw_StapelZuKarten cszk WHERE SID=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, stapel.getStapelID());
            statement.executeUpdate();
            //Danach lösche den Stapel
            con = Instance.connectToDB();
            sql = "DELETE FROM Cardtiw_Stapel WHERE ID=?";
            statement = con.prepareStatement(sql);
            statement.setInt(1, stapel.getStapelID());
            statement.executeUpdate();
        }catch(SQLException sqlEx) {
            throw new InvalidParameterException(sqlEx.getMessage());
        }
    }

    /***
     * Speichert die Karteikarte in der Datenbank und weist dieser, dem übergebenen Stapel hinzu.
     * @param karte Die in die Datenbank einzufügende Karteikarte.
     * @param StapelID ID vom Stapel, zu der die Karteikarte gehört.
     */
    public static void createKarteikarte(Karteikarte karte, int StapelID) throws InvalidParameterException {
        try {
            //Füge die Karteikarte in die Datenbank ein.
            Connection con = Instance.connectToDB();
            String sql = "INSERT INTO Cardtiw_Karten(Vorderseite, Rueckseite) VALUES(?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, karte.getVoderseite());
            statement.setString(2, karte.getRueckseite());
            statement.executeUpdate();
            int id = getKarteikarteLastID();//Finde passende ID
            //Füge die Verbindung von Stapel und der Karteikarte hinzu.
            con = Instance.connectToDB();
            sql = "INSERT INTO Cardtiw_StapelZuKarten(SID, KID, Stufe) VALUES (?,?,1)";
            statement = con.prepareStatement(sql);
            statement.setInt(1, StapelID);
            statement.setInt(2, id);
            System.out.println(statement.toString());
            statement.executeUpdate();
        }catch(SQLException sqlEx){
            throw new InvalidParameterException(sqlEx.getMessage());
        }
    }

    /***
     * Sucht nach der letzten ID die in der Tabelle Karteikarten eingefügt wurde.
     * @return Ganzzahl, die die letzte hinzugefügte ID representiert.
     * @throws SQLException wird geworfen, sobald ein Fehler mit der Datenbankverbindung auftritt.
     */
    private static int getKarteikarteLastID() throws SQLException {
        Connection con = Instance.connectToDB();
        String sql = "SELECT ID FROM Cardtiw_Karten ck WHERE ck.ID=(SELECT max(ID) FROM Cardtiw_Karten ck2 )";
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(sql);
        result.next();
        return result.getInt("ID");
    }

    /***
     * Updatet die Attribute der Karteikarte in der Datenbank.
     * @param karte Karte die geupdatet werden soll.
     * @param vorderseiteNeu Neuer Text, der auf der Vorderseite sein soll.
     * @param rueckseiteNeu Neuer Text, der auf der Rückseite sein soll.
     * @throws InvalidParameterException wird geworfen, falls die Datenbank die Anfrage nicht bearbeiten kann.
     */
    public static void updateKarteikarte(Karteikarte karte, String vorderseiteNeu, String rueckseiteNeu) throws InvalidParameterException {
        try {
            Connection con = Instance.connectToDB();
            String sql = "UPDATE Cardtiw_Karten SET VORDERSEITE=?, RUECKSEITE=? WHERE ID=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, vorderseiteNeu);
            statement.setString(2, rueckseiteNeu);
            statement.setInt(3, karte.getKarteiKartenID());
            statement.executeUpdate();
        }catch(SQLException sqlEx){
            throw new InvalidParameterException(sqlEx.getMessage());
        }
    }

    /***
     * Löscht die Karteikarte aus der Datenbank.
     * @param karte die gelöscht werden soll.
     * @throws InvalidParameterException wird geworfen, falls die Datenbank den Auftrag nicht verarbeiten kann.
     */
    public static void deleteKarteikarte(Karteikarte karte) throws InvalidParameterException {
        try {
            //Zuerst Key constraint löschen
            Connection con = Instance.connectToDB();
            String sql = "DELETE FROM Cardtiw_StapelZuKarten ck  WHERE KID=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, karte.getKarteiKartenID());
            statement.executeUpdate();

            //Danach die Karte an sich.
            con = Instance.connectToDB();
            sql = "DELETE FROM Cardtiw_Karten ck  WHERE ID=?";
            statement = con.prepareStatement(sql);
            statement.setInt(1, karte.getKarteiKartenID());
            statement.executeUpdate();
        }catch(SQLException sqlEx){
            throw new InvalidParameterException(sqlEx.getMessage());
        }
    }

    /***
     * Entfernt die Karteikarte aus einem Stapel, bleibt aber dennoch in der Datenbank vorhanden.
     * @param karte die aus dem Stapel entfernt werden soll.
     * @param stapelID ID des Stapels, aus dem die Karteikarte entfernt werden soll.
     */
    public static void removeKarteVonStapel(Karteikarte karte, int stapelID){
        try {
            //Zuerst Key constraint löschen
            Connection con = Instance.connectToDB();
            String sql = "DELETE FROM Cardtiw_StapelZuKarten ck  WHERE KID=? AND SID=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, karte.getKarteiKartenID());
            statement.setInt(2, stapelID);
            statement.executeUpdate();
        }catch(SQLException sqlEx){
            throw new InvalidParameterException(sqlEx.getMessage());
        }
    }

    public static void stapelSynchronisieren(Stapel stapel) {
        //TODO: implementieren
    }



}
