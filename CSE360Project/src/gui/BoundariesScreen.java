package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class BoundariesScreen {

	protected Shell shell;
	private Text text;
	private Text text_1;
	public static int min;
	public static int max;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BoundariesScreen window = new BoundariesScreen();
			window.open();
			min = window.min;
			max = window.max;
		} catch (Exception error) {
			error.printStackTrace();
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
		shell.setSize(464, 100);
		shell.setText("Set boundaries");
		shell.setLayout(new RowLayout(SWT.HORIZONTAL));
		
		Label lblSetMinimum = new Label(shell, SWT.NONE);
		lblSetMinimum.setAlignment(SWT.CENTER);
		lblSetMinimum.setText("Set minimum:");
		
		text = new Text(shell, SWT.BORDER);
		
		Label lblSetMaximum = new Label(shell, SWT.NONE);
		lblSetMaximum.setText("Set maximum:");
		
		text_1 = new Text(shell, SWT.BORDER);
		
		Label lblError= new Label(shell, SWT.NONE);
		lblError.setText("Invalid number");
		lblError.setVisible(false);
		
		Button btnDone = new Button(shell, SWT.NONE);
		btnDone.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent selected) {
				try {
					min = Integer.parseInt(text.getText());
					max = Integer.parseInt(text_1.getText());
					
					shell.close();
				} catch(NumberFormatException e) {
					lblError.setVisible(true);
					
				}
			}
		});
		btnDone.setText("Done");
		
		

	}
}
