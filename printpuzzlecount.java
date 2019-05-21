package RECURSION;

public class printpuzzlecount {
    public static  void main(String[] args){
        System.out.println(countpuzzle(0,0,2,2));
    }
    public static int countpuzzle(int sh,int sv,int eh,int ev){
       if((sh==eh) && (sv==ev)){
           return 1;
       }
        if((sh>eh)||(sv>ev)){
            return 0;
        }

        int count =0;
        count+=countpuzzle(sh+1,sv,eh,ev);
        count+=countpuzzle(sh,sv+1,eh,ev);
        return count;
    }
}
