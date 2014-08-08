package org.jLOAF.util;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jLOAF.util.logger.CaseLoggerParser;

public class CaseLoggerConsole {
	public static void main(String args[]){
		try {
			CaseLoggerConsole console = new CaseLoggerConsole("LOG_Random_1.txt");
			JFrame frame = new JFrame("");
			frame.setSize(500, 500);
			final JTable table = new JTable(console.getTableMode());
	        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
	        table.setFillsViewportHeight(true);
	        table.setEnabled(false);
			frame.add(new JScrollPane(table));
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			System.out.println("DONE");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Failed to find File");
		}
	}
	
	private BufferedReader br;
	
	private DefaultTableModel model;
	
	private CaseLoggerConsole(String filename) throws IOException{
		br = new BufferedReader(new FileReader(filename));
		readFile();
	}
	
	public DefaultTableModel getTableMode(){
		return model;
	}
	
	private void readFile() throws IOException{
		String line = br.readLine();
		ArrayList<String> lines = new ArrayList<String>();
		while(line != null){
			lines.add(line);
			line = br.readLine();
		}
		
		CaseLoggerParser parser = new CaseLoggerParser();
		model = parser.parseLogger(lines);
	}
}