
import java.util.Scanner;
import java.util.TreeMap;
import java.io.File;
import java.util.Iterator;
import java.io.FileWriter;
import java.net.URL;

public class HBaseCode{

    TreeMap<String,Integer>frequency = new TreeMap();
    String title;
    String fileName;
    
    public HBaseCode(String title){
        this.title = title;
    }
    
    public String collectAndWrite() throws Exception{
    	String fileName = "";
    	int lastIndexOfForwSlash = title.lastIndexOf("/");
    	int lastIndexOfBackSlash = title.lastIndexOf("\\");
    	// extract filename from URL
    	if(lastIndexOfForwSlash>lastIndexOfBackSlash) {
    		fileName = title.substring( lastIndexOfForwSlash+1, title.length() );
    	} else {
    		fileName = title.substring( lastIndexOfBackSlash+1, title.length() );
    	}
    	
        Scanner sc = new Scanner(new File(title));
        while (sc.hasNextLine()) {
            String word = sc.next();
            word = word.replace(".","").replace("'","").replace("\"","").replace(",","").replace("?","").replace(";","").replace("(","").replace("!","");
            try {
                frequency.put(word,frequency.get(word)+1);
            } catch(Exception e) {
                frequency.put(word,1);
            }
        }
        sc.close();
        
        String outputURL = "C:/Syncfusion/BigData/3.2.0.20/BigDataSDK/Samples/Scripts/HBase/hbaseResult.txt";
    	File file = new File(outputURL); 
    	// delete the file if it exists
    	if(file.exists()) {
    		file.delete();
    	}
        if (frequency.size() > 0){
            String answer = "";
            FileWriter fileWriter = new FileWriter(outputURL);
            fileWriter.write("create "+"'"+fileName+"','words'\r\n"); 
            System.out.println(answer);
            Iterator itr = frequency.keySet().iterator();
            while(itr.hasNext()){
                String key = (String)itr.next();
                fileWriter.write("put '"+fileName+"','"+key+"','words:frequency',"+frequency.get(key)+"\r\n");
            }
            System.out.println(answer);
            
            fileWriter.write(answer);
            fileWriter.close();
        }
        return outputURL;
    }
    
    /*public void write() throws Exception{
    	File file = new File("hbaseResult.txt"); 
    	// delete the file if it exists
    	if(file.exists()) {
    		file.delete();
    	}
        if (frequency.size() > 0){
            String answer = "";
            FileWriter fileWriter = new FileWriter("hbaseResult.txt");
            fileWriter.write("create "+"'"+title+"','words'\r\n"); 
            System.out.println(answer);
            Iterator itr = frequency.keySet().iterator();
            while(itr.hasNext()){
                String key = (String)itr.next();
                fileWriter.write("put '"+fileName+"','"+key+"','words:frequency',"+frequency.get(key)+"\r\n");
            }
            System.out.println(answer);
            
            fileWriter.write(answer);
            fileWriter.close();
        }
    }*/

    /*public static void main(String [] args){
        String title = "C:/Users/rchak/eclipse-workspace/Amazon/src/The_Wonderful_Wizard_Of_Oz";
        HBaseCode code = new HBaseCode(title);
        try{
            code.collect();
            code.write();
        } catch(Exception e){
            System.out.println(e);
        }
    }*/
}