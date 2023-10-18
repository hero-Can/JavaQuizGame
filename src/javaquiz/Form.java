/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaquiz;

import javax.swing.JFrame;

/**
 *
 * @author pc
 */
public class Form extends JFrame{
    JavaQuiz j = new JavaQuiz();
    public Form(){
        this.setTitle("Java Quiz Game");
        this.setSize(600,620);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocation(450,180);
        this.add(j);
    }
}
