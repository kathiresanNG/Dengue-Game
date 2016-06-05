package java2Asignment1;

import java.util.*;
import static java2Asignment1.Grade.*;

/**
 * 
 * @author Kathiresan
 *
 */
public class cleanUpTeam extends resource
{
 
    private Grade capability;

    public cleanUpTeam(String resourceID, String resourceName, int cost, Grade capability)
    {
        super(resourceID, resourceName, cost);
        
        setCapability(capability);
    }

    /**
     * getter and setter method.
     * @return
     */
    public Grade getCapability() 
    {
        return capability;
    }
  
    public void setCapability(Grade capability) 
    {
        this.capability = capability;
    }

    @Override
    public String toString() 
    {
        return super.toString() + String.format("%s\n", capability);
    }
    
    @Override
    /**
     * to calculate the total probability of the game;
     */
    public void applyTo(site s)
    {
        Random randomGenerator = new Random();   
        final double weight = 0.50; 
        final double cleanWeight = 0.50;  
        
        double cleanScore = capability.getMultiplier();
        double probability = randomGenerator.nextDouble();
        
 
       double totalProbability = cleanScore*cleanWeight + probability*weight;
       
       s.setHasAedes(totalProbability < 0.5);
    }
}  


