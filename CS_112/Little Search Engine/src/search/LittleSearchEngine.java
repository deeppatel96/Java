package search;

import java.io.*;
import java.util.*;

/**
 * This class encapsulates an occurrence of a keyword in a document. It stores the
 * document name, and the frequency of occurrence in that document. Occurrences are
 * associated with keywords in an index hash table.2
 * 
 * @author Deep Patel
 * 
 */
class Occurrence {
	/**
	 * Document in which a keyword occurs.
	 */
	String document;
	
	/**
	 * The frequency (number of times) the keyword occurs in the above document.
	 */
	int frequency;
	
	/**
	 * Initializes this occurrence with the given document,frequency pair.
	 * 
	 * @param doc Document name
	 * @param freq Frequency
	 */
	public Occurrence(String doc, int freq) {
		document = doc;
		frequency = freq;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "(" + document + "," + frequency + ")";
	}
}

/**
 * This class builds an index of keywords. Each keyword maps to a set of documents in
 * which it occurs, with frequency of occurrence in each document. Once the index is built,
 * the documents can searched on for keywords.
 *
 */
public class LittleSearchEngine {
	
	/**
	 * This is a hash table of all keywords. The key is the actual keyword, and the associated value is
	 * an array list of all occurrences of the keyword in documents. The array list is maintained in descending
	 * order of occurrence frequencies.
	 */
	HashMap<String,ArrayList<Occurrence>> keywordsIndex;
	
	/**
	 * The hash table of all noise words - mapping is from word to itself.
	 */
	HashMap<String,String> noiseWords;
	
	/**
	 * Creates the keyWordsIndex and noiseWords hash tables.
	 */
	public LittleSearchEngine() {
		keywordsIndex = new HashMap<String,ArrayList<Occurrence>>(1000,2.0f);
		noiseWords = new HashMap<String,String>(100,2.0f);
	}
	
	/**
	 * This method indexes all keywords found in all the input documents. When this
	 * method is done, the keywordsIndex hash table will be filled with all keywords,
	 * each of which is associated with an array list of Occurrence objects, arranged
	 * in decreasing frequencies of occurrence.
	 * 
	 * @param docsFile Name of file that has a list of all the document file names, one name per line
	 * @param noiseWordsFile Name of file that has a list of noise words, one noise word per line
	 * @throws FileNotFoundException If there is a problem locating any of the input files on disk
	 */
	public void makeIndex(String docsFile, String noiseWordsFile) 
	throws FileNotFoundException {
		// load noise words to hash table
		Scanner sc = new Scanner(new File(noiseWordsFile));
		while (sc.hasNext()) {
			String word = sc.next();
			noiseWords.put(word,word);
		}
		
		// index all keywords
		sc = new Scanner(new File(docsFile));
		while (sc.hasNext()) {
			String docFile = sc.next();
			HashMap<String,Occurrence> kws = loadKeyWords(docFile);
			mergeKeyWords(kws);
		}
		
	}

	/**
	 * Scans a document, and loads all keywords found into a hash table of keyword occurrences
	 * in the document. Uses the getKeyWord method to separate keywords from other words.
	 * 
	 * @param docFile Name of the document file to be scanned and loaded
	 * @return Hash table of keywords in the given document, each associated with an Occurrence object
	 * @throws FileNotFoundException If the document file is not found on disk
	 */
	public HashMap<String,Occurrence> loadKeyWords(String docFile) 
	throws FileNotFoundException {
	
		HashMap<String,Occurrence> table = new HashMap<String,Occurrence>();
		Scanner sc = new Scanner(new File(docFile));
		while (sc.hasNext()) {
			String word = sc.next();
			String keyWord = getKeyWord(word);
			if(keyWord != null){
				Occurrence occ = table.get(keyWord);
				if(occ != null){
					occ.frequency = occ.frequency+1;
					table.remove(keyWord);
					table.put(keyWord,occ);
				}
				else{
					table.put(keyWord, new Occurrence(docFile,1));
				}
			}
		
		}

		return table;
	}
	
	/**
	 * Merges the keywords for a single document into the master keywordsIndex
	 * hash table. For each keyword, its Occurrence in the current document
	 * must be inserted in the correct place (according to descending order of
	 * frequency) in the same keyword's Occurrence list in the master hash table. 
	 * This is done by calling the insertLastOccurrence method.
	 * 
	 * @param kws Keywords hash table for a document
	 */
	public void mergeKeyWords(HashMap<String,Occurrence> kws) {
		
		int curr = 0;
		for(Map.Entry<String, Occurrence> entry : kws.entrySet()){
			String key = entry.getKey();
			Occurrence occ = entry.getValue();
			if (keywordsIndex.containsKey(key)){
				ArrayList<Occurrence> occs = keywordsIndex.get(key);
				occs.add(occ);
				insertLastOccurrence(occs);
			}
			else{
				ArrayList<Occurrence> occs = new ArrayList<Occurrence>();
				occs.add(occ);
				keywordsIndex.put(key,occs);
			}
			
        }	
		
	}
	
