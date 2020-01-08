package CodesquadCS.DataStructure.HashMap;

public class HashMap {
    private static final int BUCKET_SIZE = 100;
    Entry[] bucketList = new Entry[BUCKET_SIZE];
    int size = 0;

    public int makeHash (String key) {
        int index;
        int result = 0;
        final int PRIME_NUMBER = 7;

        for (index = 0; index < key.length(); index++) {
            result += result * PRIME_NUMBER + key.charAt(index);
        }
        return result % BUCKET_SIZE;
    }

    public String put (String key, String value) {
        int index = makeHash(key);

        String oldValue = replace(key, value);
        if(oldValue == null){
            Entry newEntry =  new Entry(index, key, value, null);
            size++;
            if (bucketList[index] == null) {
                bucketList[index] = newEntry;
                return oldValue;
            }
            Entry prevEntry = bucketList[index];
            newEntry.setNext(prevEntry);
            bucketList[index] = newEntry;
        }
        return oldValue;
    }

    // 인덱스에 entry가 없거나 똑같은 키값을 가진 entry가 없다면 null 출력
    public String replace(String key, String newValue){
        int index = makeHash(key);
        Entry pointer = bucketList[index];
        if (pointer == null) {
            return null;
        }
        while(pointer != null){
            if (key.equals(pointer.getKey())) {
                String oldValue = pointer.getValue();
                pointer.setValue(newValue);
                return oldValue;
            }
            pointer = pointer.getNext();
        }
        return null;
    }

    // 값이 있는 키값이 오거나 값이 없는 키값(에러)가 오는 경우가 있다.
    public String get(String key){
        int index = makeHash(key);
        Entry pointer = bucketList[index];
        if (pointer == null) {
            return null;
        }
        while(pointer != null){
            if (key.equals(pointer.getKey())) {
                String valueOfSearching = pointer.getValue();
                return valueOfSearching;
            }
            pointer = pointer.getNext();
        }
        return null;
    }

    public boolean containsKey(String key){
        return get(key) != null;
    }

    public String remove(String key){
        int index = makeHash(key);
        Entry pointer = bucketList[index];
        Entry preEntry = null;

        if (pointer == null) {
            return null;
        }
        while(pointer != null){
            if (key.equals(pointer.getKey())) {
                size--;
                String valueOfSearching = pointer.getValue();
                if(preEntry == null){ // 지우려는 키 값이 맨 앞인 경우
                    bucketList[index] = pointer.getNext();
                } else{ // 지우려는 키 값이 중간인 경우
                    preEntry.setNext(pointer.getNext());
                }
                return valueOfSearching;
            }
            // 포인터를 앞으로 이동하고 prev를 지정하는 코드
            preEntry = pointer;
            pointer = pointer.getNext();
        }

        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        if (size > 0) {
            size = 0;
            for (int index = 0; index < bucketList.length; index++) {
                bucketList[index] = null;
            }
        }
    }

    public String[] keys() {
        String[] keys = new String[size];
        if (size > 0) {
            int index = 0;
            for (Entry entry : bucketList) {
                if (entry == null) {
                    continue;
                } else {
                    while(entry != null) {
                        String key = entry.getKey();
                        keys[index++] = key;
                        entry = entry.getNext();
                    }
                }
            }
        }
        return keys;
    }
}
