package food;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class StudentTable  extends JFrame implements ActionListener{
	//2
	private JTable t;
	private JScrollPane s;
	private DefaultTableModel m;
	private Cursor cursor; 
	//1
	private Container c;
	private JLabel tl,fnLabel,lnLabel,PhoneLabel,cgpaLabel;
	private JTextField fnTf,lnTf,phoneTf,cgpaTf;
	private JButton addButton,updateButton,deleteButton,clearButton;
	
	private String[] column = {"First Name","Last Name","Phone Number","CGPA"};
	private String[] row = new String[4];
	StudentTable(){
		initComponents();
	}
	
	 public void initComponents() {
		 
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setSize(780, 690);
		 this.setLocationRelativeTo(null);
		 this.setTitle("Student Registration Form");
		 
		 c= this.getContentPane();
		 this.setLayout(null);
		 this.setBackground(Color.PINK);
		 
		 
		 Font f = new Font("Arial",Font.BOLD,16); 
		 cursor = new Cursor(Cursor.HAND_CURSOR);
		 
		 
		 tl = new JLabel("Student Registration");
		 tl .setFont(f);
		 tl.setBounds(140,10, 250, 50);
		 c.add(tl);
		
		 
		 
		 
		 
		 fnLabel  = new JLabel("First Name");
		 fnLabel.setBounds(10, 80, 140, 30);
		 fnLabel.setFont(f);
		 c.add(fnLabel);
		 
		 fnTf = new JTextField("");
		 fnTf.setBounds(110,80, 200, 30);
		 fnTf.setFont(f);
		 c.add(fnTf);
	 
		 addButton = new JButton("Add");
		 addButton.setBounds(400, 80,100, 30);
		 addButton.setFont(f);
		 addButton.setCursor(cursor);
		 c.add(addButton); 
		 
		 
		 
		 
		 lnLabel = new JLabel("Last Name  ");
		 lnLabel.setBounds(10,130,150, 30);
		 lnLabel.setFont(f);
		 c.add(lnLabel);
		 
		 lnTf = new JTextField();
		 lnTf.setBounds(110,130, 200, 30);
		 lnTf.setFont(f);
		 c.add(lnTf);
	 
		 updateButton = new JButton("Update");
		 updateButton.setBounds(400, 130, 100,30);
		 updateButton.setFont(f);
		 updateButton.setCursor(cursor);
		 c.add(updateButton);
		 
		 
		 
		 
		 PhoneLabel = new JLabel("Phone    ");
		 PhoneLabel.setBounds(10, 180, 200, 30);
		 PhoneLabel.setFont(f);
		 c.add(PhoneLabel);
		  
		 phoneTf = new JTextField();
		 phoneTf.setBounds(110,180,200,30);
		 phoneTf.setFont(f);
		 c.add(phoneTf);
	 
		 deleteButton = new JButton("Delete");
		 deleteButton.setBounds(400, 180, 100, 30);
		 deleteButton.setFont(f);
		 deleteButton.setCursor(cursor);
		 c.add(deleteButton);
		 
	
		 
		 cgpaLabel = new JLabel("CGPA    ");
		 cgpaLabel.setBounds(10, 230, 200,30);
		 cgpaLabel.setFont(f);
		 c.add(cgpaLabel );
		
		 cgpaTf = new JTextField();
		 cgpaTf.setBounds(110, 230, 200,30);
		 cgpaTf.setFont(f);
		 c.add(cgpaTf);
	 
		 clearButton= new JButton("Clear");
		 clearButton.setBounds(400,230,100,30);
		 clearButton.setFont(f);
		 clearButton.setCursor(cursor);
		 c.add(clearButton);
		 
		 //2
		 t = new JTable();
		 
		 
		 m = new DefaultTableModel();
		 m.setColumnIdentifiers(column);
		 t.setModel(m);
		 t.setFont(f);
		 t.setSelectionBackground(Color.GREEN);   //column selection 
		 t.setBackground(Color.PINK);
		 t.setRowHeight(30);
		 
		 s = new JScrollPane(t);
		 s.setBounds(10,360,740,265);             //Scrolling
		 c.add(s);
		 
		 addButton.addActionListener(this);
		 clearButton.addActionListener(this);
		 deleteButton.addActionListener(this);
		 
		 t.addMouseListener(new MouseAdapter()                               //row selection
		 {
			 public void mouseClicked(MouseEvent me) {
				int numberofROW =  t.getSelectedRow();
				
				
				String f_name 		=  m . getValueAt(numberofROW,0 ).toString();
				String l_name 		=  m . getValueAt(numberofROW,1 ).toString();
				String phone_name   =  m . getValueAt(numberofROW,2 ).toString();
				String cgpa_name    =  m . getValueAt(numberofROW,3 ).toString();
			 
				fnTf.setText(f_name);
				lnTf.setText(l_name);
				phoneTf.setText(phone_name);
				cgpaTf.setText(cgpa_name);
			 
			 }
		 }
		 
		 );
		 
	 }
	 @Override
		public void actionPerformed(ActionEvent e) {
		
		 if(e.getSource()== addButton) 
		 {
			 	
			 row[0]= fnTf.getText();
			 row[1]=lnTf.getText();
			 row[2]=phoneTf.getText();
			 row[3]=cgpaTf.getText();
			 
			 m.addRow(row);
		 }
		
		 else if(e.getSource()==clearButton) {
			 fnTf.setText("");
			 lnTf.setText("");
			 phoneTf.setText("");
			 cgpaTf.setText("");
			 
		 }
		 
		 else if (e.getSource()==deleteButton) {
			 int numberofROW = t.getSelectedRow();
			 
			 if(numberofROW >= 0 ) {
				 m.removeRow(numberofROW);
			 }
			 else {
				 JOptionPane.showMessageDialog(null, "No Row has been Selected or no Row exists");
			 }
			 
			 
		 }
		}

		
	
	public static void main(String args[]) {
	
		StudentTable x = new StudentTable();
		x.setVisible(true);
	}
	
	
}
