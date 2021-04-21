package com.stuffvish;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

 public class Code_enc_decr extends JFrame implements ActionListener{

     public Code_enc_decr(){

         JFrame f = new JFrame();
         f.setTitle("Code Encryption Decryption");
         f.setSize(400,400);
         f.setLocationRelativeTo(null);
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         Font font = new Font("Arial", Font.BOLD, 20);

         //Creating Button
         JButton button = new JButton();
         button.setText("Select Image");
         button.setFont(font);

         //Creating Text Field
         JLabel label = new JLabel("Enter Password(min. 6 is good)");
         JLabel label_below = new JLabel("*Please upload same image after you encode the image in same way to decript the image.");
         JLabel label_footer = new JLabel("Happy Encription Decription!");
         JTextField textField = new JTextField(20);
         textField.setColumns(15);
         textField.setFont(font);

         button.addActionListener(e ->{
             System.out.println("Button clicked");
             String text = textField.getText();
             int temp = Integer.parseInt(text);
             operate(temp);
         });

         f.setLayout(new FlowLayout());

         f.add(label);
         f.add(textField);
         f.add(button);
         f.add(label_below);
         f.add(label_footer);
         f.setVisible(true);
     }
     public static void operate(int key){
         JFileChooser fileChooser = new JFileChooser();
         fileChooser.showOpenDialog(null);
         File file =fileChooser.getSelectedFile();

         //file FileInputReader
         try {
             FileInputStream fis = new FileInputStream(file);
             byte[] data = new byte[fis.available()];
             fis.read(data);
             int i = 0;
             for (byte b:data){
                 System.out.println(b);
                 data[i] = (byte)(b^key);
                 i++;
             }
             FileOutputStream fos = new FileOutputStream(file);
             fos.write(data);
             fos.close();
             fis.close();
             JOptionPane.showMessageDialog(null, "Done");
         }
         catch(Exception e){
             e.printStackTrace();
         }
     }

     public static void main(String[] args) {
        System.out.println("Alpha testing...");

        new Code_enc_decr();
    }

     @Override
     public void actionPerformed(ActionEvent e) {

/*
         Object o = e.getSource();
         if(o == open)
             openImage();
         else if(o == decode)
             decodeMessage();
         else if(o == reset)
             resetInterface();
*/
     }
 }
