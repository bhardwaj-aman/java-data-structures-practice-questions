package GraphsRevision;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int[][] a  =
                {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};
        int i = s.nextInt();
        int j = s.nextInt();
        int f1 = s.nextInt();
        int f2 = s.nextInt();
       // System.out.println(" a size: "+a.length+" "+a[0].length);
        System.out.println(ShortestIntPath(a,i,j,f1,f2));

    }
    private static class pair  {
        int i;
        int j;
        pair() {
            this.i = this.j = 0;
        }
        pair(int i,int j){
            this.i=i;
            this.j=j;
        }
        public String toString(){
            return ""+i+","+j+"";
        }
    }
    public static int ShortestIntPath(int[][]maze,int i,int j,int f1,int f2){
        Queue<pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        pair p = new pair(i,j);
        String f = "";
        int ans=0;
        q.add(p);
        while (!q.isEmpty()){
            pair x = q.remove();
            System.out.println(" x is: "+x);
            if(x.i==f1&&x.j==f2){
                break;
            }

            f+=" ["+x.i+","+x.j+"]";
visited[i][j]=true;
                if (x.i + 1 < maze.length && maze[x.i + 1][x.j] == 1) {
                    pair p1 = new pair(x.i + 1, x.j);

                    if(!visited[p1.i][p1.j]) {
                        q.add(p1);
                        ans++;
                        System.out.println(" 1-added: "+p1);
                        visited[p1.i][p1.j]=true;
                    }

                }
                if (x.j + 1 < maze[0].length && maze[x.i][x.j + 1] == 1) {
                    pair p1 = new pair(x.i, x.j + 1);
                    if(!visited[p1.i][p1.j]) {
                        q.add(p1);
                        ans++;
                        System.out.println("2- added: " + p1);
                        visited[p1.i][p1.j]=true;
                    }

                }
                if (x.i - 1 >= 0 && maze[x.i - 1][x.j] == 1) {
                    pair p1 = new pair(x.i - 1, x.j);
                    if(!visited[p1.i][p1.j]) {
                        q.add(p1);
                        ans++;
                        System.out.println(" 3- added: " + p1);
                        visited[p1.i][p1.j]=true;
                    }
                }
                if (x.j - 1 >= 0 && maze[x.i][x.j - 1] == 1) {
                    pair p1 = new pair(x.i, x.j - 1);
                    if(!visited[p1.i][p1.j]) {
                        q.add(p1);
                        ans++;
                        System.out.println("4- added: " + p1);
                        visited[p1.i][p1.j]=true;
                    }
            }

        }
        System.out.println(f);
        return ans;
    }
    public static int shortestMazePath(int[][] maze,int i,int j,int f1,int f2,int ans,String f){
        f+="["+i+","+j+"]";
        if(i==f1&&j==f2){
            ans++;
            System.out.println(" match- ans is: "+ans);
            System.out.println(f);
            return ans;
        }
        if (i<0||j<0||i >= maze.length||j>=maze[0].length||maze[i][j]==0) {
            return 0;
        }
        maze[i][j]=0;
        int l = shortestMazePath(maze,i,j+1,f1,f2,ans,f);
       int n =  shortestMazePath(maze,i+1,j,f1,f2,ans,f);
        int u = shortestMazePath(maze,i-1,j,f1,f2,ans,f);
        int d = shortestMazePath(maze,i,j-1,f1,f2,ans,f);
         maze[i][j]=1;

         return l+u+n+d;

    }
}
