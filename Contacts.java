package javaapp;

import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
//Sample 01: Package inclusion
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
//Sample 01: Package inclusion
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;



public class Contacts {
   public static void main(String[] args){
        
       // create JFrame and JTable
        JFrame frame = new JFrame();
        JTable table = new JTable(); 
        
        // create a table model and set a Column Identifiers to this model 
       //____________________________column names__________________________________________________
        Object[] columns = {"Professor","Subject","E-mail address","Office Hour"};
        
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        
        // set the model to the table
        table.setModel(model);
        
        // Change Our JTable Background Color, Font Size, Font Color, Row Height
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("",1,22);
        table.setFont(font);
        table.setRowHeight(30);
        
        // create JTextFields
        JTextField Professor = new JTextField();
        JTextField Subject = new JTextField();
        JTextField Email = new JTextField();
        JTextField OfficeHour = new JTextField();
        
        // create JButtons
        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");
        JButton btnUpdate = new JButton("Update");     
        
        Professor.setBounds(234, 211, 200, 25);
        Subject.setBounds(458, 211, 200, 25);
        Email.setBounds(10, 211, 200, 25);
        OfficeHour.setBounds(680, 211, 200, 25);
        
        btnAdd.setBounds(334, 265, 100, 25);
        btnUpdate.setBounds(395, 301, 100, 25);
        btnDelete.setBounds(458, 265, 100, 25);
        
        // create JScrollPane
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 880, 200);
        
        frame.getContentPane().setLayout(null);
        
        frame.getContentPane().add(pane);
        
        // add JTextFields to the jframe
        frame.getContentPane().add(Professor);
        frame.getContentPane().add(Subject);
        frame.getContentPane().add(Email);
        frame.getContentPane().add(OfficeHour);
    
        // add JButtons to the jframe
        frame.getContentPane().add(btnAdd);
        frame.getContentPane().add(btnDelete);
        frame.getContentPane().add(btnUpdate);
        
        // create an array of objects to set the row data
        Object[] row = new Object[4];
        //________________________________Button ADD___________________________________________________
        // button add row
        btnAdd.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
             
                row[0] = Professor.getText();
                row[3] = Subject.getText();
                row[2] = Email.getText();
                row[1] = OfficeHour.getText();
                
                FileWriter fw = null;
				try {
					fw = new FileWriter("C:\\Users\\HP\\Desktop\\TestFile.Txt");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	             BufferedWriter WriteFileBuffer = new BufferedWriter(fw);

	             //Sample 02: Write Some Text to File
	             // Using Buffered Writer)
	             try {
					WriteFileBuffer.newLine();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	             try {
					WriteFileBuffer.write(Professor.getText()+","+Subject.getText()+","+
					 Email.getText()+","+OfficeHour.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	             try {
					WriteFileBuffer.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	             
	             
	             //Sample 03: Close both the Writers
	             try {
					WriteFileBuffer.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
                // add row to the model
                model.addRow(row);
            }
        });
        //_____________________DELETE BUTTON_______________________________
        // button remove row
        btnDelete.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            
                // i = the index of the selected row
                int i = table.getSelectedRow();
                if(i >= 0){
                    // remove a row from jtable
                	
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
            
            Professor.setText(model.getValueAt(i, 0).toString());
            Subject.setText(model.getValueAt(i, 3).toString());
            Email.setText(model.getValueAt(i, 2).toString());
            OfficeHour.setText(model.getValueAt(i, 1).toString());
            
        }
        });
        
        // button update row
        btnUpdate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
             
                // i = the index of the selected row
                int i = table.getSelectedRow();
                
                if(i >= 0) 
                {
                   model.setValueAt(Professor.getText(), i, 0);
                   model.setValueAt(Subject.getText(), i, 3);
                   model.setValueAt(Email.getText(), i, 2);
                   model.setValueAt(OfficeHour.getText(), i, 1);
                }
                else{
                    System.out.println("Update Error");
                }
            }
        });
        
        frame.setSize(900,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        

   



//The file !!
	
		



	   
	   
	   	/*  Scanner sc = new Scanner(System.in);
	   	  String str = sc.nextLine();
	   	  String str1=sc.nextLine();
	   	  String str2=sc.nextLine();
	   	  String str3=sc.nextLine();*/
	         try
	         {
	             //Sample 01: Open the FileWriter, Buffered Writer
	             

	             //Sample 04: Open the Readers Now
	             FileReader fr = new
	                     FileReader("C:\\Users\\HP\\Desktop\\TestFile.txt");
	             BufferedReader ReadFileBuffer = new
	                     BufferedReader(fr);

	             //Sample 05: Read the text Written 
	             // using BufferedWriter
	             System.out.println(ReadFileBuffer.readLine());
	             System.out.println(ReadFileBuffer.readLine());
	             System.out.println(ReadFileBuffer.readLine());
	             System.out.println(ReadFileBuffer.readLine());

	             //Sample 06: Close the Readers
	             ReadFileBuffer.close();

	         } catch (IOException Ex)
	         {
	             System.out.println(Ex.getMessage());
	         }

   }
   
   
   //reading the data (separated by comma ) from the file to the array
  
}

