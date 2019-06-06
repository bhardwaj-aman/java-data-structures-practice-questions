package RECURSION;

public class printmazepathdiag {
    public static void main(String[] args){
 printmazepathdiag(0,0,2,2,"");
    }
    public static void printmazepathdiag(int sh,int sv, int eh, int ev,String s){
        if((sh==eh) && (sv==ev)){
            System.out.println(s);
            return;
        }
        if((sh>eh)||(sv>ev)){
            return;
        }
        printmazepathdiag(sh+1,sv+1,eh,ev,s+"D");
        printmazepathdiag(sh+1,sv,eh,ev,s+"H");
        printmazepathdiag(sh,sv+1,eh,ev,s+"V");


    }
}
