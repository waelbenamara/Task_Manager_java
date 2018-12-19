import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import java.awt.TextField;
import javax.swing.JTextPane;

public class Schedulee {

    public static void main(String[] args){
    	
    	ArrayList<String> Data=new ArrayList<>();
        File f =new File("/Users/waelbenamara/Desktop/Schedule.txt");
        try {
            Scanner sc1 = new Scanner(f);
            sc1.useDelimiter(",");
           while (sc1.hasNextLine())    {
               Data.add(sc1.nextLine());
               System.out.println(Data);
           }
           for(int i=0 ; i<Data.size();i++) {
               System.out.println(Data.get(i));
           }
           System.out.println("size "+Data.size());
            sc1.close();
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        }
        
        // create JFrame and JTable
        JFrame frame = new JFrame();
        JTable table = new JTable();
        JTable table1=new JTable();

        
        // create a table model and set a Column Identifiers to this model 
        Object[] columns = {"Monday","Tuesday","Wednesday","Thursday","Friday"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        Object[] column = {"Time/Day"};
        DefaultTableModel model1 = new DefaultTableModel();
        model1.setColumnIdentifiers(column);
        
        Object[] hour1 = new Object[] { "08h30 - 10h00"};
        model1.addRow(hour1) ;
        Object[] hour2 = new Object[] { "10h10 - 11h40"};
        model1.addRow(hour2) ;
        Object[] hour3 = new Object[] { "12h00 - 13h30"};
        model1.addRow(hour3) ;
        Object[] hour4 = new Object[] { "13h40 - 15h10"};
        model1.addRow(hour4) ;
        Object[] hour5 = new Object[] { "15h20 - 16h50"};
        model1.addRow(hour5) ;
        Object[] hour6 = new Object[] { "17h00 - 18h30"};
        model1.addRow(hour6) ;
        
        
        
        
        
     
        // set the model to the table
        table.setModel(model);
        table1.setModel(model1);
  
        
        // Change A JTable Background Color, Font Size, Font Color, Row Height
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("",1,22);
        table.setFont(font);
        table.setRowHeight(30);
        
        // create JTextFields
        JTextField textMonday = new JTextField();
        JTextField textTuesday = new JTextField();
        JTextField textWednesday= new JTextField();
        JTextField textThursday = new JTextField();
        JTextField textFriday = new JTextField();
        
        // create JButtons
        JButton btnAdd = new JButton("Add");
        btnAdd.setForeground(new Color(0, 0, 128));
        btnAdd.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 20));
        JButton btnDelete = new JButton("Delete");
        btnDelete.setForeground(new Color(0, 0, 128));
        btnDelete.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 20));
        JButton btnUpdate = new JButton("Update");     
        btnUpdate.setForeground(new Color(0, 0, 128));
        btnUpdate.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 20));
        
        
        textMonday.setBounds(20, 250, 100, 25);
        textTuesday.setBounds(20, 280, 100, 25);
        textWednesday.setBounds(20, 310, 100, 25);
        textThursday.setBounds(20, 340, 100, 25);
        textFriday.setBounds(20, 370, 100, 25);
        
        btnAdd.setBounds(150, 220, 100, 25);
        btnUpdate.setBounds(150, 265, 100, 25);
        btnDelete.setBounds(150, 310, 100, 25);
        
        // create JScrollPane 
        JScrollPane pane1 = new JScrollPane(table1);
        pane1.setBounds(0, 0, 120, 200);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(119, 0, 756, 200);
        
        frame.getContentPane().setLayout(null);
        
        frame.getContentPane().add(pane);
        frame.getContentPane().add(pane1);
        
        // add JTextFields to the Jframe
        frame.getContentPane().add(textMonday);
        frame.getContentPane().add(textTuesday);
        frame.getContentPane().add(textWednesday);
        frame.getContentPane().add(textThursday);
        frame.getContentPane().add(textFriday);
    
        // add JButtons to the Jframe
        frame.getContentPane().add(btnAdd);
        frame.getContentPane().add(btnDelete);
        frame.getContentPane().add(btnUpdate);
        
     // create an array of objects to set the row data
        Object[] row = new Object[5];
        String tmp = "";
        for(int i = 0;i<Data.size();i++) {
           
            tmp= tmp+Data.get(i)+",";
       
        }
        String[] ss=tmp.split(",");
        System.out.println("size ss"+ss.length);
        for(int i=0;i<ss.length;i++) {
        System.out.println("element of ss"+ss[i]);
                   
        }
   
        for(int i=0;i<ss.length/5;i++) {
            row[0]=ss[i*5+0];
            row[1]=ss[i*5+1];
            row[2]=ss[i*5+2];
            row[3]=ss[i*5+3];
            row[4]=ss[i*5+4];
            model.addRow(row);
                   
        }
        
        // create an array of objects to set the row data
        Object[] row1 = new Object[5];
        
        // button add row
        btnAdd.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                row1[0] = textMonday.getText();
                row1[1] = textTuesday.getText();
                row1[2] = textWednesday.getText();
                row1[3] = textThursday.getText();
                row1[4] = textFriday.getText();
                
                FileWriter fw = null;
                try {
                    fw = new FileWriter("/Users/waelbenamara/Desktop/Schedule.txt",true);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                 BufferedWriter WriteFileBuffer = new BufferedWriter(fw);

                 //Sample 02: Write Some Text to File
                 // Using Buffered Writer)
                 try {
                    WriteFileBuffer.newLine();
                } catch (IOException e1) {
                    
                    e1.printStackTrace();
                }
                 try {
                    WriteFileBuffer.write(textMonday.getText()+","+textTuesday.getText()+","+
                     textWednesday.getText()+","+textThursday.getText()+","+textFriday.getText());
                } catch (IOException e1) {
                    
                    e1.printStackTrace();
                }
                 try {
                    WriteFileBuffer.flush();
                } catch (IOException e1) {
                    
                    e1.printStackTrace();
                }
                 
                 
                 //Sample 03: Close both the Writers
                 try {
                    WriteFileBuffer.close();
                } catch (IOException e1) {
                  
                    e1.printStackTrace();
                }
                
                // add row to the model
                model.addRow(row);
            }
        });
        
        // button delete row
        btnDelete.addActionListener(new ActionListener(){
        	 
            @Override
            public void actionPerformed(ActionEvent e) {
           
                // i = the index of the selected row
                int i = table.getSelectedRow();
                if(i >= 0){
                   String todel= model.getValueAt(i,0).toString()+","+model.getValueAt(i, 1).toString()+","+model.getValueAt(i,2).toString()+","+model.getValueAt(i,3).toString()+","+model.getValueAt(i,4).toString();
                    System.out.println(Data.indexOf(todel));
                    System.out.println(Data);
                    System.out.println("old array list "+Data);
                    Data.remove(Data.indexOf(todel));
                    System.out.println("new array list "+Data);
                    try {
                        FileWriter fw = new FileWriter("/Users/waelbenamara/Desktop/Schedule.txt");
                        BufferedWriter WriteFileBuffer = new BufferedWriter(fw);
                        for(String str : Data){
                             WriteFileBuffer.write(str);
                           
                        }
                         WriteFileBuffer.close();
                    } catch (IOException e1) {
            
                        e1.printStackTrace();
                    }
                   
                    model.removeRow(i);
                   
                }
                else{
                    System.out.println("Delete Error");
                }
            }
        });
        // get selected row data From table to textfields
        table.addMouseListener(new MouseAdapter(){
       
        @Override
        public void mouseClicked(MouseEvent e){
           
            // i = the index of the selected row
            int i = table.getSelectedRow();
           
            textMonday.setText(model.getValueAt(i, 0).toString());
            textTuesday.setText(model.getValueAt(i, 4).toString());
            textWednesday.setText(model.getValueAt(i, 3).toString());
            textThursday.setText(model.getValueAt(i, 2).toString());
            textFriday.setText(model.getValueAt(i, 1).toString());
           
        }
        });
        
        // button update row
        btnUpdate.addActionListener(new ActionListener() {
        	 
            @Override
            public void actionPerformed(ActionEvent e) {
             JOptionPane.showMessageDialog(null,"This feature is not available yet you can delete and then add", "Update", 1);
                // i = the index of the selected row
                int i = table.getSelectedRow();
               
                if(i >= 0)
                {
                   model.setValueAt(textMonday.getText(), i, 0);
                   model.setValueAt(textTuesday.getText(), i, 4);
                   model.setValueAt(textWednesday.getText(), i, 3);
                   model.setValueAt(textThursday.getText(), i, 2);
                   model.setValueAt(textFriday.getText(), i, 1);
                }
                else{
                    System.out.println("Update Error");
                }
            }
        });
        
        frame.setSize(900,634);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
}