package radar;

public class Base64 {
		    public static void main(String[] args) {  
				/*
				 * int n1=0,n2=1,num; for (int i=1;i<=5;i++) { System.out.print(n1); num =
				 * n1+n2; n1 = num ; n2 = n1; }
				 */
				/*
				 * int n= 5,m = 10; n = n+m; m=n-m; n=n-m; System.out.println(n+""+m);
				 */
				/*
				 * int n = 5,fact=1; for(int i=1;i<=5;i++) { fact = fact*i; }
				 * System.out.println(fact); for(char j ='A';j<='Z';j++) { System.out.print(j);
				 * }
				 */
		    	/*int count=0;
		    	String s = "SIVAKUMAR";
		    	char[] c  =s.toCharArray();
		    System.out.println(c.length+""+s.length());
		    	for(int i=0;i<=c.length;i++) {
		    		for(int j=i+1;j<=c.length;j++) {
		    			if (c[i]!=c[j]) {
		    				System.out.println(c[i]+" "+ "count");
		    				//System.out.println(count);
		    				break;
		    			}*/
		    	String s ="malayalam";
		    	StringBuilder st = new StringBuilder();
		    	st.append(s);
		    	st.reverse();
		    	if(st.toString().equals(s)) {
		    		System.out.println("pali");
		    	}else {
		    		System.out.println("not");
		    	}
	
	}

}
