package structures;

import java.util.*;

/**
 * This class implements an HTML DOM Tree. Each node of the tree is a TagNode, with fields for
 * tag/text, first child and sibling.
 * 
 */
public class Tree {
	
	/**
	 * Root node
	 */
	TagNode root=null;
	
	/**
	 * Scanner used to read input HTML file when building the tree
	 */
	Scanner sc;
	
	/**
	 * Initializes this tree object with scanner for input HTML file
	 * 
	 * @param sc Scanner for input HTML file
	 */
	public Tree(Scanner sc) {
		this.sc = sc;
		root = null;
	}
	
	/**
	 * Builds the DOM tree from input HTML file. The root of the 
	 * tree is stored in the root field.
	 */
	public void build() {
		
		String next = sc.nextLine();
		next = sc.nextLine();
		next = sc.nextLine();
		
		root = new TagNode("html",null,null);
		TagNode body = new TagNode("body",null,null);
		root.firstChild = body;
		TagNode ptr;
		String tag;

		Stack<TagNode> tags = new Stack<TagNode>();
		tags.push(root);
		tags.push(body);


		while(!next.equals("</body>")){
			if(!tags.isEmpty()){
			if(next.charAt(0) == '<'){
				
				if(next.charAt(1) == '/'){
					tags.pop();
				}
				
				else{
					tag = next.substring(1,next.length()-1);

					if(tags.peek().firstChild == null){
						tags.peek().firstChild = new TagNode(tag,null,null);
						tags.push(tags.peek().firstChild);
					}
					else{
						ptr = tags.peek().firstChild;
						while(ptr.sibling != null){
							ptr = ptr.sibling;
						}
						ptr.sibling = new TagNode(tag,null,null);
						tags.push(ptr.sibling);
					}
				}
			}
			else{
				
				if(tags.peek().firstChild == null){
					tags.peek().firstChild = new TagNode(next,null,null);
				}
				else{
					ptr = tags.peek().firstChild;
					while(ptr.sibling != null){
						ptr = ptr.sibling;
					}
					ptr.sibling = new TagNode(next,null,null);
				}
			}
			}
			
			next = sc.nextLine();
		}
	}
	
	/**
	 * Replaces all occurrences of an old tag in the DOM tree with a new tag
	 * 
	 * @param oldTag Old tag
	 * @param newTag Replacement tag
	 */
	public void replaceTag(String oldTag, String newTag) {
		
		root = recReplace(root,oldTag,newTag);
	
	}
	private TagNode recReplace(TagNode root,String oldTag, String newTag){
		
		if (root == null){
			return null;
		}
		else if(root.tag.equals(oldTag)){
			root.tag = newTag;
			root.firstChild = recReplace(root.firstChild,oldTag,newTag);
			root.sibling = recReplace(root.sibling,oldTag,newTag);
			return root;
		}
		else{
			root.firstChild = recReplace(root.firstChild,oldTag,newTag);
			root.sibling = recReplace(root.sibling,oldTag,newTag);
			return root;
		}
	}
	
	/**
	 * Boldfaces every column of the given row of the table in the DOM tree. The boldface (b)
	 * tag appears directly under the td tag of every column of this row.
	 * 
	 * @param row Row to bold, first row is numbered 1 (not 0).
	 */
	public void boldRow(int row) {
		
		root = recBold(root,row);
	}
	
	private TagNode recBold(TagNode root, int row){
		
		if (root == null){
			return null;
		}
		else if(root.tag.equals("table")){
			TagNode temp = root.firstChild;
			while(row>1){
				temp = temp.sibling;
				row--;
			}
			temp = temp.firstChild;
			while(temp != null){
				if(temp.firstChild.tag.equals("em")){
					temp.firstChild.tag = "b";
					temp = temp.sibling;
				}
				else{
				TagNode temp2 = temp.firstChild;
				temp.firstChild = new TagNode("b",temp2,null);
				temp = temp.sibling;
				}
			}
			return root;
		}
		else{
			root.firstChild = recBold(root.firstChild,row);
			root.sibling = recBold(root.sibling,row);
			return root;
		}
	}
	
	/**
	 * Remove all occurrences of a tag from the DOM tree. If the tag is p, em, or b, all occurrences of the tag
	 * are removed. If the tag is ol or ul, then All occurrences of such a tag are removed from the tree, and, 
	 * in addition, all the li tags immediately under the removed tag are converted to p tags. 
	 * 
	 * @param tag Tag to be removed, can be p, em, b, ol, or ul
	 */
	public void removeTag(String tag) {

		root = recRemove(root,tag);

	}
	
