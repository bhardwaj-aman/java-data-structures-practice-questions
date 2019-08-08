package DynamicPrograming;

public class Fibbonaci {
    public static long startsecond=0;
    public static long endsecond=0;
    public static void startAlgo(){
        startsecond = System.currentTimeMillis();
    }
    public static long endTimeMs(){
        endsecond  = System.currentTimeMillis();
        return endsecond-startsecond;
    }
    public static long fibonaciRecursive(int a,long[] arr){
        if(a==1){
            return a;
        }
        if (a==0){
            return a;
        }
        if(arr[a]!=0){
            return arr[a];
        }
        long fibb=fibonaciRecursive(a-1,arr)+fibonaciRecursive(a-2,arr);
        arr[a]=fibb;
        return fibb;
    }
    public static long fibonaciRecursiveNoDP(int a){
        if(a==1){
            return a;
        }
        if (a==0){
            return a;
        }
        long fibb=fibonaciRecursiveNoDP(a-1)+fibonaciRecursiveNoDP(a-2);
        return fibb;
    }
    public static long fibbonaciIterativeDp(int a,long[] arr){
       arr[0]=1;
       arr[1]=1;
       for (int i=2;i<a;i++){
           arr[i]=arr[i-1]+arr[i-2];
       }
        return arr[a];
    }
    public static void main(String[] args){
        long[] arr = new long[46];
        startAlgo();
        System.out.println(fibonaciRecursive(45,arr));
        System.out.println("DP  approach took: "+endTimeMs()+" ms");
      /*  startAlgo();
        System.out.println(fibonaciRecursiveNoDP(45));
        System.out.println("Normal  approach took: "+endTimeMs()+" ms");*/
        startAlgo();
        System.out.println(fibbonaciIterativeDp(45,arr));
        System.out.println("Itreative  approach took: "+endTimeMs()+" ms");
    }
}
