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
        int hash = hashFunc(key);
        int index = hash % size;
        entiries[index] = new KeyValuePair(key, value);
        numberOfElements++;
        if(numberOfElements == size){
            resize(size * 2);
        }
    }

    public void resize(int newSize){
        KeyValuePair[] newEntries = KeyValuePair[newSize];
        for(int i=0;i<size;i++){
            KeyValuePair entry = entiries[i];
            int hash = hashFunc(entry.key);
            int index = hash % newSize;
            newEntries[index] = entry;
        }
        entiries = newEntries;
        size = newSize;

    }

    public String get(String key){
        int hash = hashFunc(key);
        int index = hash % size;
        KeyValuePair entry = entiries[index];
        if(entry == null){
            return null;
        }
        return entry.value;
    }
}