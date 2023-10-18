/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import domain.Quiz;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuizDB {
    
    public static Connection connect() throws SQLException{
        return DriverManager.getConnection("jdbc:sqlite:javaQuiz.db");
    }
    
    public static ArrayList<Quiz> getData(){
        ArrayList<Quiz> list = new ArrayList();
        try (
                Connection c = connect();
                PreparedStatement ps = c.prepareStatement("select * from quiz");
            ){
                ResultSet r = ps.executeQuery();
                while (r.next()) {                
                Quiz q = new Quiz(r.getInt("id"), r.getString("question"),r.getString("option1"),r.getString("option2"),r.getString("option3"),
                       r.getString("option4") ,r.getString("answer") , r.getString("symbol"));
                list.add(q);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
