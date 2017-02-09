package org.nurture;

public class RND {

	public static void main(String[] args) {
		
		String str = "8277171790";
		String substring = str.substring(Math.max(str.length() - 3, 0));
		
		String upToNCharacters = str.substring(0, Math.min(str.length(), 3));
		System.out.println("\n Input data ="+str);
		System.out.println("\n Output data ="+substring);
		System.out.println("\n Output upToNCharacters ="+upToNCharacters);
		System.out.println("\n Output data2 ="+upToNCharacters+substring);
		
		System.out.println(getPassCode(str));
		

	}

	private static String getPassCode(String str) {
		return  (str.substring(0, Math.min(str.length(), 3)) +str.substring(Math.max(str.length() - 3, 0))) ;
	}

}
