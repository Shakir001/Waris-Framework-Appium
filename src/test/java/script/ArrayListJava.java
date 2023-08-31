package script;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListJava {

	public static void main(String[] args) {
		
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,7,8,9,9));
		
		LinkedHashSet<Integer> l = new LinkedHashSet<>(a);
		
		ArrayList<Integer> f = new ArrayList<>(l);
		System.out.println(f);
		
		 List<Integer> m = a.stream().distinct().collect(Collectors.toList());
		 System.out.println(m);
		 
		 
		 
		 
		 
		 
		 
		
	}
}

