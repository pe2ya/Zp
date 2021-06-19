import java.io.*;
import java.util.*;
 
public class Main {    
	public static void main(String[] args) throws IOException {    
		
	BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\Admin\\Desktop\\Java\\ZP\\File1.txt")); 
    BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\Admin\\Desktop\\Java\\ZP\\File2.txt"));
     
    String line1 = br1.readLine();
    String line2 = br2.readLine();
    
    char[] ch1 = line1.toCharArray(); // vytvoří pole char pro porovnání znaků
    char[] ch2 = line2.toCharArray();
    
    
    int i;
    int lineNum = 1;
    int count = 0;
    int allchr = 0;
    
    ArrayList<String> matchlines = new ArrayList<>();  // vytvoří ArrayList pro ukládání slov
    ArrayList<String> match = new ArrayList<>();									// a znaků
   

    while (line1 != null || line2 != null)  // pokud jsou v nějakém dokumentu znaky, program se spustí
    {	
    	if(ch1.length > ch2.length) {					//pokud je první pole větší 
			for(i = 0; i < ch2.length; i++) {			
				
				if (ch1[i] == ch2[i]) {					//a pokud se znak z prvního dokumentu rovná znaku z druhého dokumentu, tak uloží se
					 match.add(String.valueOf(ch1[i]));	//převod char to String a přidání do pole
					 count++;							//počítání řádků
	            }
				allchr++;								//počítání znaků
			}
		}	
    	else {											//pokud je druhé pole větší
			for(i = 0; i < ch1.length; i++) {			
				if (ch1[i] == ch2[i]) {
					 match.add(String.valueOf(ch1[i]));
					 count++;
				} 
				allchr++;
			}
        }
    	try {
    		if(line1.equals(line2)) {					//pokud jsou řádky stejné, budou přidány do pole
        		System.out.println("At line " + lineNum + " we have same code: \n" + line1);
        		System.out.println(" ");
        		
        		 matchlines.add(line1);
        	}
        	else {										//pokud jsou řádky odlišné, bude napsáno, jak se liší
               System.out.println("Two files have different content. They differ at line "+lineNum);	
                
               System.out.println("File1 has "+line1+"\nFile2 has "+line2);
               System.out.println(" ");
                
        	}
    	         
		}
		catch(NullPointerException e) {
			System.out.println("NullPointerException thrown!");
		}
    	
   
         
        line1 = br1.readLine();  					//budou zapsány nové proměnné
        line2 = br2.readLine();
        
        try {
        	 ch1 = line1.toCharArray();				//budou zapsány nové proměnné
             ch2 = line2.toCharArray();
		}
		catch(NullPointerException e) {
			System.out.println("NullPointerException thrown!");
		}
        
        lineNum++;
    }
    
    br1.close();
    br2.close();

    												//systém hodnocení podobnosti
    											
    	  double mark1 ;						
    	  mark1 = (double) count / allchr;  	  	// koeficient podobnosti
    	  
    	  if(mark1 == 1) {
    		  System.out.println("files are the same");
    	  } 
    	  else if(mark1 == 0){
    		  System.out.println("files are completely different");
    	  }
    	  else {
    		  
	    	  System.out.print("mark is: ");
	    	  
	    	  int mark2 = (int)Math.round(mark1 * 10);		// převod double to integer
	    	  
	      	switch (mark2) {
	      	  case 10:
		      	    System.out.print("10");
		      	    break;
	      	  case 9:
		      	    System.out.print("9");
		      	    break;
	      	  case 8:
		      	    System.out.print("8");
		      	    break;
	      	  case 7:
		      	    System.out.print("7");
		      	    break;
	      	  case 6:
		      	    System.out.print("6");
		      	    break;
	      	  case 5:
		      	    System.out.print("5");
		      	    break;
	      	  case 4:
		      	    System.out.print("4");
		      	    break;
	      	  case 3:
	      		  	System.out.print("3");
	        	    break;
	      	  case 2:
	        	    System.out.print("2");
	        	    break;
	      	  case 1:
	        	    System.out.print("1");
	        	    break;
	      	  case 0:
	        	    System.out.print("0");
	        	    break;
	      	}
	      	
	      	System.out.println(" (10 - almost same; 0 - almost completely different)");
	    }
    	  String Str = (match.toString()).replaceAll(", ", "");  // převod ArrayList to String a výměna ","
    	  
    	  System.out.println(" ");
    	  System.out.println("Same lines is:");
    	  System.out.println(matchlines);
    	  
    	  System.out.println(" ");
    	  System.out.println("Same signs is:");
    	  System.out.println(Str);
    	  

    }
    	
  
    	
}

	
