package stackandqueue;

public class reverse_stack_using_helper {
    public static void main(String[] args) throws Exception {
        stackfromarray s = new stackfromarray(5);
        for(int i=0;i<5;i++){
            s.push(69+i);
           System.out.println("pushed- top is: "+s.top+" and added no. is: "+(69+i));

        }
        stackfromarray h = new stackfromarray(5);
        reverseit(s,h,5,0);
     //   System.out.println("s is finally: ");
        s.pop();
        s.print();
    }
    public static void reverseit  (stackfromarray s,stackfromarray h,int n,int r) throws Exception {
        if(s.isempty()){
       //     System.out.println("s empty");
            return ;
        }

        int x = s.pop();
      //  System.out.println("popping "+ x);
        reverseit(s,h,n-1,r+1);
        h.push(x);
        if(r==0){
           // System.out.println("r is  0");
           // h.print();
            while (!h.isempty()){
                int z = h.pop();
              //  System.out.println("z is: "+z);
                s.push(z);
            }
        }
        r--;




    }

}