	/**
	 * Given a word, returns it as a keyword if it passes the keyword test,
	 * otherwise returns null. A keyword is any word that, after being stripped of any
	 * TRAILING punctuation, consists only of alphabetic letters, and is not
	 * a noise word. All words are treated in a case-INsensitive manner.
	 * 
	 * Punctuation characters are the following: '.', ',', '?', ':', ';' and '!'
	 * 
	 * @param word Candidate word
	 * @return Keyword (word without trailing punctuation, LOWER CASE)
	 */
	public String getKeyWord(String word) {
	
		word = word.toLowerCase();
		while(word.endsWith(".")||word.endsWith(",")||word.endsWith("?")||word.endsWith(":")||word.endsWith(";")||word.endsWith("!")){
			word = word.substring(0, word.length()-1);
		}
		for(int i = 0; i<word.length(); i++){
			if(word.charAt(i) < 97 || word.charAt(i) > 122){
				return null;
			}
		}
		if(noiseWords.containsValue(word) || word.equals("")){
			return null;
		}
		return word;
		
	}
	
	/**
	 * Inserts the last occurrence in the parameter list in the correct position in the
	 * same list, based on ordering occurrences on descending frequencies. The elements
	 * 0..n-2 in the list are already in the correct order. Insertion of the last element
	 * (the one at index n-1) is done by first finding the correct spot using binary search, 
	 * then inserting at that spot.
	 * 
	 * @param occs List of Occurrences
	 * @return Sequence of mid point indexes in the input list checked by the binary search process,
	 *         null if the size of the input list is 1. This returned array list is only used to test
	 *         your code - it is not used elsewhere in the program.
	 */
	public ArrayList<Integer> insertLastOccurrence(ArrayList<Occurrence> occs) {

		
		ArrayList<Integer> output = new ArrayList();
		Occurrence last = occs.get(occs.size()-1);
		if (occs.size() > 1){
			int index = 0;
			int lo = 0;
			int hi = occs.size()-2;
			int mid = lo + (hi-lo)/2;
			while (lo<=hi){
				mid = lo + (hi-lo)/2;
				output.add(mid);
				if(last.frequency < occs.get(mid).frequency){
					lo = mid + 1;
				}
				else if(last.frequency > occs.get(mid).frequency){
					hi = mid - 1;
				}
				else{
					break;
				}
			}
			if(lo > mid){
				//put last to right of mid index
				int curr = occs.size()-1;
				while(curr > mid+1){
					occs.set(curr,occs.get(curr-1));
					curr--;
				}
				occs.set(mid+1, last);
			}
			else{
				//put last to left of mid index
				int curr = occs.size()-1;
				while(curr > mid){
					occs.set(curr,occs.get(curr-1));
					curr--;
				}
				occs.set(mid, last);
			}
			return output;
		}
		else{
			return null;
		}
	}
	
	/**
	 * Search result for "kw1 or kw2". A document is in the result set if kw1 or kw2 occurs in that
	 * document. Result set is arranged in descending order of occurrence frequencies. (Note that a
	 * matching document will only appear once in the result.) Ties in frequency values are broken
	 * in favor of the first keyword. (That is, if kw1 is in doc1 with frequency f1, and kw2 is in doc2
	 * also with the same frequency f1, then doc1 will appear before doc2 in the result. 
	 * The result set is limited to 5 entries. If there are no matching documents, the result is null.
	 * 
	 * @param kw1 First keyword
	 * @param kw1 Second keyword
	 * @return List of NAMES of documents in which either kw1 or kw2 occurs, arranged in descending order of
	 *         frequencies. The result size is limited to 5 documents. If there are no matching documents,
	 *         the result is null.
	 */
	public ArrayList<String> top5search(String kw1, String kw2) {
		
		ArrayList<String> output = new ArrayList<String>();
		ArrayList<Occurrence> key1 = keywordsIndex.get(kw1);
		ArrayList<Occurrence> key2 = keywordsIndex.get(kw2);
		// if key1 and key2 are not found
		if(key1 == null && key2 == null){
			return null;
		}
		int total = 0;
		int curr1 = 0;
		int curr2 = 0;
		while(total<5){
			// if both key1 and key2 are found
			if(key1 != null && key2 != null){
				if(curr1<key1.size() && curr2<key2.size()){
					if(key1.get(curr1).frequency >= key2.get(curr2).frequency){
						if(!output.contains(key1.get(curr1).document)){
							output.add(key1.get(curr1).document);
							total++;
						}
						curr1++;
					}
					else{
						if(!output.contains(key2.get(curr2).document)){
							output.add(key2.get(curr2).document);
							total++;
						}
						curr2++;
					}
				}
				else if (curr1<key1.size()){
					if(!output.contains(key1.get(curr1).document)){
						output.add(key1.get(curr1).document);
						total++;
					}
					curr1++;
				}
				else if (curr2<key2.size()){
					if(!output.contains(key2.get(curr2).document)){
						output.add(key2.get(curr2).document);
						total++;
					}
					curr2++;
				}
				else{
					break;
				}
			}// if key2 is not found
			else if(key1 != null && key2 == null){
				if(curr1<key1.size()){
					output.add(key1.get(curr1).document);
					curr1++;
					total++;
				}
				else{
					break;
				}
			} // if key 1 is not found
			else if(key1 == null && key2 != null){
				if(curr2<key2.size()){
					output.add(key2.get(curr2).document);
					curr2++;
					total++;
				}
				else{
					break;
				}
			}
		}
		
		return output;
		
		
	}
}
