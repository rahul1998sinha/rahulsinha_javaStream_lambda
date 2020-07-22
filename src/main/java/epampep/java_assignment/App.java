package epampep.java_assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        BufferedReader input  = new BufferedReader(new InputStreamReader(System.in));
        do
        {	System.out.println("Menu:");
        	System.out.println("1.Average of List of Integers");
        	System.out.println("2.Filter Strings having length = 3 and starting with a");
        	System.out.println("3.Filter Pallindrome Strings");
        	char c = input.readLine().trim().charAt(0);
        	switch(c) {
        	case '1':System.out.println("Enter the integers separated by space");
        			 List<Integer> list = Arrays.asList(input.readLine().trim().split(" ")).stream().map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
        			 System.out.println(averageOfList(list));
        			 break;
	        case '2':System.out.println("Enter the Strings separated by space");
	        		 List<String> words = Arrays.asList(input.readLine().trim().split(" "));
	        		 Predicate<String> predicate = (s)->s.length()==3 && s.charAt(0)=='a';
	        		 List<String> result = stringsWithA(words,predicate);
	        		 System.out.println(result);
	        		 break;
	        case '3':System.out.println("Enter the Strings separated by space");
			 		 List<String> words1 = Arrays.asList(input.readLine().trim().split(" "));		 
			 		 List<String> pallindrome = pallindromeList(words1,App::isPallindrome);
			         System.out.println(pallindrome);
			         break;
			default:System.out.println("Wrong Input");
	        }
	        System.out.println("Do you want to continue");
	        c = input.readLine().trim().charAt(0);
	        if(c=='N' || c=='n')
	        	break;
        }while(true);
    }
    //Function which returns average of List of Integer
    public static double averageOfList(List<Integer> numberList) {
    	return numberList.stream().mapToInt(Integer::intValue).sum()/numberList.size();
    }
    // Function which returns List of Strings which start with 'a' and are of length=3
    public static List<String> stringsWithA(List<String> listOfStrings, Predicate<String> predicate){
		return listOfStrings.stream().filter(predicate).collect(Collectors.toList());
	}
    // Function to check whether a string is pallindrome or not
    public static boolean isPallindrome(String word) {
    	for(int i=0;i<word.length()/2;i++) 
    		if(word.charAt(i)!=word.charAt(word.length()-i-1))
    			return false;
    	return true;
    }
    // Function which returns a list of strings which are pallindrome
    public static List<String> pallindromeList(List<String> listOfStrings, Predicate<String> predicate){
		return listOfStrings.stream().filter(predicate).collect(Collectors.toList());
	}
	
} 
