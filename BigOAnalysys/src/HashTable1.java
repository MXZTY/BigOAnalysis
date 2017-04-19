/**
 * My hash table.
 * @author Austin
 *
 */
public class HashTable1 {
    Bucket[] table = new Bucket[16000057];

    public boolean add(String value) {
        boolean found = false;
        boolean done = false;
        int thisTry = 0;
        long hash = hash(value);
        int maxTries = table.length;
        while (!done && !found && thisTry < maxTries) {
            int index = probe(hash, thisTry);
            if (table[index] == null) {
                table[index] = new Bucket(value);
                done = true;
            } else if (table[index].isDeleted()) {
                table[index].setWord(value);
                done = true;
            } else if (table[index ].getWord().equals(value)) {
                found = true;
            } else {
                thisTry++;
            }
        }
        return done;
    }

    public boolean delete(String value) {
        boolean found = false;
        boolean done = false;
        int thisTry = 0;
        long hash = hash(value);
        int maxTries = table.length;
        while (!done && !found && thisTry < maxTries) {
            int index = probe(hash, thisTry);
            if (table[index] == null) {
                done = true;
            } else if (table[index].isDeleted()) {
                thisTry++;
            } else if (table[index].getWord().equals(value)) {
                found = true;
            } else {
                thisTry++;
            }
        }
        return found;
    }

    /**
     * Used to find a specific item in the hash table.
     * @param value the item you are looking for.
     * @return true if found, false if not found.
     */
    public boolean find(String value) {
        boolean found = false;
        boolean done = false;
        int thisTry = 0;
        long hash = hash(value);
        int maxTries = table.length;
        while (!done && !found && thisTry < maxTries) {
            int index = probe(hash, thisTry);
            if (table[index] == null) {
                done = true;
            } else if (table[index].isDeleted()) {
                thisTry++;
            } else if (table[index].getWord().equals(value)) {
                found = true;
            } else {
                thisTry++;
            }
        }
        return found;
    }

    public int probe(long hash, int curTry) {
        int index = (int) ((hash + (curTry * curTry)) % table.length);
        if (index < 0) {
            index = index * -1;
        }
        return index;

    }

    /**
     * A function to hash a string value into a specified integer
     * using the number value of each char, and adding them together.
     * @param value the string to be converted
     * @return the hashed value.
     */
    public long hash(String value) {
        long hashVal = 0;
        for(int i = 0; i < value.length(); i++) {
            hashVal = (hashVal * 31) + value.charAt(i);
        }

        return hashVal;
    }

    /**
     * The object of buckets.
     * @author Austin
     *
     */
    private class Bucket {
        private boolean deleted;
        private String word;

        /**
         * Crates a new bucket object.
         * @param newWord
         */
        public Bucket(String newWord) {
            this.setWord(newWord);
            this.setDeleted(false);
        }

        public boolean isDeleted() {
            return deleted;
        }

        public void setDeleted(boolean deleted) {
            this.deleted = deleted;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }


    }
}
