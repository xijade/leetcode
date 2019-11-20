package model;

public class Test {
	 public static void main(String[] arg){
		 Bag<Integer> bag = new Bag();
		 bag.add(2);
		 bag.add(5);
		 bag.add(9);
		 for(Integer i : bag) {
			 System.out.println(i);
		 }
		 double a = 0.00000000001;
		 double b = 0.00000000000001;
		 System.out.print(a+b == 0);
		 
	 }
}
