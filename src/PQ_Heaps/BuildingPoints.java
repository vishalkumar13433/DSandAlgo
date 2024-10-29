package src.PQ_Heaps;

public class BuildingPoints implements Comparable<BuildingPoints>{
	int x,height;
	boolean isStart;
	

	@Override
	public int compareTo(BuildingPoints c) {
		if(this.x != c.x)
			return this.x - c.x;
		else
		{
			// return (this.isStart ? -this.height : this.height) - (c.isStart? -c.height : c.height);
			if(this.isStart && c.isStart)
			{
				return c.height - this.height;
			}
			else if(!this.isStart && !c.isStart)
			{
				return this.height - c.height;
			}
			return this.isStart?-1:1;
		}
	}
}
