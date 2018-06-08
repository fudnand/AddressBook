package abApp;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class AnotherSolution {
	static AddressBook book = new AddressBook();
	public static void main(String[] args) {
		String input = "";
		Scanner sc = new Scanner(System.in);
		getData("addresses.txt");
		
		do{
			System.out.println("Add (a), Retrieve (r) an address, or quit (q)? ");
			input = sc.nextLine();
			if(input.equalsIgnoreCase("a")){
				System.out.println("Enter name --> ");
				String name = sc.nextLine();
				System.out.println("Enter address --> ");
				String address = sc.nextLine();
				book.add(name, address);
			}
			else if(input.equalsIgnoreCase("r")){
				System.out.println("Enter name --> ");
				input = sc.nextLine();
				String result = book.getAddress(input.trim());				
				System.out.println(result);
			}
			else {
				saveData("addresses.txt");
				break; 
			}
		}while(true);		
	}
	
	public static void getData(String connStr){
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
	
	public static void saveData(String connStr){
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
