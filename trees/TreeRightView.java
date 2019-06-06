package treepractice;
        import java.util.*;
public class TreeRightView {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        String[] a = str.split(" ");
        int i=1;
        while(true){
            if((int)(Math.pow((double)2,(double)i))-2>a.length-1){
                break;
            }
     //       System.out.println("2^i is: "+(int)(Math.pow((double)2,(double)i)-2));
            int x=(int)(Math.pow((double)2,(double)i))-2;
            int y=x-(int)(Math.pow((double)2,(double)(i-1)));
            if((a[x].equals("-1"))==false){
                System.out.print(a[x]+" ");
            }else {
                for(int j=x;j>=y;j--){
                    if((a[j].equals("-1")==false)&&(j>0)){
                        System.out.println(a[j]);
                        break;
                    }
                }
            }
            i++;
        }
    }
}
//1 2 3 4 5 6 7 -1 9 -1 8 -1 -1 -1 -1 -1
