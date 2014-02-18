package testFiles;

public class test {
	
	
	public static void main(String args[]){
		String q = "@@0,0";
		char a = q.charAt(2);
		char b = q.charAt(4);
		
		int x = Character.getNumericValue(a);
		int y = Character.getNumericValue(b);
		System.out.println(" hit message battleship x = " + x + " y = " + y);
		
		
		
	}
	
	
	

}
