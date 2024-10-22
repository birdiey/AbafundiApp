package abafundiapp;

import ac.za.bases.UMfundiDB;
import ac.za.bases.Umfundi;
import java.sql.SQLException;

public class AbafundiApp {

    public static void main(String[] args) throws SQLException {
        Umfundi um;
        UMfundiDB db = new UMfundiDB("jdbc:derby://localhost:1527/Abafundi", "app", "123");

        um = new Umfundi(222958431, "Samkelo", "Khumalo");
        db.addingStudent(um);

        um = new Umfundi(333958431, "Mukelo", "Malo");
        db.addingStudent(um);

        um = new Umfundi(444958431, "Amkelo", "Makhumalo");
        db.addingStudent(um);

        um = new Umfundi(555958431, "Kelo", "Mtungwa");
        db.addingStudent(um);
        
        
        
        System.out.println(db.getCertain(222958431));

    }

}
