package Puzzle;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class alphabeticalOrder {
	private Map<String, Integer> myHash;
	
	public alphabeticalOrder(){
		myHash = new HashMap<String, Integer>();
	}
	
	public void insertHash(String str){
			
		if(myHash.containsKey(str)){
			int value = myHash.get(str);
			myHash.put(str, value+1);
		}
		else{
			myHash.put(str, 1);
		}
		
	}
	
	public Map<String, Integer> alphabetical(String str){
		
		String currentWord = "";
		
		int limit = str.length();
		
		int i = 0;
		
		while(i<=limit){
			
			if((i==limit) && !currentWord.isEmpty()){
				insertHash(currentWord);
				currentWord="";
			}
			
			//found non char and check it is not empty
			else{
				if(!Character.isLetter(str.charAt(i))){
			
					if(!currentWord.isEmpty()){
						insertHash(currentWord);
						currentWord="";
					}
				}else{
					currentWord += str.charAt(i);
				}
			}

			i++;
		}
		
		orderHash();
		return myHash;
		
		
	}
	
	public void orderHash(){
		
		Map<String, Integer> treeMap = new TreeMap<String, Integer>(new Comparator<String>(){
			@Override
			public int compare(String s1, String s2) {
				return s1.compareToIgnoreCase(s2);
			}
		});
		
		treeMap.putAll(myHash);
		myHash = treeMap;

	}
	
	public void printMap(){
		for(Map.Entry<String,Integer> entry: myHash.entrySet()){
			System.out.println("Word: " + entry.getKey() + " was used " + entry.getValue() +" time(s).");
		}
	}
}
