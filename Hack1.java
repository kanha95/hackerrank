
package hack1;

import java.util.*;

public class Hack1 {

    
    public static void main(String[] args) {
           Scanner sc=new Scanner(System.in);
        
        String s=sc.nextLine();
        
        int t=s.length();
        
        int r= (int)Math.floor(Math.sqrt(t));
        int c=(int)Math.ceil(Math.sqrt(t));
        
        for(int j=0;j<c;j++){
      for(int i=j;i<t;i=i+c){
         if(i<t)
          System.out.print(s.charAt(i));
      }
      System.out.print(" ");
        }
    }
    
}
