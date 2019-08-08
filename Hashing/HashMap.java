package HashMap;

public class HashMap<K,V> {
    private class HTpair{
        K key;
        V value;
        HTpair(K key, V value){
            this.key=key;
            this.value=value;
        }
        public boolean equals(Object other){
            HTpair op = (HTpair) other;
            return this.key.equals(op.key);
        }
        public String tosString(){
            return "{"+this.key+" ->"+this.value+"}";
        }
    }
    public static final int Default_Capacity=10;
    private genericLinkedList<HTpair>[] bucketArray;
    private int size;
    public HashMap(){
        this(Default_Capacity);
    }
    public HashMap(int capacity){
        this.bucketArray=(genericLinkedList<HTpair>[]) new genericLinkedList[capacity];

    }
    public void put(K key,V value) throws Exception{
        int bi = hashFunction(key);
        genericLinkedList<HTpair> bucket =this.bucketArray[bi];
        HTpair pta = new HTpair(key,value);
        if (bucket==null){
         bucket = new genericLinkedList<HTpair>();
         bucket.addlast(pta);
         this.bucketArray[bi] = bucket;
         this.size++;
         }else {
           int findAt = bucket.find(pta);
           if (findAt==-1){
               bucket.addlast(pta);
               this.size++;
           }else {
               HTpair pair = bucket.getAt(findAt);
               pair.value=value;
           }
        }
        double lambda = (this.size*1.0)%bucketArray.length;
        if(lambda>2.0){
           this.rehash();
        }
    }
    public void rehash() throws Exception {
        genericLinkedList<HTpair>[] old = this.bucketArray;
        this.bucketArray = (genericLinkedList<HTpair>[]) new genericLinkedList[2*old.length];
        this.size=0;
        for (genericLinkedList<HTpair> ll:old){
                   while (ll!=null&&(!ll.isEmpty())){
                       HTpair pair = ll.removefirst();
                       this.put(pair.key,pair.value);
                   }
        }
    }
    public V get(K key){
        int bi = hashFunction(key);
       genericLinkedList<HTpair> bucket = bucketArray[bi];
       HTpair pairToFind = new HTpair(key,null);
       if(bucket!=null){
           int index = bucket.find(pairToFind);
           if(index!=-1) {
               return bucket.getAt(index).value;
           }else {
               return null;
           }
       }else {
           return null;
       }

    }
    public V remove(K key) throws Exception {
        int bi = hashFunction(key);
        genericLinkedList<HTpair> bucket = bucketArray[bi];
        HTpair pairToFind = new HTpair(key,null);
        if(bucket!=null){
            int index = bucket.find(pairToFind);
            if(index!=-1) {
                this.size--;
                return bucket.removeaat(index).value;
            }else {
                return null;
            }
        }else {
            return null;
        }
    }
    public void display() throws Exception{
        for (genericLinkedList<HTpair> bucket:this.bucketArray ){
            if (!bucket.isEmpty()&&bucket!=null){
                bucket.display();
            }else {
                System.out.println("null");
            }
        }
    }
    private int hashFunction(K key){
        int hc = key.hashCode();
        hc = Math.abs(hc);
        int bi= hc%this.bucketArray.length;
        return bi;
    }
}
