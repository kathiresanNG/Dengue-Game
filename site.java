package java2Asignment1;

import java.util.*;
/**
 * The <code>Site</code> represents a potential dengue site to be used
 * in the DengueFighter game.The sites are created with randomly 
 * generated values for the attributes.A constant is used for the 
 * infection rate.Current infection rate used is 0.15 - 0.27
 * 
 * @author Kathiresan
 * 
 */
public class site {
     
    /**
     *
    */
    private static final double INFECTRATE = 0.25;
    
    /**
     * Random number generator to set up a site, using {@link Random}
     */
    private static Random randomGenerator = new Random();
   
    /** attributes, refer to class diagram given */
    private String siteID;
    private int population;
    private double revenuePerWorker;
    private Grade cleanliness;
    private boolean hasAedes;
    private int numInfected;
    
    /** A site has a collection of ResourceUsage */
    private ArrayList<ResourceUsage> resourceUsage;
    // You need to add this
    
    /** A static variable used to auto-generating siteID */
    private static int nextNo = 100; 
    
    /**
     * Only constructor without arguments provided.A {@link Random} object is used to automatically generate random 
     * values for some of the various attributes.
     * 
     */
    
    
    public site()
    {
        siteID = "S" + nextNo++;
           
        // population is between 500 and 1000 
        population = 501 + randomGenerator.nextInt(2000);
        
        // average revenue earned by each uninfected member of the population
        // between $0.1 and $1 per week
        revenuePerWorker = randomGenerator.nextDouble()+0.1;
        
        // cleanliness is randomly determined
        cleanliness = Grade.getRandomGrade();
        
        // randomly determine if the site has aedes
        calculateAedesByCleanliness();
       
        // first assume nobody is infected
        numInfected = 0;
        
        // update number infected based on cleanliness and presence of Aedes
        updateInfections();
        
        // initialize ArrayList for ResourceUsage
        resourceUsage=new ArrayList<>();
        // You need to do this
    }
    
    public void UsedResourceForWeek(int weekNo)
    { 
    	for (ResourceUsage rU:resourceUsage) 
    	{ 
    		if (rU.getWeekNo() == weekNo)
    		{
    			for (int ind=0; ind<rU.getNumUnitsPurchased();ind++)
    			{
    				rU.getResource().applyTo(rU.getSite());
    			}
    		}
    	} 
    }
    
    
    public void addResourceUsage (resource r, int numUnits, int weekNo, site s) 
    { 
    	ResourceUsage nr = new ResourceUsage(weekNo, numUnits, r, s); 
    	resourceUsage.add(nr);   	
    }
    
    public boolean resourceUsed(resource r, int weekNo)
    {
    	for (ResourceUsage rU:resourceUsage)
    	{
    		if (rU.getWeekNo()==weekNo && rU.getResource()==r)
    			return true;
    	}
    	return false;
    }
    /**
     * The siteID uniquely identifies the site.Starts with "S".
     * @return the siteID of the site
     */
    public String getSiteID() {
        return siteID;
    }
    /**
     * Returns population of the site.Assume that the population, once generated, remains the same. 
     * @return the population of the site
     */
    public int getPopulation() {
        return population;
    }

    
    /**
     * Returns the number of infected people in the population.People who are infected
     * will not be included in the calculation of the revenue.
     * @return the current number of infected people in the population
     */
    public int getNumInfected() {
        return numInfected;
    }

    /**
     * Set the number of people infected in the population.
     * @param numInfected the number of infected people to set
     */
    public void setNumInfected(int numInfected) {
        this.numInfected = numInfected;
    }

    /**
     * Cleanliness is graded by enum type {@link Grade}
     * @return the current cleanliness grade of the site.
     */
    public Grade getCleanliness() {
        return cleanliness;
    }

    /**
     * Returns whether the Site has Aedes or not.You may want to make it private
     * @return true if the site has Aedes, false otherwise
     */
    public boolean HasAedes() {
        return hasAedes;
    }

    /**
     * This method is used to reset the cleanliness value of the population.Cleanliness values take on the enum type  {@link Grade}
     * 
     * @param cleanliness the cleanliness grade to be set. 
     */
    public void setCleanliness(Grade cleanliness) {
            this.cleanliness = cleanliness;
    }

