package java2Asignment1;
/**
 * 
 * @author Kathiresan
 *this is the class to get the number of units purchased and the weekly number in the game  
 */
public class ResourceUsage {
	private int WeekNo;
	private int numUnitsPurchased;
	private resource Resource;
	private site site; 
	
	public ResourceUsage(int weekNo, int numUnitsPurchased, resource resource, site site){
		this.WeekNo=weekNo;
		this.numUnitsPurchased=numUnitsPurchased;
		this.Resource=resource;
		this.site=site;
	}
	
	public resource getResource() {
		return Resource;
	}

	public void setResource(resource resource) {
		this.Resource = resource;
	}

	public site getSite() {
		return site;
	}

	public void setSite(site site) {
		this.site = site;
	}

	public int getWeekNo() {
		return WeekNo;
	}

	public void setWeekNo(int weekNo) {
		WeekNo = weekNo;
	}

	public int getNumUnitsPurchased() {
		return numUnitsPurchased;
	}

	public void setNumUnitsPurchased(int numUnitsPurchased) {
		this.numUnitsPurchased = numUnitsPurchased;
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "resource + WeekNo =" + WeekNo + ", numUnitsPurchased ="
				+ numUnitsPurchased;
	}
        
}