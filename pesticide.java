package java2Asignment1;
import java.util.*;


/**
 * 
 * @author Kathiresan
 * assign resource to the site;
 * 
 */
public class pesticide extends resource
{
   
    private Grade toxicity;
    private Grade effectiveness;
    private Grade cleanliness;

    
    public pesticide(String resourceID, String resourceName, int cost, Grade toxicity, Grade effectiveness)
    {
        super(resourceID, resourceName, cost);
        
        setToxicity(toxicity);
        
        setEffectiveness(effectiveness);
    }
    /**
     * to get the getter and setter method;
     * @return
     */
    public Grade getToxicity() 
    {
        return toxicity;
    }
  
    public void setToxicity(Grade toxicity) 
    {
        this.toxicity = toxicity;
    }

    
    public Grade getEffectiveness() 
    {
        return effectiveness;
    }

    public void setEffectiveness(Grade effectiveness) 
    {
        this.effectiveness = effectiveness;
    }

    @Override
    public String toString() 
    {
        return super.toString() + String.format("%s\t\t%s\n", toxicity, effectiveness);
    }
    
    @Override
    public void applyTo(site s)
    {
        Random randomGenerator = new Random();   
        final double PROBABILITYWEIGHT = 0.50;  // normal probability affects 50%
        final double CLEANLINESSWEIGHT = 0.50;  // cleanliness affects 50%
        
        double cleanScore = cleanliness.getMultiplier()/5;
        double probability = randomGenerator.nextDouble();
        
        // determine probability based on weights assigned
       double totalProbability = cleanScore*CLEANLINESSWEIGHT + probability*PROBABILITYWEIGHT;
       
      s.setHasAedes(totalProbability < 0.5);
        
    }

}

