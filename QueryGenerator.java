import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage; 
import javafx.scene.text.Text; 
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.nio.file.Files;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class QueryGenerator extends Application{

    private int i = 0;

    public void start(Stage stage) {
   
        GridPane grid = new GridPane();
        grid.setStyle("-fx-background-color:#87cefa");
        grid.setVgap(4);
        grid.setHgap(4);
        
        /*final Text direction1 = new Text();
        direction1.setText("Enter file text name, title, word in the 3 text boxes."
        		+ "\t\t\t\t\t\t\t\t\t\t\t\t   ");
        GridPane.setConstraints(direction1, 1, 0);
        grid.getChildren().add(direction1);
        
        //First label and text-box
        final TextField fileName = new TextField();
        fileName.setPromptText("Enter file text name.");
        fileName.setPrefColumnCount(10);
        GridPane.setConstraints(fileName, 1, 2);
        grid.getChildren().add(fileName);
        
        //First label and text-box
        final TextField title = new TextField();
        title.setPromptText("Enter the title.");
        title.setPrefColumnCount(10);
        GridPane.setConstraints(title, 1, 3);
        grid.getChildren().add(title);
        
        //First label and text-box
        final TextField word = new TextField();
        word.setPromptText("Enter the word.");
        word.setPrefColumnCount(10);
        word.getText();
        GridPane.setConstraints(word, 1, 4);
        grid.getChildren().add(word);
        
        
        Button submit = new Button("Search");
        GridPane.setConstraints(submit, 1, 5);
        grid.getChildren().add(submit);
        
        final Label label = new Label();
        GridPane.setConstraints(label, 1, 6);
        GridPane.setColumnSpan(label, 2);
        grid.getChildren().add(label);
        
        
        submit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                try{
                    File file = new File(fileName.getText()+".txt");
                    if (i == 0){
                        file.delete();
                        file.createNewFile();
                    }
					String content =  new String(Files.readAllBytes(file.toPath()),"UTF-8");
                    FileWriter fileWriter = new FileWriter(fileName.getText()+".txt");
                    String code = get(title.getText().replace(" ","_"),word.getText());
                    label.setText(title.getText() + " and " + word.getText() + " are submitted.");
                    fileWriter.write(content+code+"\n");
                    System.out.println(content + code);
                    System.out.println();
                    fileWriter.close();
                    i++;
                } catch(Exception ex){
                    System.out.println(ex);
                }
            }
        });*/
        
        // Intro text message 1
        final Text intro = new Text();
        intro.setFont(new Font(15));
        intro.setText("This application takes a file of a suitable format(like .txt).");
        intro.setFill(Color.PURPLE);
        GridPane.setConstraints(intro, 1, 0);
        grid.getChildren().add(intro);
        
        // Intro text message 2
        final Text intro2 = new Text();
        intro2.setFont(new Font(15));
        intro2.setText("An HBase Script that stores frequency of each word in the file is generated.");
        intro2.setFill(Color.PURPLE);
        GridPane.setConstraints(intro2, 1, 1);
        grid.getChildren().add(intro2);
        
        // First text message
        final Text message = new Text();
        message.setFont(new Font(15));
        message.setText("Enter the file URL below :");
        GridPane.setConstraints(message, 1, 2);
        grid.getChildren().add(message);
        
        // First text box for entering file URL
        final TextField textBoxInput = new TextField();
        textBoxInput.setPrefColumnCount(10);
        GridPane.setConstraints(textBoxInput, 1, 3);
        grid.getChildren().add(textBoxInput);
        
        // button to generate HBase Script
        Button genScriptButton = new Button("Generate HBase Script");
        GridPane.setConstraints(genScriptButton, 1, 4);
        grid.getChildren().add(genScriptButton);
        
        // Second text message for giving instrutions about the script
        /*final Text message2 = new Text();
        message2.setFont(new Font(15));
        message2.setText("If file is successfully located, a HBase script will be generated below.");
        GridPane.setConstraints(message2, 1, 5);
        grid.getChildren().add(message2);
        

        // Third text message for giving instrutions about the script
        final Text message3 = new Text();
        message3.setFont(new Font(15));
        message3.setText("Copy, paste and execute in a proper HBase Environment (Eg: Syncfusion Big Data Studio).");
        GridPane.setConstraints(message3, 1, 6);
        grid.getChildren().add(message3);*/
        
        // Fourth text message 
        final Text message4 = new Text();
        message4.setFont(new Font(15));
        GridPane.setConstraints(message4, 1, 6);
        grid.getChildren().add(message4);
        
        // Second text box for displaying generated Script
        final TextField textBoxOutput = new TextField();
        textBoxOutput.setPrefColumnCount(10);
        textBoxOutput.setVisible(false);
        textBoxOutput.setEditable(false);
        GridPane.setConstraints(textBoxOutput, 1, 7);
        grid.getChildren().add(textBoxOutput);
        
        // Fifth text message giving instructions
        final Text message5 = new Text();
        message5.setFont(new Font(15));
        GridPane.setConstraints(message5, 1, 8);
        grid.getChildren().add(message5);
        
        // Sixth text message giving instructions
        final Text message6 = new Text();
        message6.setFont(new Font(15));
        GridPane.setConstraints(message6, 1, 9);
        grid.getChildren().add(message6);
        
        // Seventh text message giving instructions
        final Text message7 = new Text();
        message7.setFont(new Font(15));
        GridPane.setConstraints(message7, 1, 10);
        grid.getChildren().add(message7);
        
        // Eigth text message giving instructions
        final Text message8 = new Text();
        message8.setFont(new Font(15));
        GridPane.setConstraints(message8, 1, 11);
        grid.getChildren().add(message8);
        
        // event handler function that generates the script on click of the button
        genScriptButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
            	try {
            		String typedFileURLText = textBoxInput.getText();
            		File typedFileURL = new File(typedFileURLText);
            		if(!typedFileURL.exists()) {
            			message4.setText("Invalid Filename or File URL!! Please enter again.");
            			message4.setFill(Color.RED);
        				textBoxOutput.setVisible(false);
        				message5.setText("");
        				message6.setText("");
        				message7.setText("");
        				message8.setText("");

            		} else {
            			message4.setText("The HBase Query executed is as follows:");
            			message4.setFill(Color.GREEN);
            			HBaseCode hbaseCode = new HBaseCode(typedFileURLText);
            			try{
            				String outputURL = hbaseCode.collectAndWrite();
            				textBoxOutput.setVisible(true);
            				FileReader file = new FileReader(outputURL);
            			    BufferedReader reader = new BufferedReader(file);

            			    String fileContents = "";
            			    String line = reader.readLine();

            			    while (line != null) {
            			    	fileContents += line;
            			        line = reader.readLine();
            			    }
            			    textBoxOutput.setText(fileContents);
            			    message5.setText("You can also see the file generated (hbaseResult.txt) in Syncfusion Big Data Studio.");
            			    message5.setFill(Color.GREEN);
            			    message6.setText("Open Syncfusion Big Data Platform -> Press Launch Studio -> Click HBase Toolbar.");
            			    message6.setFill(Color.GREEN);
            			    message7.setText("On the right side of the screen, a list of txt files under Samples will be displayed.");
            			    message7.setFill(Color.GREEN);
            			    message8.setText("Inside Samples, search for hBaseResult.txt under HBase.");
            			    message8.setFill(Color.GREEN);
            	        } catch(Exception exception){
            	            System.out.println(exception);
            	        }
            		}
            		
            	} catch(Exception exception){
                    System.out.println(exception);
                }
            }
        });
        
   
        
        Scene scene = new Scene(grid, 600, 300);  
        stage.setTitle("HBase Query Generator"); 
        stage.setScene(scene); 
        stage.show(); 
   }

    /**
     * Perform the search
     */
    
    public String get(String tableName, String row){
        return "get '" + tableName + "', '" + row + "'";
    }
    
    public static void main(String [] args){
        launch(args); 
    }
}