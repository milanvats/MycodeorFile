package com.company;

import java.awt.*;
import java.awt.event.*;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
class cal2 extends  Frame implements ActionListener{
   Button [] butt = new Button[16];
    TextField text ;
    double num1;
    String operator;

     public cal2(){
         setSize(1000,1000);
         setLayout(null);
         setVisible(true);
         text = new TextField();
         text.setBounds(30,50,300,40);
         text.setBackground(Color.DARK_GRAY);
         text.setForeground(Color.white);
         add(text);
         String [] buttonlabels = {"7","8","9","/","4","5","6","*","1","2","3","-","c","0","=","+"};
         int x= 30,y=120;
        for (int i=0;i<16;i++){
            butt[i] = new Button(buttonlabels[i]);
            butt[i].setBounds(x,y,80,80);
            butt[i].addActionListener(this);
            butt[i].setBackground(Color.BLACK);
            butt[i].setForeground(Color.white);
            if(butt[i]==butt[12]) {
                butt[i].setBackground(Color.RED);
            }
            add(butt[i]);


            x+=90;
            if ((i+1)%4==0){
                x=30;
                y+=90;
            }
         }

     }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.matches("[0-9]")){
            text.setText(command);
        } else if (command.equals("c")) {
            text.setText(" ");
            num1 =0;
            operator=" ";
        } else if (command.equals("=")) {
            double num2 = Double.parseDouble((text.getText()));
            double result = switch (operator){
                case"+" -> num1+num2;
                case"-" -> num1-num2;
                case"*" -> num1*num2;
                case"/" -> num1/num2;

                default -> 0;
            };
            text.setText(String.valueOf(result));
            operator=" ";

        }else {
            num1 = Double.parseDouble(text.getText());
            operator = command;
            text.setText(" ");
        }


    }
}



public class cal {

    public static void main(String[] args) {
        new cal2();
    }
}
