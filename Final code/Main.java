public class Main{
	public static void main(String [] args) {
	//Displaying The animation	
		Animation a = new Animation(3000);
		a.showSplashAndExit();
		
		Dashboard dashboard = new Dashboard() ;
		dashboard.main(null);
		
		
	}
}
