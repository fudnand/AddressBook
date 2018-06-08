package abApp;

/**
 * @author Whoever
 *
 */
interface AppView {
	String getInput(String prompt);
	String getResult();
	void display(String msg);
}

interface AppController{
	void appInit();
	void setView(String viewName);
	void run();
}

interface IAddressBook {
	void add(String name, String address);	
	int getSize();	
	void remove(String name); 	
	boolean contains(String name);	
	String getAddress(String name);
}

interface IDataHandler{
	void getData(String connectionStr);
	void saveData(String connectionStr);
}

