package com.tjgwebservices.app;

 import java.io.File;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.tjgwebservices.app.Actions.ImageManager;
import com.tjgwebservices.app.Actions.ImageProcessor;

 public class FileBrowser extends AppBase {
   Display display = new Display();
   Shell shell = new Shell(display);
   Text text;
   Text messageText;
   
   public FileBrowser() {
   init();
   shell.pack();
   shell.setSize(350,300);
   shell.open();
  
   while (!shell.isDisposed()) {
   if (!display.readAndDispatch()) {
   display.sleep();
   }
   }
   display.dispose();
   }
   private void init() {
   shell.setText("Bulk Photo Creator");
   shell.setLayout(new GridLayout(2, true));
   GridData data = new GridData(GridData.FILL_BOTH);

   ArrayList<Text> textForFile = new ArrayList<Text>();
   ArrayList<Label> labelsForFile = new ArrayList<Label>();
   ArrayList<Button> buttonsForFile = new ArrayList<Button>();
   
   for (int i=0; i<4; i++) {
	   Text oneText = new Text(shell, SWT.NONE);
	   oneText.setLayoutData(data);
	   Label oneLabel = new Label(shell, SWT.NONE);
	   oneLabel.setLayoutData(data);
	   Button oneButton = new Button(shell, SWT.PUSH);
	   oneButton.setText("Browse..");
	   if (i==0) {
		   oneLabel.setText("Image CSV");
		   oneButton.addSelectionListener(fileSelect("imageCSV"));
	   }
	   if (i==1) {
		   oneLabel.setText("Text CSV");
		   oneButton.addSelectionListener(fileSelect("textCSV"));
	   }
	   if (i==2) {
		   oneLabel.setText("Font CSV");
		   oneButton.addSelectionListener(fileSelect("fontCSV"));
	   }
	   if (i==3) {
		   oneLabel.setText("Logo CSV");
		   oneButton.addSelectionListener(fileSelect("logoCSV"));
	   }
	   textForFile.add(oneText);
	   labelsForFile.add(oneLabel);
	   buttonsForFile.add(oneButton);
   }
	   
   text = new Text(shell, SWT.NONE);
   text.setLayoutData(data);
	   
	   Button button2 = new Button(shell, SWT.Activate);
	   button2.setText("Logo");
		   button2.addSelectionListener(new SelectionAdapter() {
			   public void widgetSelected(SelectionEvent e) {
					ImageProcessor imageProcessor = new ImageProcessor();
					ImageManager imI = imageProcessor.processImage(getPaths().getProperty("imageCSV"), 
																	getPaths().getProperty("fontCSV"),
																	getPaths().getProperty("textCSV"),
																	getPaths().getProperty("textCSV"));
					messageText.setText("Adding Logo...");
			   }
		   });   
	   
	   Button button3 = new Button(shell, SWT.Activate);
	   button3.setText("Text");
	   button3.addSelectionListener(new SelectionAdapter() {
		   public void widgetSelected(SelectionEvent e) {
				ImageProcessor imageProcessor = new ImageProcessor();
			   messageText.setText("Adding Text...");
		   }
	   });
	   /*
	   Button button4 = new Button(shell, SWT.PUSH);
	   button4.setText("Process");
	   button4.addSelectionListener(new SelectionAdapter() {
		   public void widgetSelected(SelectionEvent e) {
			   messageText.setText("Processing Images...");
		   }
	   });*/
	   
	   Button button5 = new Button(shell, SWT.PUSH);
	   button5.setText("Archive");
	   button5.addSelectionListener(new SelectionAdapter() {
		   public void widgetSelected(SelectionEvent e) {
			   messageText.setText("Zipping Files...");
		   }
	   });
   
	   messageText = new Text(shell, SWT.READ_ONLY);
	   messageText.setSize(80,350);
//	   messageText.setBackgroundColor(GdkColor.this);
	   messageText.setLayoutData(data);

   }
   
  public void displayFiles(String[] files) {
   for (int i = 0; files != null && i < files.length; i++) {
   text.setText(files[i]);
   text.setEditable(true);
   }
 }
  
  
  public SelectionAdapter fileSelect(String csvType) {
	  SelectionAdapter selAdapter = new SelectionAdapter() {
		   public void widgetSelected(SelectionEvent e) {
			   FileDialog dialog = new FileDialog(shell, SWT.NULL);
			   String path = dialog.open();
			   if (path != null) {
			
				   File file = new File(path);
				   if (file.isFile()) {
					   getPaths().setProperty(csvType, path);
					   displayFiles(new String[] { file.toString()});
				   } else {
					   displayFiles(file.list());
				   }
			   }
		   }
	   };
	   
	   return selAdapter;
	  
  }
  
 } 