package mainPackage;

import java.text.Format;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;

public class Rough {

	public static void main(String[] args) {
		
		//whichisgreater(1000,1151,2000);
		
		//reverseString("Automation");
		
		//reverseStringWithoutBuilder("boopathi raja");
		
		//swap();
		
		//map();
		
		dateCompare("12/2020");
	}
	
	public static void dateCompare(String actualMMYYYY) {

		String aMM = actualMMYYYY.split("/")[0];
		String aYYYY = actualMMYYYY.split("/")[1];

		int AMM = Integer.parseInt(aMM);
		int AYYYY = Integer.parseInt(aYYYY);

		System.out.println("Given Month - "+aMM+" Given Year -"+aYYYY);

			LocalDateTime l = LocalDateTime.now();
			
			String d =l.format(DateTimeFormatter.ofPattern("DD/MM/YYYY"));

			String cDD = d.split("/")[0];
			String cMM = d.split("/")[1];
			String cYYYY = d.split("/")[2];
			
			int CDD = Integer.parseInt(cDD);
			int CMM = Integer.parseInt(cMM);
			int CYYYY = Integer.parseInt(cYYYY);
			
			System.out.println(cDD);
			System.out.println(cMM);
			System.out.println(cYYYY);
			
			if(AYYYY < CYYYY )
				System.out.println("Card validity Expired");
			else if(AMM < CMM)
				System.out.println("Card validity Expired");
			else 
				System.out.println("Valid Card");
			
	}
	public static void map() {
		HashMap<String,String> map = new HashMap<String,String>();
		System.out.println(map.isEmpty());
		
		map.put("A","");
		map.put("B", "");
		map.put("C", "");
		System.out.println(map);
		
		for(String list : map.keySet()) 
			System.out.println(map.get(list));
			
	}
	
	public static void swap() {
		
		int a,b,temp;
		
		a=10; b=5;
		
		System.out.println("Before swap - "+a+" "+b);
		
		temp=a;
		a=b;
		b=temp;
		System.out.println("After swap - "+a+" "+b);
				
				
	}
	
	public static void reverseStringWithoutBuilder(String text) {
		char [] revstring = text.toCharArray();
		
		for(int i = revstring.length-1;i>=0;i--)
			System.out.print(revstring[i]);
	
	}
	
	
	
	public static void reverseString(String text) {
		
		
		StringBuilder str2 = new StringBuilder();
		str2.append(text);
		
		System.out.println(str2.reverse());
	}
	
	
	public static void whichisgreater(int a,int b,int c)
	{
		if(a>b && a>c)
			System.out.println("A is big - "+a);
		else if(b>a && b>c)
			System.out.println("B is big - "+b);
		else if(c>a && c>b)
			System.out.println("C is big - "+c);
		
		
			
	}
}
