package abApp;
import java.io.*;
import java.util.*;

public class DataHandler implements IDataHandler{
	IAddressBook book;
	public DataHandler(IAddressBook book){
		this.book = book;
	}
	public void getData(String connStr){
        String name = null, address = null;
        try {
            FileReader fileReader = new FileReader(connStr);            
            BufferedReader bufferedReader = new BufferedReader(fileReader);//Wrap FileReader in BufferedReader.

            while((name = bufferedReader.readLine()) != null && (address = bufferedReader.readLine()) != null) {
             	book.add(name, address);
            } 
            bufferedReader.close();
        }
        catch(IOException ex) {
            System.out.println("Error reading file"); 
            ex.printStackTrace();                  
        }
	}
	
	public void saveData(String connStr){
	    FileWriter fileWriter;  
	    BufferedWriter bufferedWriter; 
		try {
			fileWriter = new FileWriter(connStr);
			bufferedWriter = new BufferedWriter(fileWriter); 
			//Once writing objects are instantiated, the existing content of the file would be wiped out...
            Set<String> kset = ((AddressBook) book).getKeyset(); 
            Iterator<String> it = kset.iterator();
            while ( it.hasNext() ) {
            	String name = it.next();
            	bufferedWriter.write( name );
            	bufferedWriter.write(System.getProperty ( "line.separator" ));
            	bufferedWriter.write( book.getAddress(name) );
            	bufferedWriter.write(System.getProperty ( "line.separator" ));
    		}
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println("Error writing to file");
            ex.printStackTrace();
        }
	}

}
