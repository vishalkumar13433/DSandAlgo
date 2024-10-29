package src.GraphTheory;

public class PQEntry implements Comparable<PQEntry>{
	Integer key;
	Integer value;
	
	public PQEntry(Integer key, Integer value) {
		this.key = key;
		this.value = value;
	}
	public Integer getKey() {
		return key;
	}
	public void setKey(Integer key) {
		this.key = key;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	@Override
	public int compareTo(PQEntry o) {

		return this.getKey().compareTo(o.getKey());
	}
	
}
