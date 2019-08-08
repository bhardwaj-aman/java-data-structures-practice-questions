package Graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class Heap<T extends Comparable<T>> {
    HashMap<T,Integer> indices = new HashMap<>();
    private ArrayList<T> data;
    Heap(){
        data = new ArrayList<T>();
    }
    public void add(T i){
        data.add(i);
        int x= data.size()-1;
        indices.put(i,x);
        upheapify(x);
    }
    public boolean isEmpty(){
        return data.isEmpty();
    }
    public void swap(int i,int j){
        T v1= data.get(i);
        T v2 = data.get(j);
        data.set(i,v2);
        data.set(j,v1);
        indices.put(v1,j);
        indices.put(v2,i);
    }
    public T delete(){
        swap(0,data.size()-1);
       T n= data.remove(data.size()-1);
        downhealpify(0);
        indices.remove(n);
        return n;
    }
    public void downhealpify(int i){
        int v1=(2*i)+1;
        int v2 = v1+1;
        if(v2>=data.size()){
            return;
        }
        if(data.get(i).compareTo(data.get(v1))>0||(data.get(i).compareTo(data.get(v2))>0)){
            if(data.get(v2).compareTo(data.get(v1))<0){
                swap(i,v2);
                downhealpify(v2);
            }else {
                swap(i,v1);
                downhealpify(v1);
            }
        }
    }
    public void upheapify(int x){
        int p= (x-1)/2;
        if(p<0){
            return;
        }
        if(isGreater(data.get(p),data.get(x))>0){
            T temp = data.get(p);
            data.set(p,data.get(x));
            data.set(x,temp);
            upheapify(p);
        }else {
            return;
        }
    }
    public void display(){
        System.out.println(data);
    }
    public int isGreater(T i,T j){
        return i.compareTo(j);
    }
     public void updatePriority(T i){
        int a = indices.get(i);
        upheapify(a);
     }
    public static void main(String[] args){
        Heap h = new Heap();
        h.add(10);
        //   h.display();
        h.add(20);
        //  h.display();
        h.add(30);
        //   h.display();
        h.add(40);
        //   h.display();
        h.add(5);
        //  h.display();
        h.add(3);
        //  h.display();
        h.delete();
        h.delete();
        h.delete();
        h.display();
    }

}
