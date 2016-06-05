/**
 * 
 */
package java2Asignment1;

 

public abstract class resource 
{
    //instance variables
    private String resourceID; //ID of the resource
    private String resourceName; //name of the resource
    private double cost; //the cost of the resource
    
    //constructor without arguments
    public void Resource()
    {
        resourceID="unknown";   
        resourceName="unknown";
        cost = 0;
    }
    // arguments
    public resource(String resourceID,String resourceName, double resourceCost)
    {
        setResourceID(resourceID);
        setName(resourceName);
        setCost(resourceCost);
    }
    
    public void setResourceID(String resourceID)
    {
        this.resourceID = resourceID;
    }
    public void setName(String resourceName)
    {
        this.resourceName = resourceName;
    }
    public void setCost(double resourceCost)
    {
        this.cost = resourceCost;
    }

    public String getresourceID()
    {
        return resourceID;
    }
    public String getresourceName()
    {
        return resourceName;
    }
   public double getCost()
    {
        return cost;
    }

    public String toString()
    {
        return "Resource ID: " + this.getresourceID()+"\t" + "Resource Name: " + this.getresourceName() +"\t" + "Resource Cost: " + this.getCost() + "\t";
    }
    public abstract void applyTo(site s);
}

	



	