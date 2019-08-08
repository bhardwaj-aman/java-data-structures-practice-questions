package GraphPractice;
import java.util.*;
public class SnakesAndLadders {
    static Scanner s = new Scanner(System.in);
        public  class vertex{
        HashMap<String ,Integer> neighbours;
            int status;
        vertex(){
            neighbours = new  HashMap<String ,Integer>();
            status=0;
        }
    }
    HashMap<String,vertex> vertices;
    SnakesAndLadders(){
        vertices = new HashMap<String, vertex>();
    }

    public int numvertex(){
        return vertices.size();
    }
    public boolean containsvertex(String a){
        for(String x:vertices.keySet()){
            if(x.equals(a)){
                return true;
            }
        }
        return false;
    }
    public void updatestatus(String x){
        vertices.get(x).status=2;
    }
    public void addvertex(String a){
        vertex v = new vertex();
        vertices.put(a,v);
    }
    public int numedges(){
        int counter=0;
        for(String x:vertices.keySet()){
            counter+=vertices.get(x).neighbours.size();
        }
        return counter/2;
    }
    public void display(){
        System.out.println("-----------");
        for(String x: vertices.keySet()){
            System.out.print(x+" : ");
            System.out.println(vertices.get(x).neighbours);
        }
        System.out.println("------------");
    }
    public void addedge(String a, String b,int i){
        vertex v1 = vertices.get(a);
        vertex v2 = vertices.get(b);
        if(v1==null||v2==null||v1.neighbours.containsKey(v2)){
            return;
        }
        v1.neighbours.put(b,i);
        v2.neighbours.put(a,i);
    }
    public void addOneSidededge(String a, String b,int i){
        vertex v1 = vertices.get(a);
        vertex v2 = vertices.get(b);
        if(v1==null||v2==null||v1.neighbours.containsKey(v2)){
            return;
        }
        v1.neighbours.put(b,i);
    }
    public boolean containsedge(String a,String b){
        for(String x:vertices.keySet()){
            if(x.equals(a)){
                if(vertices.get(x).neighbours.containsKey(b)){
                    return true;
                }
            }
        }
        return false;
    }
    private class pair{
        String a;
        String path;
    }

    public String bfs(String a) {
        int i = 0;
        int max = 0;
        pair p = new pair();
        p.a = a;
        p.path = a;
        LinkedList<pair> queue = new LinkedList<>();
        ArrayList<String> visited = new ArrayList<>();
        queue.addLast(p);
        while ((i <=6)&&(!queue.isEmpty())) {
            pair x = queue.removeFirst();
          //  System.out.println("removed : " + x.a);
            int j = Integer.parseInt(x.a);
       //     System.out.println(" j is: " + j);
            if (j > max) {
                max = j;
                //System.out.println(" max is: " + max);
            }
         //   System.out.println("visited is: " + visited);
            if (visited.contains(x.a)) {
                continue;
            }
            visited.add(x.a);
            for (String str : vertices.get(x.a).neighbours.keySet()) {
                if (!visited.contains(str) && (Integer.parseInt(str) > Integer.parseInt(x.a))) {
                    pair p1 = new pair();
                    p1.a = str;
                    p1.path = x.path + str;
           //         System.out.println("added : " + p1.a);
                    queue.addLast(p1);
                }
            }
            i++;
        }
        return max+"";
    }

public int SNL(){
        int counter=0;
        String x=1+"";
        while (Integer.parseInt(x)<vertices.size()){
           // System.out.println("bfs for: "+x+" is: "+bfs(x));
            x=bfs(x);
            counter++;
        }
        return counter;
}
public static int customSolution(){
        int cells=s.nextInt();
        int ladders = s.nextInt();
        int snakes = s.nextInt();
        SnakesAndLadders g = new SnakesAndLadders();
        for (int i=1;i<=cells;i++){
            g.addvertex(i+"");
        }
        for(int i=1;i<cells;i++){
            g.addedge(i+"",(i+1)+"",1);
        }
        for(int i=0;i<ladders;i++){
            int x = s.nextInt();
            int y = s.nextInt();
            g.addOneSidededge(x+"",y+"",1);
        }
        for (int i=0;i<snakes;i++){
            int x=s.nextInt();
            int y=s.nextInt();
            g.addOneSidededge(x+"",y+"",1);
            g.updatestatus(x+"");
        }
        int solution = g.SNL();
        return solution;
}
    public static void main(String[] args){
     int a = s.nextInt();
     for(int i=0;i<a;i++){
         System.out.println(customSolution());
     }
    }
}
