package stackandqueue;

public class nextgreaterelement {
    public static void main(String[] args) throws Exception {
        int[] a = new int[5];
        for(int i=0;i<3;i++){
            a[i]= 69+i;
        }
        a[3]=5;
        a[4]=34;
        nextgreater(a);
    }
    public static void nextgreater(int[] arr) throws Exception {
        stackfromarray s = new stackfromarray();
        for(int i=0;i<arr.length;i++){
            while(!s.isempty() && arr[i]>s.top()){
                System.out.println(s.top()+ " --> " +arr[i]);
                s.pop();
            }
            s.push(arr[i]);

        }
        while (!s.isempty()){
            System.out.println(s.pop()+" --> 0");
        }
    }
}
