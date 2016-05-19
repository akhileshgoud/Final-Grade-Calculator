/*
	Akhilesh Goud, Aila - 999990675
*/
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

class FinalProject {
	
	private static int count_of_A = 0;
	private static int count_of_B = 0;
	private static int count_of_C = 0;
	private static int count_of_D = 0;
	private static int count_of_F = 0;
	
    public static void main(String [] args) throws Exception{
		Vector<String> grades = new Vector<String>();
		String filename = "";
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame result_gui = new JFrame();
					result_gui.setVisible(true);
					result_gui.setResizable(false);
					result_gui.setTitle("MCIS 5103 - Advance Programming Concepts - Final Project - Akhilesh Goud, Aila - 999990675");
					result_gui.setBounds(100, 50, 800, 650);
					result_gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					result_gui.getContentPane().setLayout(null);
					
					JPanel panel_1 = new JPanel();
					panel_1.setBounds(0, 0, 800, 80);		
					String headng = "<html><center><br>Final Grade Calculator</center></html>";
					JLabel title_label = new JLabel(headng);
					title_label.setFont(new Font("Calibri", Font.BOLD, 21));
					panel_1.add(title_label);
					result_gui.getContentPane().add(panel_1);
					
					JPanel panel_6 = new JPanel();
					panel_6.setBounds(0, 600, 800, 50);
					JLabel footer_label = new JLabel("Copyright 2016, AG");
					panel_6.add(footer_label);
					result_gui.getContentPane().add(panel_6);
					
					JPanel panel_2 = new JPanel();
					panel_2.setBounds(0, 80, 800, 70);
					JLabel desc_label = new JLabel("This program ingests your selected data file and calculates the final grades of students.");
					panel_2.add(desc_label);
					JButton btnsel = new JButton("Select Data File");
					btnsel.setVisible(true);
					panel_2.add(btnsel);
					result_gui.getContentPane().add(panel_2);
					
					btnsel.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							JFileChooser fileChooser = new JFileChooser();
							int status = fileChooser.showOpenDialog(null);
							if (status == JFileChooser.APPROVE_OPTION)
							{
							  File selectedFile = fileChooser.getSelectedFile();
							  String filename = selectedFile.getPath();
							  JOptionPane.showMessageDialog(null, "You selected " + filename);
							  
								File f = null;
								FileReader fr = null;
								BufferedReader br = null;

								try {
									f = new File (filename);
									fr = new FileReader (f);
									br = new BufferedReader(fr);
									String line = br.readLine();
									String output = null;
									while((line=br.readLine())!=null) {
										String[] values = line.split(",");
										String name = values[0];
										int hw1 = Integer.parseInt(values[1]);
										int hw2 = Integer.parseInt(values[2]);
										int hw3 = Integer.parseInt(values[3]);
										int mid = Integer.parseInt(values[4]);
										int prjct = Integer.parseInt(values[5]);
										int fin = Integer.parseInt(values[6]);
										double final_numerical_grade = (0.45 * ((hw1 + hw2 + hw3) / 3)) + (0.25 * prjct) + (0.3 * ((mid + fin) / 2));
										if (final_numerical_grade >= 90) {
											output = name + " :  A        ";
											count_of_A++;
										} else if (final_numerical_grade >= 80){
											output = name + " :  B        ";
											count_of_B++; 
										}else if (final_numerical_grade >= 70){
											output = name + " :  C        "; 
											count_of_C++;
										}else if (final_numerical_grade >= 60){
											output = name + " :  D        "; 
											count_of_D++;
										}else if (final_numerical_grade < 60){
											output = name + " :  F        "; 
											count_of_F++;
										}
										grades.add(output);
									}
								} catch(Exception e) {
									e.printStackTrace();
								} finally {
									try{
										if( null != fr ) {
											fr.close();
										}
									} catch (Exception e2) {
										e2.printStackTrace();
									}
								}
							}
							
							JPanel panel_3 = new JPanel();
							panel_3.setBounds(0, 150, 800, 50);
							JButton btncalc = new JButton("Calculate");
							btncalc.setVisible(true);
							panel_3.add(btncalc);
							result_gui.getContentPane().add(panel_3);
							
							JPanel panel_4 = new JPanel();
							panel_4.setBounds(0, 200, 800, 300);
							JList<String> resultList = new JList<String>(grades);
							resultList.setVisibleRowCount(15);
							JScrollPane scrollpane = new JScrollPane(resultList);
							scrollpane.setSize (new Dimension (250,250));
							panel_4.add(scrollpane);
							result_gui.getContentPane().add(panel_4);
							panel_4.setVisible(false);
							
							JPanel panel_5 = new JPanel();
							panel_5.setBounds(0, 500, 800, 100);
							String count_of_grades = "<html>Total number of A-grades: " + Integer.toString(count_of_A) + "<br>Total number of B-grades: " + Integer.toString(count_of_B) +"<br>Total number of C-grades: " + Integer.toString(count_of_C) +"<br>Total number of D-grades: " + Integer.toString(count_of_D) +"<br>Total number of F-grades: " + Integer.toString(count_of_F) + "</html>";
							JLabel count_label = new JLabel(count_of_grades);
							panel_5.add(count_label);
							result_gui.getContentPane().add(panel_5);
							panel_5.setVisible(false);							
							
							btncalc.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									panel_4.setVisible(true);
									panel_5.setVisible(true);
								}
							});
						}
					});				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}