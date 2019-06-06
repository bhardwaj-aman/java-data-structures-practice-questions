package stackandqueue;

public class stackfromarray {
    int [] array;
   public int top=-1;
    stackfromarray(){
       this.array =new int[10];
       this.top=-1;
    }
    stackfromarray(int capacity){
        this.array = new int[capacity];
        this.top=-1;
    }
    public int size(){
        return this.top+1;
    }
    public int top() throws Exception {
        if(top==-1){
            throw new Exception("stack empty");
        }
        return this.array[top];
    }
    public void push(int e) throws Exception {
      /*  if(top==array.length){
            this.top--;
        }*/
        if((top==array.length)){
            throw new Exception("Stack overflow");
        }
        this.top++;
       this. array[top]=e;


    }
    public int pop() throws Exception {
        if(top==-1){
            throw new Exception("stack empty");
        }
       // System.out.println(top);
        int n = this.array[top];

        this.array[top]=0;
        this.top--;
        return n;
    }
    public  void reverseit  (stackfromarray s,stackfromarray h,int n,int r) throws Exception {
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

    public boolean isempty(){
        return top==-1;
    }
    public void print(){
        for(int i=top;i>=0;i--){
            System.out.print(this.array[i]+" => ");
        }
      //  System.out.println("");
    }
}
