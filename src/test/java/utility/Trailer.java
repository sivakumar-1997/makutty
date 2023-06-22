package utility;

import java.text.DateFormat;
import java.util.Date;

import org.apache.poi.ss.formula.functions.Replace;

public class Trailer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 Date dre = new Date();
	 String s = dre.toString();
	 String replace = s.replaceAll("[a-zA-Z]"," ").replace(" ","");
	 String free = replace.substring(10);
	 System.out.println(free);
	 
	}

}
