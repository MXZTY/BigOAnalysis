public class HashTable {

    private Bucket[] table = new Bucket[5751113];

    public void add(String stringToAdd){
        int index = (int) (hashedValue(stringToAdd) % table.length);
        if (table[index] == null){
            Bucket bucketToAddTo = new Bucket();
            bucketToAddTo.add(stringToAdd);
            table[index] = bucketToAddTo;
        } else {
            table[index].add(stringToAdd);
        }
    }

    public void delete(String stringToDelete) {
        int index = (int) (hashedValue(stringToDelete) % table.length);
        if (table[index] != null){
            table[index].remove(stringToDelete);
        }
    }

    public void find(String stringToFind) {
        int index = (int) (hashedValue(stringToFind) % table.length);
        if (table[index] != null){
            table[index].find(stringToFind);
        }

    }
    public void printABucket(int index) {
       if(table[index] != null) {
         System.out.println(index);
         table[index].printIt();
       }
    }
    public void printSmallestBucket() {
        int smallestBucket = 10000;
        for(int i = 0; i < table.length; i++) {
            if (table[i]!= null){
                if (table[i].getsize() < smallestBucket) {
                    smallestBucket = table[i].getsize();
                }
            }
        }
        System.out.println("the size of the smallest bucket is: " + smallestBucket);
    }
    public void printLargestBucket() {
        int largestBucket = 0;
        for(int i = 0; i < table.length; i++) {
            if (table[i]!= null){

                if (table[i].getsize() > largestBucket) {
                    largestBucket = table[i].getsize();
                }
            }
        }
        System.out.println("the size of the largest bucket is: " + largestBucket);
    }
    public void printAvarageBucketSize() {
        int avarageSize = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i]!= null){
                avarageSize = avarageSize + table[i].getsize();
            }
        }
        avarageSize = avarageSize/table.length;
        System.out.println(avarageSize + " is the avarage size of the buckets");
    }



    public long hashedValue(String word) {
        long hashVal = 0;
        for (int i = 0; i < word.length(); i++) {
            hashVal = (hashVal * 31) + word.charAt(i);
        }
        if (hashVal < 0) {
            hashVal = hashVal * -1;
        }

        return hashVal;
    }


}
