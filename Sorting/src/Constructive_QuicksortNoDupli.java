import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Constructive_QuicksortNoDupli {

	//Generic method accepts any type
	public static <E extends Comparable<? super E>> List<E> sort(List<E> passedList){
		if(passedList.size() < 2){
			return passedList;
		}
		//here we use LinkedHashSet to delete duplicates
		LinkedHashSet<E> setlist = new LinkedHashSet<E>(passedList);
		List<E> list = new ArrayList<E>(setlist);
		
		List<E> smaller = new ArrayList<E>(); // empty list for one side of the list
		List<E> greater = new ArrayList<E>(); //empty list for other side of the list
		E pivot = list.get(0); // using first index as pivot will be very slow if list is already sorted
		
		//loops through the list to seperate list into two
		for(int i=1; i<list.size(); i++){
			E temp = list.get(i);
			if(temp.compareTo(pivot)<0)
				smaller.add(temp);
			else
				greater.add(temp);
		}
		//the two lists sort themselves
		smaller=sort(smaller);
		greater=sort(greater); 
		
		//return the final, fully sorted new list without affecting the passed on list
		smaller.add(pivot);
		smaller.addAll(greater);
		return smaller;
		
	}
	
	
	
	public static void main(String[] args){
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(3);
		list.add(10);
		list.add(22);
		list.add(5);
		list.add(3);
		System.out.println("current list : " +list);
		System.out.println("sorted list : " +sort(list));
		
	}
	
	
}