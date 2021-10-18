package AppDriver;

import java.io.File;
import java.util.Scanner;

import utilities.Parser;

public class AppDriver {

	public static void main(String[] args) {
		//C:\\Users\\563621\\Downloads\\Parser_Backup_23\\res\\sample1.xml
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the file path of the XML File you would like to parse:\n");
		
		String filePath= input.next();
		
		File file=new File(filePath);
		Parser parse=new Parser(file);
		

	}

}
