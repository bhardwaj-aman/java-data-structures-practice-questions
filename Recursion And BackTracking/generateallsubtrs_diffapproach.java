package RECURSIONPRACTICE;

public class generateallsubtrs_diffapproach {
    public static void main(String[] args){
        int c=0;
        genall("abc","",c);
    //    System.out.println(c);
    }
    public static void genall(String s, String res,int counter){
        if (s.length()==0){
            System.out.println(res);

            counter++;
           // System.out.println(counter);
        }
        for(int i=0;i<s.length();i++){
            String c = s.substring(i,i+1);
            String str = s.substring(0,i)+s.substring(i+1);
            genall(str,res+c,counter);
          //  genall(s,res+c);
        }
    }
}
