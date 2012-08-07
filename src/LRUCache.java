import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Implementation of simple LRU cache using LinkedHashMap. It provides a 
 * constant time access O(1) with insertion order.
 * 
 * K - The type of Keys maintained by this cache
 * V - The type of values maintained by this cache
 * 
 * @author chandershivdasani
 *
 */
public class LRUCache<K,V> {
	
	LinkedHashMap<K,V> cache;
	protected static int size;
	
	public LRUCache() {
		this(100);
	}
	
	public LRUCache(final int size) {
		this.size = size;
		
		cache = new LinkedHashMap<K,V>(size, 0.75f, true) {
			//Return true when LinkedHashMap should delete its eldest
			//entry
			protected boolean removeEldestEntry(Map.Entry eldest) {
				return size() > size;
				
			}
		};
	}
	
	public void insert(K key, V value) {
		cache.put(key, value);
	}
	
	public V get(K key) {
		return cache.get(key);
	}
	
}
