package stackandqueue;

public class queuefromarray {
    int[] arr = new int[10];
    int front=0;
    int size=0;
    public queuefromarray(int capacity){
        arr = new int[capacity];
    }
    public void enqueue(int data)throws Exception{
        if (size==arr.length){
            throw new Exception("queue full");
        }
        this.arr[(front+size)%arr.length]=data;
        this.size++;
    }
    public int deque () throws Exception{
        if(this.size==0){
            System.out.println("queue empty");
        }
        int a = this.arr[front];
        this.arr[front]=0;
        this.front=(this.front+1)%this.arr.length;
        size--;
        return a;
    }
    public int getFront(){
        return this.arr[front];
    }
    public boolean isempty(){
        return this.size==0;
    }
    public void print(){
        for(int i=0;i<this.size;i++){
            System.out.print(arr[(front+i)%this.arr.length]+" => ");
        }
    }


}
