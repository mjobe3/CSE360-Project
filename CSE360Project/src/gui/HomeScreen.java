package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class HomeScreen {

	protected Shell shell;
	public int min = 0;
	public int max = 100;
	File file;
	ArrayList<Integer> data = new ArrayList<>();


	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			HomeScreen window = new HomeScreen();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	public void displayData()
	{
		
		System.out.println(data);
		
	}
	
	public void initializeData()
	{
		if(file.getName().endsWith(".txt"))
		{
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
				String line = reader.readLine();
				while(line != null) {
					
					data.add(Integer.parseInt(line));
					line = reader.readLine();
			
				}
				reader.close();
			} catch (IOException e) {
				System.out.print("Invalid file");
			}
		}
		
		else if(file.getName().endsWith(".csv"))
		{
			BufferedReader reader;
			String[] dataStr = null;
			
			try {
				reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
				String line = reader.readLine();
				dataStr = line.replaceAll("\\s+","").split(",");	
				line = reader.readLine();
				reader.close();
				for(int i = 0; i < dataStr.length; i++)
				{
					data.add(Integer.parseInt(dataStr[i]));
				}
				
			} catch (IOException e) {
				System.out.print("Invalid file");
			}
		}
		
		else {
			System.out.print("Invalid file");
		}
	
		Collections.sort(data);
	}
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(1200, 600);
		shell.setText("Grades     Min: " + min + "     Max: " + max);
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Button btnSetBoundaries = new Button(shell, SWT.NONE);
		btnSetBoundaries.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				BoundariesScreen setBoundaries = new BoundariesScreen();
				setBoundaries.main(null);
				min = setBoundaries.min;
				max = setBoundaries.max;
				shell.setText("Grades     Min: " + min + "     Max: " + max);
			}
		});
		btnSetBoundaries.setText("Set boundaries");
		
		Button btnLoadFile = new Button(shell, SWT.NONE);
		btnLoadFile.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final JFileChooser fc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.txt", "txt", "*.csv", "csv");
				fc.setFileFilter(filter);
				FileChooser fcWindow = new FileChooser();
				int returnVal = fc.showOpenDialog(fcWindow);
				fcWindow.setVisible(true);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					file = fc.getSelectedFile();
					shell.setText("Grades     Min: " + min + "     Max: " + max + "     " + file.getName());
				}
				
				fcWindow.setVisible(false);
				initializeData();
			}
		});
		btnLoadFile.setText("Load file");
		
		Button btnModifyData = new Button(shell, SWT.NONE);
		btnModifyData.setText("Modify data");
		
		Button btnDataAnalysis = new Button(shell, SWT.NONE);
		btnDataAnalysis.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DataAnalysisScreen dataAnalysis = new DataAnalysisScreen(data);
				dataAnalysis.main(null);
			}
		});
		btnDataAnalysis.setText("Data analysis");
		
		Button btnErrorLog = new Button(shell, SWT.NONE);
		btnErrorLog.setText("Error log");
		
		Button btnDisplayReport = new Button(shell, SWT.NONE);
		btnDisplayReport.setText("Display report");

	}

}
