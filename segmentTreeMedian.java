import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Cs4 {
static int[] ar;
static int[] ad;
static int count=0;
static int[] segmentTree=new int[3000005];
static int max_elem=1000000;
static int findKth(int node, int a, int b, int k)
{
   
    if (a != b)
    {
       
        if (segmentTree[node*2] >= k)
            return findKth(node*2, a, (a + b)/2, k);
 
        return findKth(node*2 + 1, (a + b)/2  + 1,
                       b, k - segmentTree[node*2]);
    }
 
    
    return (segmentTree[node]>=1)? a : -1;
}
 
static void update(int node, int a, int b, int x, int diff)
{
    
    if (a == b && a == x )
    {
       
        segmentTree[node] += diff;
        return ;
    }
 
  
    if (x >= a && x <= b)
    {
       
        update(node*2, a, (a + b)/2, x, diff);
        update(node*2 + 1, (a + b)/2 + 1, b, x, diff);
 
       
        segmentTree[node] = segmentTree[node*2] +
                            segmentTree[node*2 + 1];
    }
}

static void insert(int x)
{
    update(1, 0, max_elem, x, 1);
}
 
// delete x from the set
static void delet(int x)
{
    update(1, 0, max_elem, x, -1);
}
 
// returns median element of the set with odd
// cardinality only
static int median(int k)
{
    //int k = (segmentTree[1] + 1) / 2;
    return findKth(1, 0, max_elem, k);
}
//
    public static void main(String[] args) throws IOException{
  
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       
       StringTokenizer st=new StringTokenizer(br.readLine());
       
       int n=Integer.parseInt(st.nextToken(" "));
       int d=Integer.parseInt(st.nextToken(" "));
       
        ar=new int[n];
          int x=0;
          int temp=0;
        st=new StringTokenizer(br.readLine());
        ar[0]=Integer.parseInt(st.nextToken(" "));
        temp=ar[x];
        insert(temp);
       for(int i=1;i<n;i++){
           ar[i]=Integer.parseInt(st.nextToken(" "));  
          insert(ar[i]);
          if(i>=d){
             
              double P=0;
              if(d%2==0){
              P=(median(segmentTree[1]/2) +median((segmentTree[1]+1)/2));
              P=P/2;
              }else{
                  P=median((segmentTree[1]+1)/2);
              }
            
           
            if(ar[i]>=(2*P)){
           count++;
         }
              delet(temp);
              temp=ar[++x];
          }
       }
      
       System.out.println(count);
    
}
}
