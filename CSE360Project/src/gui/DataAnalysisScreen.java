package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Label;

public class DataAnalysisScreen {

	protected Shell shell;
	static ArrayList<Integer> data;

	/**
	 * Launch the application.
	 * @param args
	 */
	public DataAnalysisScreen(ArrayList<Integer> input)
	{
		data = input;
	}
	
	public static void main(String[] args) {
		try {
			DataAnalysisScreen window = new DataAnalysisScreen(data);
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

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(1200, 600);
		shell.setText("Data analysis");
		
		List list1 = new List(shell, SWT.BORDER);
		list1.setBounds(1077, 0, 107, 561);
		
		List list2 = new List(shell, SWT.BORDER);
		list2.setBounds(971, 0, 107, 561);
		
		List list3 = new List(shell, SWT.BORDER);
		list3.setBounds(864, 0, 107, 561);
		
		List list4 = new List(shell, SWT.BORDER);
		list4.setBounds(756, 0, 107, 561);
		
		for(int i = 0; i < data.size()/4; i++)
			list4.add(Integer.toString(data.get(i)));
		
		for(int i = data.size()/4; i < data.size()/2; i++)
			list3.add(Integer.toString(data.get(i)));
		
		for(int i = data.size()/2; i < data.size()*3/4; i++)
			list2.add(Integer.toString(data.get(i)));
		
		for(int i = data.size()*3/4; i < data.size(); i++)
			list1.add(Integer.toString(data.get(i)));

	}
}
