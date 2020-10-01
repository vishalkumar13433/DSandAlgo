package ImpQuestion;

import java.util.Set;

public class CustomHashMap<K,V>{
	private Entry<K,V>[] table;
	private int capacity;
	
	static class Entry<K,V>
	{
		K key;
		V value;
		Entry<K,V> next;
		
		Entry(K key, V val)
		{
			this.key=key;
			this.value=val;
		}
	}
	
	
	CustomHashMap(int capacity)
	{
		this.capacity=capacity;
		table=new Entry[capacity];
	}
	
	
	public boolean containsKey(K key) {
		if(key==null)
			return false;
		int hash=key.hashCode();
		if(table[hash]==null)
			return false;
		Entry<K,V> prev=null;
		Entry<K,V> e = table[hash];
		while(e!=null)
		{
			if(e.key.equals(key))
				return true;
		}
		return false;
	}


	public V get(K key) {
		int hash=key.hashCode();
		if(table[hash]==null)
			return null;
		else
		{
			Entry<K,V> e = table[hash];
			while(e!=null)
			{
				if(e.key.equals(key))
					return e.value;
				e=e.next;
			}
		}
		return null;
	}

	public boolean isEmpty() {
		for(int i=0;i<this.capacity;i++)
		{
			if(table[i]!=null)
				return false;
		}
		return true;
	}

	public void put(K key, V val) {
		//doesn't handle null keys
		if(key==null)
			return;
		
		int hash=key.hashCode();
		Entry<K,V> newEntry=new Entry(key,val);
		
		if(table[hash]==null)
		{
			table[hash]=newEntry;
		}
		else
		{
			Entry<K,V> prev=null;
			Entry<K,V> e = table[hash];
			while(e!=null)
			{
				//if same key is already present
				if(e.key.equals(key))
					{
						System.out.println("Same Key encountered");
					
						if(prev==null)
						{
							//adding the mapping in table
							table[hash]=newEntry;
							
							//changing the current LinkedlIst
							newEntry.next=e.next;
							e.next=null;
						}
						else
						{
							prev.next=newEntry;
							newEntry.next=e.next;
						}
					}
				prev=e;
				e=e.next;
			}
			prev.next=newEntry;
		}
	}


	public  void remove(K key) {
		if(key==null)
			return;
		int hash=key.hashCode();
		if(table[hash]==null)
			return;
		Entry<K,V> prev=null;
		Entry<K,V> e = table[hash];
		while(e!=null)
		{
			if(e.key.equals(key))
			{
				if(prev==null)
					{
						table[hash]=e.next;
					}
				else
					{
						prev.next=e.next;
					}
				//e.next=null;
				
			}
			prev=e;
			e=e.next;
		}
		
	}


}