	private TagNode recRemove(TagNode root, String tag){
		
		if (root == null){
			return null;
		}
		else if(root.firstChild != null||root.sibling !=null){
			if(root.firstChild != null){
				if(root.firstChild.tag.equals(tag)){
					TagNode temp = root.firstChild.sibling;
					root.firstChild = root.firstChild.firstChild;
					TagNode ptr = root.firstChild;
					while(ptr.sibling!=null){
						ptr = ptr.sibling;
					}
					ptr.sibling = temp;
				
					if(tag.equals("ul")||tag.equals("ol")){
						ptr = root;
						if(ptr.firstChild.tag.equals("li")){
							ptr.firstChild.tag = "p";
						}
						ptr = ptr.firstChild;
						while(ptr.sibling != null){
							if(ptr.sibling.tag.equals("li")){
								ptr.sibling.tag = "p";
							}
							ptr = ptr.sibling;
						}
					}
				}

			}
			if(root.sibling!=null){
				if(root.sibling.tag.equals(tag)){
					TagNode temp = root.sibling.sibling;
					root.sibling = root.sibling.firstChild;
					TagNode ptr = root.sibling;
					while(ptr.sibling!=null){
					ptr = ptr.sibling;
					}
					ptr.sibling = temp;
			
					if(tag.equals("ul")||tag.equals("ol")){
						ptr = root;
						while(ptr.sibling != null){
							if(ptr.sibling.tag.equals("li")){
							ptr.sibling.tag = "p";
							}
						ptr = ptr.sibling;
						}
					}
				}
			}
			if(root.firstChild != null&&root.sibling!=null){
				root.firstChild = recRemove(root.firstChild,tag);
				root.sibling = recRemove(root.sibling,tag);
				return root;
			}
			else if(root.sibling != null){
				root.sibling = recRemove(root.sibling,tag);
				return root;
			}
			else if(root.firstChild != null){
				root.firstChild = recRemove(root.firstChild,tag);
				return root;
			}
			else
			{
				return root;
			}
		}
		else{
			if(root.firstChild != null&&root.sibling!=null){
				root.firstChild = recRemove(root.firstChild,tag);
				root.sibling = recRemove(root.sibling,tag);
				return root;
			}
			else if(root.sibling != null){
				root.sibling = recRemove(root.sibling,tag);
				return root;
			}
			else if(root.firstChild != null){
				root.firstChild = recRemove(root.firstChild,tag);
				return root;
			}
			else
			{
				return root;
			}
		}
	}
	
	/**
	 * Adds a tag around all occurrences of a word in the DOM tree.
	 * 
	 * @param word Word around which tag is to be added
	 * @param tag Tag to be added
	 */
	public void addTag(String word, String tag) {

		String word2 = word+".";
		String word3 = word+",";
		String word4 = word+"?";
		String word5 = word+"!";
		String word6 = word+":";
		String word7 = word+";";
		String word8 = word+" ";
		String word9 = " "+word;
		root = recAdd(root,word,tag);
		root = recAdd(root,word2,tag);
		root = recAdd(root,word3,tag);
		root = recAdd(root,word4,tag);
		root = recAdd(root,word5,tag);
		root = recAdd(root,word6,tag);
		root = recAdd(root,word7,tag);
		root = recAdd(root,word8,tag);
		root = recAdd(root,word9,tag);
		
	}
	
	private TagNode recAdd(TagNode root, String word, String tag){
				
		if (root == null){
			return null;
		}
		else if(root.tag.equalsIgnoreCase(word)){
			String temp = root.tag;
			root.tag = tag;
			root.firstChild = new TagNode(temp,null,null);
			
			root.sibling = recAdd(root.sibling,word,tag);
			return root;
		}
		else if(root.tag.toLowerCase().contains(word.toLowerCase()+" ")||root.tag.toLowerCase().contains(" "+word.toLowerCase())){
			if(root.tag.toLowerCase().startsWith(word.toLowerCase()+" ")){
				String temp = root.tag.substring(0,word.length());
				String temp2 = root.tag.substring(word.length());
				root.tag = tag;
				root.firstChild = new TagNode(temp,null,null);
				TagNode ptr = root.sibling;
				root.sibling =  new TagNode(temp2,null,ptr);
				
				root.sibling = recAdd(root.sibling,word,tag);
				return root;
			}
			else if (root.tag.toLowerCase().endsWith(" "+word.toLowerCase())){
				String temp = root.tag.substring(root.tag.length()-word.length());
				String temp2 = root.tag.substring(0,root.tag.length()-word.length());
				root.tag = temp2;
				TagNode ptr = root.sibling;
				root.sibling =  new TagNode(tag,null,null);
				root.sibling.firstChild = new TagNode(temp,null,null);
				root.sibling.sibling = ptr;
				
				root.sibling.sibling = recAdd(root.sibling.sibling,word,tag);
				return root;
			}
			else if(root.tag.toLowerCase().contains(" "+word.toLowerCase()+" ")){
				int index = root.tag.toLowerCase().indexOf(word.toLowerCase());
				String temp = root.tag.substring(index,word.length()+index);
				String tempFront = root.tag.substring(0,index);
				String tempBack = root.tag.substring(word.length()+index);
				root.tag = tempFront;
				TagNode ptr = root.sibling;
				root.sibling = new TagNode(tag,null,null);
				root.sibling.firstChild = new TagNode(temp,null,null);
				root.sibling.sibling = new TagNode(tempBack,null,ptr);
				
				root.sibling.sibling = recAdd(root.sibling.sibling,word,tag);
				return root;
			}
			else{
				root.firstChild = recAdd(root.firstChild,word,tag);
				root.sibling = recAdd(root.sibling,word,tag);
				return root;
			}
			
		}
		else{
			root.firstChild = recAdd(root.firstChild,word,tag);
			root.sibling = recAdd(root.sibling,word,tag);
			return root;
		}
	} 
	
	/**
	 * Gets the HTML represented by this DOM tree. The returned string includes
	 * new lines, so that when it is printed, it will be identical to the
	 * input file from which the DOM tree was built.
	 * 
	 * @return HTML string, including new lines.
	 */
	public String getHTML() {
		StringBuilder sb = new StringBuilder();
		getHTML(root, sb);
		return sb.toString();
	}
	
	private void getHTML(TagNode root, StringBuilder sb) {
		for (TagNode ptr=root; ptr != null;ptr=ptr.sibling) {
			if (ptr.firstChild == null) {
				sb.append(ptr.tag);
				sb.append("\n");
			} else {
				sb.append("<");
				sb.append(ptr.tag);
				sb.append(">\n");
				getHTML(ptr.firstChild, sb);
				sb.append("</");
				sb.append(ptr.tag);
				sb.append(">\n");	
			}
		}
	}
	
}
