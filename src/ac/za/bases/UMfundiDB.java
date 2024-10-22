package ac.za.bases;

import java.sql.Connection;
import static java.sql.DriverManager.getConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UMfundiDB {

    private Connection con;

    public UMfundiDB(String dbURL, String username, String passw) throws SQLException {
        con = getConnection(dbURL, username, passw);
    }

    //getting certain student
    public Umfundi getCertain(Integer code) {

        String sql = "SELECT StudentNumber,Name,Surname " + " FROM ABAFUNDITBL WHERE StudentNumber=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, code);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int studNumber = rs.getInt("StudentNumber");
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");

                Umfundi um = new Umfundi(studNumber, name, surname);

                rs.close();
                return um;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;

    }

    public void addingStudent(Umfundi m) {

        String sql = "INSERT INTO ABAFUNDITBL(StudentNumber,Name,Surname) VALUES(?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, m.getStudentNumber());
            ps.setString(2, m.getName());
            ps.setString(3, m.getSurname());
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public List<Umfundi> getAll() {
        String sql = "SELECT * FROM ABAFUNDITBL ";
        List<Umfundi> list = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int studN = rs.getInt("StudentNumber");
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");

                Umfundi um = new Umfundi(studN, name, surname);
                list.add(um);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return list;

    }
    
    public void del(Umfundi um){
        String sql= "DELETE FROM ABAFUNDITBL WHERE STUDENTNUMBER =? ";
        
        try {
            PreparedStatement ps =con.prepareStatement(sql);
            ps.setInt(1, um.getStudentNumber());
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
     public void updating(Umfundi um){
         
         String sql="UPDATE ABAFUNDITBL SET NAME=? , SURNAME=? WHERE STUDENTNUMBER=?";
         
         try {
             
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1, um.getStudentNumber());
             ps.setString(2, um.getName());
             ps.setString(3, um.getSurname());
             ps.executeUpdate();
             
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
         
     }

}
