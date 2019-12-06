package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import java.util.*;
import org.eclipse.jface.layout.*;

public class DataAnalysisScreen {

	protected Shell shell;
	static ArrayList<Integer> data;
	private Composite composite;
	private Table table;

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
		shell.setLayout(new FormLayout());
		
		composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new TableColumnLayout());
		FormData fd_composite = new FormData();
		fd_composite.bottom = new FormAttachment(100, -95);
		fd_composite.right = new FormAttachment(100, -39);
		fd_composite.top = new FormAttachment(100, -514);
		fd_composite.left = new FormAttachment(100, -651);
		composite.setLayoutData(fd_composite);
		
		table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		RowData[] rows = new RowData[data.size()];
		for(int i = 0; i < data.size(); i++)
		{
			
		}
		

	}
}
