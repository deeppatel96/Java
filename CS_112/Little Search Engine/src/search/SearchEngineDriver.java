package search;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class SearchEngineDriver {

	public static void main(String[] args)
		throws IOException {
			
			Scanner sysin = new Scanner(System.in);
			System.out.print("Enter docs file name: ");
			String docsFile = sysin.next();
			
			System.out.print("Enter input noise file name: ");
			String noiseFile = sysin.next();
			
			// create new LittleSearchEngine object, using default constructor
			LittleSearchEngine lse = new LittleSearchEngine();
			
			lse.makeIndex(docsFile, noiseFile);
			System.out.println(lse.keywordsIndex);
			
			System.out.println(lse.top5search("crazy","night"));
		
	
	}


}