    /**
     * Reset the hasAedes value to true if Aedes is present, false otherwise.
     * @param hasAedes to be set whether true or false
     */
    public void setHasAedes(boolean hasAedes) {
       
            this.hasAedes = hasAedes;
    }
     
    /**
     * This method sets the hasAedes attribute based on the idea
     * that a site has Aedes is 50% chance and 50% based on the
     * cleanliness of the site.
     * 
     */
    private void calculateAedesByCleanliness()
    {
        // assign weights to cleanliness and probability
        final double PROBABILITYWEIGHT = 0.50;  // normal probability affects 50%
        final double CLEANLINESSWEIGHT = 0.50;  // cleanliness affects 50%
        
        double cleanScore = cleanliness.getMultiplier()/5;
        double probability = randomGenerator.nextDouble();
        
        // determine probability based on weights assigned

        
       double totalProbability = cleanScore*CLEANLINESSWEIGHT + probability*PROBABILITYWEIGHT;
       setHasAedes(totalProbability < 0.5);
         
    }
    
    /**
     * Get the weekly revenue of uninfected workers, which is the 
     * product of the revenue per worker and the number of the uninfected population
     * @return the revenue of workers who are not infected
     */
    public double getRevenue()
    {
        return revenuePerWorker * (population - numInfected);
    }
    
    
    @Override
    /**
     * toString() method returns the Site status as a String
     * @return the site information
     */
    public String toString()
    {   
         return siteID + " : Cleanliness " + cleanliness  +
                "\nPopulation : " + population + 
                "\nRevenue Per Worker : " + String.format("$%.2f",revenuePerWorker) +  
                "\nNum Infections : " + numInfected + 
                "\nhas Aedes : " + hasAedes +"\n";
                
    }
    
    /**
     * A method to review the resources used by the site as stored in the ResourceUsage
     * ArrayList.
     * @return a String containing a list of all the resources used for the site so far. 
     */
    // You need to write this method
    public String showAllResourceUsage(int weekNo)
   {
       String allResourceUsage = "\n";
       for (int i =0; i < resourceUsage.size(); i++)
       {
    	   if (resourceUsage.get(i).getWeekNo()==weekNo)
    		   allResourceUsage +=resourceUsage.get(i).getSite().getSiteID()+" "+resourceUsage.get(i).toString()+ "\n";
       }
       if (allResourceUsage.equals("\n"))
    	   return "";
       else
    	   return allResourceUsage;
   }
    
    /**
     * A method to update the number of infected people.The probability of infection is calculated
     * based on:
     * <ul> 
     *  <li>whether there is Aedes present </li>
     *  <li>the infection rate </li>
     *  <li>the number of people currently infected</li>
     *  <li>the cleanliness of the site</li>
     * </ul>
     * This method should be called at the beginning of each week.
     */
    public final void updateInfections()
    {
        // probability of infection depends inversely on cleanliness
        // and the proportion of people already infected
       if (hasAedes)    // if aedes still present, recalculate infections
       {
            double probability = (1.0/cleanliness.getMultiplier()) * (((double) numInfected)/population + 1);
            int newInfections = (int) (0.15 * probability * (population - numInfected) );
            // update infection rate
            numInfected += newInfections;  
       }
       else // no aedes, update hasAedes based on cleanliness
       {
            calculateAedesByCleanliness();
       }
      
       
    }
    
  
    /**
     * The average revenue per worker is randomly generated 
     * when the site is instantiated.
     * @return the average revenue per worker
     */
    public double getRevenuePerWorker() {
        return revenuePerWorker;
    }

    /**
     * The revenue per worker can be recalculated if productivity decreases.(Productivity is affected by the toxicity of pesticides)
     * 
     * @param revenuePerWorker the revenuePerWorker to set
     */
    public void setRevenuePerWorker(double revenuePerWorker) {
       if (revenuePerWorker > 0)
        this.revenuePerWorker = revenuePerWorker;
    }
  }
    
    
    /**
     * 
     * A method to record the usage of a resource at this site.A resourceUsage
     * is created and added to the collection, if the resource  has not 
     * already been added for the week.
     * @param r the resource to be added
     * @param numUnits the number of units of resource 
     * @param weekNo the week number that the resource is added
     * @return true if the resource is added successfully
     */
    
