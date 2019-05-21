package RECURSION;

public class countmazepathdiag {
    public static void main(String[] args){
        System.out.println(countmzpath(0,0,2,2));
    }
    public static int countmzpath(int sh,int sv, int eh, int ev){
        if ((sh==eh) && (sv==ev)){
            return 1;
        }
        if((sh>eh)||(sv>ev)){
            return 0;
        }
        int count=0;
       count+= countmzpath(sh+1,sv,eh,ev);
       count+= countmzpath(sh,sv+1,eh,ev);
        count +=countmzpath(sh+1,sv+1,eh,ev);
        return count;
    }
}
