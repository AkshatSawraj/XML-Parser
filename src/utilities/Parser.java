package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Parser {
	
	//variable
	private boolean root = false;
	private File inputFile;
	private int lineCount = 0;
	private String line;
	String tagType = "";
	String rootTag = "";
	String currentTag = "";
	private int indexOfOpening = 0;
	private int indexOfClosing = 0;
	private int indexOfEndslash = 0;
	//DataStrcrues
	MyStack stack = new MyStack(30);
	
	public Parser(File inputF) 
    {
        this.inputFile = inputF;
        this.lineCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
             this.line = br.readLine();
             //Header is printed
             errorLogHeader();
             do {
                lineCount++;
                //
                //Checks if line is a tag and re-writes tagType var.
                isTag(this.line);
                //Absorb Root Tag
                if(lineCount == 2){
                	root = true;
                	rootTag = line;
                    if(rootTag.contains(" ")){
                    	rootTag= rootTag.substring(0, rootTag.indexOf(" "));
                    }
                }
                
                //Our Checker
                checker();
                
                this.line = br.readLine();
                
                }
             while (line != null);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //Print Remaining Stack.
        System.out.println("Pairs not found, else blank means no errors found!");
        System.out.println(stack);
    }
	
	//ErrorLog This method logs errors, and prints them out at the end.
	
	@SuppressWarnings("unchecked")
	public void errorLog() 
	{
		System.out.println("Error with line " + lineCount);
		System.out.println(line + "\n");	
	}
	//Error Log Header
	public void errorLogHeader() {
		System.out.println("------------Error Log------------------");		
		
	}
	
	//Case Sensitivity 
	public boolean caseSensitivity() {
		
		boolean uppercase = false;
		boolean lowercase = false;
		boolean isCaseSensitive = false;
		char store;
		
		for (int i=0; i < line.length(); i++) {
			store = line.charAt(i);
			
			if(store >=65 &&  store<=90 ){ 
				uppercase  = true;}
			if(store >=97 && store <=122 ){ 
				lowercase = true;}
			
			if ( uppercase && lowercase) {
				isCaseSensitive = true;
			}
		}
		return isCaseSensitive;
	}
	
	
	public void isTag(String singleLine) {
		
		boolean opening = false;
		boolean closing = false;
		boolean slash = false;
		
		
		
		for (int i=0; i < singleLine.length(); i++) {
			char singleChar = singleLine.charAt(i);

			
			if (singleChar == 60) {
				opening = true;
				indexOfOpening = i;
			}
			else if (singleChar == 62) {
				closing = true;
				indexOfClosing = i;
			}
			else if (singleChar == 47) {
				slash = true;
				indexOfEndslash = i;
			}		
			
			if (opening && closing && slash) {
			
				boolean isCaseSensitive = caseSensitivity();
				if (isCaseSensitive) {
					errorLog();
				}
				else if ((indexOfEndslash + 1) == indexOfClosing ){
					
					tagType = "selfClosingTag";
						  
				}
				else if (((indexOfOpening + 1) == indexOfEndslash )) {
					tagType = "endTag";
				
				}
				else {
					errorLog();
					System.out.println("** Warning Case Sensitive ");
				}
				
				
			}else if (opening && closing) {
				
				boolean isCaseSensitive = caseSensitivity();
				if (isCaseSensitive) {
					errorLog();
					System.out.println("** Warning Case Sensitive ");
				}
				//Format tag
				else if(line.indexOf(1)==63)
				{
					tagType = "notTag";
				}
				
				else{
					tagType = "openingTag";	
				}
			}
			else {
				tagType = "notTag";
			}
			
	      }
	}

	
	
	public void checker() {
//
	
//Do nothing for notTag Type (selfClosingTag, formatTag, or rootTag)

		
//If (startTag) <student>
			if(tagType.equals("openingTag") ) {
				
				if (line.contains("?") ) {
					
				}else {
				
					currentTag = line;
	                if(currentTag.contains(" ")){
	                	currentTag= (  currentTag.substring(1, currentTag.indexOf(" ")) );
					stack.push(currentTag);
					}
				}	
			}
			String top = null;
//If (endTag) 
			if(tagType.equals("endTag") ) {
				try {
					 top = (String) stack.peek();	
				} catch (NullPointerException e) {
					System.out.println("No items left in stack.");
					top = " ";
				}
				//top.contains prevents from a null check.
				if (top.contains(" ")) {
					if((top.substring( (indexOfOpening+1) , (indexOfClosing-1))) == (currentTag.substring( (indexOfEndslash+1) , (indexOfClosing-1))))
					{
						stack.pop();
					}
					else {
						errorLog();
						System.out.println("** no match found");
					}
				}
				
			}
		}
	}