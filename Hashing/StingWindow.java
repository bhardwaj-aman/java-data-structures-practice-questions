package HashingPractice;

import java.util.Scanner;

public class StingWindow {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        String b = s.nextLine();
        String c = b.charAt(0) + "";
        String d = b.charAt(b.length() - 1) + "";
  String min="";
  int minlength=Integer.MAX_VALUE;
      /*  for (int i = 0; i < (a.length() - b.length()); i++) {
            if ((a.charAt(i) + "").equals(c)) {
               // System.out.println("checking for i: "+i);
                int j = a.length() - 1;
                while (i <= j) {
                //    System.out.println("checking for: " + a.charAt(j));
                    if (!(a.charAt(j) + "").equals(d)) {
                        j--;
                    } else {
                       // System.out.println(a.substring(i, j)+d);
                        if(((a.substring(i, j)+d).length()<minlength)&&(contains((a.substring(i, j)+d),b))){
                            minlength = (a.substring(i, j)+d).length();
                            min=(a.substring(i, j)+d);
                        }
                        j--;
                    }
                }

            }

        }*/
      for(int i=0;i<a.length();i++){
          for (int j=i;j<a.length();j++){
          //    System.out.println(a.substring(i,j));
              if(((a.substring(i, j)).length()<minlength)&&(contains((a.substring(i, j)),b))){
                  minlength = (a.substring(i, j)).length();
                  min=(a.substring(i, j));
              }
          }
      }
       System.out.println(min);
    }
   public static boolean contains(String s1,String s2){
       for(int i=0;i<s2.length();i++){
           String c = s2.charAt(i)+"";
         if (charinString(s1,c)==false){
             return false;
         }
       }
       return true;
    }
    public static boolean charinString(String s,String c ){
        for (int i=0;i<s.length();i++){
            if ((s.charAt(i)+"").equals(c)){
                return true;
            }
        }
        return false;
    }
}
