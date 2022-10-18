public class Hashmap {
    class KeyValuePair{
            public String key;
            public String value;
        
        public KeyValuePair(String key, String value){
            this.value = value;
            this.key = key;
        }
    }

    KeyValuePair[] entiries = new KeyValuePair[8];
    int size = 8;
    int numberOfElements = 0;

    int hashFunc(String key){
        return 0;
    }

    public void add(String key, String value){
        int index = findGoodIndex(key);
        entiries[index] = new KeyValuePair(key, value);
        numberOfElements++;
        if(numberOfElements == size){
            resize(size * 2);
        }
    }

    public void resize(int newSize){
        KeyValuePair[] newEntries = KeyValuePair[newSize];
        for(int i=0;i<size;i++){
            //loop for copy elements to new array
            KeyValuePair entry = entiries[i];
            int index = findGoodIndex(entiries[i]);
            newEntries[index] = entry;
        }
        entiries = newEntries;
        size = newSize;

    }

    public String get(String key){
        int index = findGoodIndex(key);
        if(index == null){
            return null;
        }
        KeyValuePair entry = entiries[index];
        if(entry == null){
            return null;
        }
        return entry.value;
    }

    public int findGoodIndex(String key){
        // for fix collision problem
        int hash = hashFunc(key);
        int index = hash % size;
        for(int i=0;i<size;i++){
            int probingIndex = (index + i) % size;
            KeyValuePair entry = entiries[probingIndex];
            if(entry == null || entry.key.equals(key)){
                return probingIndex;
            }
        return -1; 
        }

    }
}