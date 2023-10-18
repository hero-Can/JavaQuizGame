/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaquiz;

import database.QuizDB;
import domain.Quiz;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author pc
 */
public class JavaQuiz extends JPanel implements ActionListener{

    JLabel count,jscore;
    JButton option1,option2,option3,option4,next;
    JTextArea question;
    
    Font  f1  = new Font(Font.MONOSPACED,Font.BOLD, 27);
    Font  f2  = new Font(Font.MONOSPACED,Font.ITALIC, 20);
    Font  f3  = new Font(Font.MONOSPACED,Font.BOLD|Font.ITALIC, 20);
    
    Color green = new Color(0xbfea9a);
    Color red = new Color(0xf26262);
    
    ArrayList<Quiz> data;
    
    int i=0;
    int score=0;
    
    public JavaQuiz(){
        this.setBackground(new Color(0xe4eef4));
        this.setLayout(null);
        ux();
    }
    
    public void ux(){
        
        //initialize data
        data=QuizDB.getData();
        
        // initialize label
        question = new JTextArea(5, 20);
        question.setBounds(20, 70, 550, 100);
        question.setFont(f1);
        this.add(question);
        
        // initialize label count
        count = new JLabel("Question "+(i+1)+"/5");
        count.setBounds(350, 10, 200, 50);
        count.setFont(f2);
        this.add(count);
        
        // initialize JButton
        option1 = new JButton("Option1");
        option1.setBounds(20,200, 530, 60);
        option1.setFont(f3);
        option1.addActionListener(this);
   
        option2 = new JButton("Option2");
        option2.setBounds(20,280, 530, 60);
        option2.setFont(f3);
        option2.addActionListener(this);
        
        option3 = new JButton("Option3");
        option3.setBounds(20,360, 530, 60);
        option3.setFont(f3);
        option3.addActionListener(this);
        
        option4 = new JButton("Option4");
        option4.setBounds(20,440, 530, 60);
        option4.setFont(f3);
        option4.addActionListener(this);
        
        this.add(option1);this.add(option2);this.add(option3);this.add(option4);
        
        next = new JButton("Next");
        next.setBounds(400,510, 150, 50);
        next.setFont(f3);
        next.setBackground(new Color(0x1f8bcb));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        this.add(next);
        
        //set data
        question.append(data.get(i).getQuestion());
        question.setWrapStyleWord(true);
        question.setLineWrap(true);
        question.setEditable(false);
        
        option1.setText(data.get(i).getOption1());
        option2.setText(data.get(i).getOption2());
        option3.setText(data.get(i).getOption3());
        option4.setText(data.get(i).getOption4());
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource()==next) {
            if (i==data.size()-1) {
                JOptionPane.showMessageDialog(this,"Your score :"+score,"Java Quiz",JOptionPane.INFORMATION_MESSAGE);
            }else{
                i++;
            question.setText(data.get(i).getQuestion());
            option1.setText(data.get(i).getOption1());
            option2.setText(data.get(i).getOption2());
            option3.setText(data.get(i).getOption3());
            option4.setText(data.get(i).getOption4());
            count.setText("Question "+(i+1)+"/5");
            option1.setBackground(new JButton().getBackground());
            option2.setBackground(new JButton().getBackground());
            option3.setBackground(new JButton().getBackground());
            option4.setBackground(new JButton().getBackground());
            option4.setBackground(new JButton().getBackground());
            }
            
        }
        if (e.getSource()==option1) {
            if (option1.getText().equals(data.get(i).getAnswer())) {
                  option1.setBackground(green);
                  score++;
            }else{
                option1.setBackground(red);
               
            }
        }
        if (e.getSource()==option2) {
            if (option2.getText().equals(data.get(i).getAnswer())) {
                  option2.setBackground(green);
                  score++;
            }else{
                option2.setBackground(red);
                
            }
        }
        if (e.getSource()==option3) {
            if (option3.getText().equals(data.get(i).getAnswer())) {
                  option3.setBackground(green);
                  score++;
            }else{
                option3.setBackground(red);
                
            }
        }
        if (e.getSource()==option4) {
            if (option4.getText().equals(data.get(i).getAnswer())) {
                  option4.setBackground(green);
                  score++;
            }else{
                option4.setBackground(red);
                
            }
        }
            
    }
}
