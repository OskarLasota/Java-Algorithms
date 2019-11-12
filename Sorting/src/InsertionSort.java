
public class InsertionSort {

	
	
	
	public static void main(String[] args){
		
		//Integer[] list = {4,6,3,7,5,1,2,9,8};
			
		LispList<Integer> list2 = LispList.empty();
		list2 = list2.cons(4);
		list2 = list2.cons(6);
		list2 = list2.cons(3);
		list2 = list2.cons(7);
		list2 = list2.cons(5);
		list2 = list2.cons(1);
		list2 = list2.cons(2);
		list2 = list2.cons(9);
		list2 = list2.cons(8);
		System.out.println(list2);
		list2 = sort(list2);
		System.out.println(list2);
		
	}
	
	
	public static LispList<Integer> sort(LispList<Integer> list){
		LispList<Integer> ls2 = LispList.empty();
		//each time list.head gets inserted, tail is passed on until list is empty
		for(; !list.isEmpty(); list=list.tail()){
			ls2 = insert(list.head(), ls2);
		}
		return ls2;
				
	}


	private static LispList<Integer> insert(Integer head, LispList<Integer> list1) {
		LispList<Integer> temp = LispList.empty();
		for(; !list1.isEmpty() ; list1 = list1.tail()){
			Integer heade = list1.head();
			if(heade.compareTo(head) > 0)
				break;
			temp = temp.cons(heade);
		}
		list1=list1.cons(head);
		//add the smaller values in front of the list
		for(;!temp.isEmpty() ; temp = temp.tail()){
			Integer heade = temp.head();
			list1 = list1.cons(heade);
		}
		
		return list1;
	}
	
	
	
}
