import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CalendarDisplay {
	
    public static void main(String[] args){
    	
    	 ArrayList<String> Data=new ArrayList<String>();
         File f =new File("/Users/waelbenamara/Desktop/Calendar.txt");
         try {
             Scanner sc1 = new Scanner(f);
             sc1.useDelimiter(",");
             while (sc1.hasNextLine()) {
            	 Data.add(sc1.nextLine());
             }
             sc1.close();
         } catch (FileNotFoundException e2) {
             e2.printStackTrace();
         }
    	
        
        // create JFrame and JTable
        JFrame frame = new JFrame();
        JTable table = new JTable(); 
        
        // create a table model and set a Column Identifiers to this model 
        Object[] columns = {"Day/Time","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        
        // set the model to the table
        table.setModel(model);
        
        // Change A JTable Background Color, Font Size, Font Color, Row Height
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("",1,22);
        table.setFont(font);
        table.setRowHeight(30);
        
        // create JTextFields
        JTextField textTime = new JTextField();
        JTextField textMonday = new JTextField();
        JTextField textTuesday = new JTextField();
        JTextField textWednesday= new JTextField();
        JTextField textThursday = new JTextField();
        JTextField textFriday = new JTextField();
        JTextField textSaturday = new JTextField();
        JTextField textSunday = new JTextField();
        
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
        
        // set the text areas
        textTime.setBounds(120, 220, 150, 25);
        textMonday.setBounds(120, 250, 150, 25);
        textTuesday.setBounds(120, 280, 150, 25);
        textWednesday.setBounds(120, 310, 150, 25);
        textThursday.setBounds(120, 340, 150, 25);
        textFriday.setBounds(120, 370, 150, 25);
        textSaturday.setBounds(120, 400, 150, 25);
        textSunday.setBounds(120, 430, 150, 25);
        
        // set the buttons' bounds
        btnAdd.setBounds(295, 220, 100, 25);
        btnUpdate.setBounds(295, 265, 100, 25);
        btnDelete.setBounds(295, 310, 100, 25);
        
        // create JScrollPane
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 880, 200);
        
        frame.getContentPane().setLayout(null);
        
        frame.getContentPane().add(pane);
        
        // add JTextFields to the jframe
        frame.getContentPane().add(textTime);
        frame.getContentPane().add(textMonday);
        frame.getContentPane().add(textTuesday);
        frame.getContentPane().add(textWednesday);
        frame.getContentPane().add(textThursday);
        frame.getContentPane().add(textFriday);
        frame.getContentPane().add(textSaturday);
        frame.getContentPane().add(textSunday);
    
        // add JButtons to the jframe
        frame.getContentPane().add(btnAdd);
        frame.getContentPane().add(btnDelete);
        frame.getContentPane().add(btnUpdate);
        
        // create labels and add them to the frame
        JLabel lblMonday = new JLabel("Monday");
        lblMonday.setBounds(30, 250, 50, 25);
        frame.getContentPane().add(lblMonday);
        
        JLabel lblTuesday = new JLabel("Tuesday");
        lblTuesday.setBounds(30, 285, 60, 14);
        frame.getContentPane().add(lblTuesday);
        
        JLabel lblNewLabel = new JLabel("Wednesday");
        lblNewLabel.setBounds(30, 315, 70, 14);
        frame.getContentPane().add(lblNewLabel);
        
        JLabel lblThursday = new JLabel("Thursday");
        lblThursday.setBounds(30, 345, 70, 14);
        frame.getContentPane().add(lblThursday);
        
        JLabel lblNewLabel_1 = new JLabel("Friday");
        lblNewLabel_1.setBounds(30, 375, 46, 14);
        frame.getContentPane().add(lblNewLabel_1);
        JLabel lblSaturday = new JLabel("Saturday");
        lblSaturday.setBounds(30, 405, 46, 14);
        frame.getContentPane().add(lblSaturday);
        
        JLabel lblNewLabel_2 = new JLabel("Sunday");
        lblNewLabel_2.setBounds(30, 435, 46, 14);
        frame.getContentPane().add(lblNewLabel_2);
        
        JLabel lblTime = new JLabel("Time");
        lblTime.setForeground(Color.BLUE);
        lblTime.setBounds(30, 225, 46, 14);
        frame.getContentPane().add(lblTime);
        
        JButton btnBack = new JButton("BACK");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Dashboard n =new Dashboard();
        		n.main(null);
        	}
        });
        btnBack.setForeground(new Color(0, 0, 128));
        btnBack.setFont(new Font("Dialog", Font.PLAIN, 20));
        btnBack.setBounds(414, 557, 100, 25);
        frame.getContentPane().add(btnBack);
        
        /* // create an array of objects to set the row data	my work
        Object[] row = new Object[8];*/
        
        
        // create an array of objects to set the row data
        Object[] rowss = new Object[8];
        String tmp = "";
        for(int i = 0;i<Data.size();i++) {
            tmp= tmp+Data.get(i)+",";
        }
        String[] ss=tmp.split(",");
    
   
        for(int i=0;i<ss.length/8;i++) {
            rowss[0]=ss[i*8+0];
            rowss[1]=ss[i*8+1];
            rowss[2]=ss[i*8+2];
            rowss[3]=ss[i*8+3];
            rowss[4]=ss[i*8+4];
            rowss[5]=ss[i*8+5];
            rowss[6]=ss[i*8+6];
            rowss[7]=ss[i*8+7];

            model.addRow(rowss);
        }
        
        
        // button add row
        btnAdd.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            	rowss[0] = textTime.getText();
                rowss[1] = textMonday.getText();
                rowss[2] = textTuesday.getText();
                rowss[3] = textWednesday.getText();
                rowss[4] = textThursday.getText();
                rowss[5] = textFriday.getText();
                rowss[6] = textSaturday.getText();
                rowss[7] = textSunday.getText();
                
                // add row to the model
                model.addRow(rowss); 
                
                FileWriter fw = null;
                try {
                    fw = new FileWriter("/Users/waelbenamara/Desktop/Calendar.txt",true);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                 BufferedWriter WriteFileBuffer = new BufferedWriter(fw);
 
                 //Write Text to File Using Buffered Writer
                 try {
                    WriteFileBuffer.newLine();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                 try {
                    WriteFileBuffer.write(textTime.getText()+","+textMonday.getText()+","+textTuesday.getText()+","+
                    textWednesday.getText()+","+textThursday.getText()+","+textFriday.getText()+","+textSaturday.getText()+","+textSunday.getText());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                 try {
                    WriteFileBuffer.flush();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                 
                 //Close both the Writers
                 try {
                    WriteFileBuffer.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                
            }
        });
        
        // button remove row
        btnDelete.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            
                // i = the index of the selected row
                int i = table.getSelectedRow();
                if(i >= 0){
                    // remove a row from jtable
                	 String todel= model.getValueAt(i,0).toString()+","+model.getValueAt(i, 1).toString()+","+model.getValueAt(i,2).toString()+","+model.getValueAt(i,3).toString()+","+model.getValueAt(i,4).toString()+","+model.getValueAt(i,5).toString()+","+model.getValueAt(i,6).toString()+","+model.getValueAt(i,7).toString();
                 	System.out.println(Data.indexOf(todel));
                 	System.out.println(Data);
                 	System.out.println("old array list "+Data);
                 	Data.remove(Data.indexOf(todel));
                 	System.out.println("new array list "+Data);
                 	try {
 						FileWriter fw = new FileWriter("/Users/waelbenamara/Desktop/Calendar.txt");
 						BufferedWriter WriteFileBuffer = new BufferedWriter(fw);
 						for(String str : Data){
 							 WriteFileBuffer.write(str);
 							 
 							
 						}
 						 WriteFileBuffer.close();
 					} catch (IOException e1) {
 						// TODO Auto-generated catch block
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
            textTime.setText(model.getValueAt(i, 0).toString());
            textMonday.setText(model.getValueAt(i, 1).toString());
            textTuesday.setText(model.getValueAt(i, 2).toString());
            textWednesday.setText(model.getValueAt(i, 3).toString());
            textThursday.setText(model.getValueAt(i, 4).toString());
            textFriday.setText(model.getValueAt(i, 5).toString());
            textSaturday.setText(model.getValueAt(i, 6).toString());
            textSunday.setText(model.getValueAt(i, 7).toString());
        }
        });
        
        // button update row
        btnUpdate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
             JOptionPane.showMessageDialog(null,"This feature is not available yet", "Update",1);
                // i = the index of the selected row
                int i = table.getSelectedRow();
                
                if(i >= 0) 
                {  
                   model.setValueAt(textTime.getText(), i, 0);
                   model.setValueAt(textMonday.getText(), i, 1);
                   model.setValueAt(textTuesday.getText(), i, 2);
                   model.setValueAt(textWednesday.getText(), i, 3);
                   model.setValueAt(textThursday.getText(), i, 4);
                   model.setValueAt(textFriday.getText(), i, 5);
                   model.setValueAt(textSaturday.getText(), i, 6);
                   model.setValueAt(textSunday.getText(), i, 7);
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