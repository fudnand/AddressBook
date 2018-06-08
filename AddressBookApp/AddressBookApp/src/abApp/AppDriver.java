package abApp;

public class AppDriver {

	public static void main(String[] args) {
		AppController app = new AddressAppController();
		app.setView("console");
		//app.setView("gui"); for gui
		app.run();
	}
}
