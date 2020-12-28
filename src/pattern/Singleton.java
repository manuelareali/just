package pattern;


public class Singleton {

	private static Singleton instance;
	
	private Singleton() {}
	
	public static Singleton getnstance() {
		if (Singleton.instance == null)
			Singleton.instance = new Singleton();
		return instance;
	}
	
	@Override
	public Object clone(){
		return instance;
	}

}
