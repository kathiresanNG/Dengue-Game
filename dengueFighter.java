
package java2Asignment1;
import java.util.*;



/**
 * 
 * @author Kathiresan
 *this class acts as a controller which maintains the collection 0f site and resources. 
 */
public class dengueFighter {


		private String playerName;
		private double  currentBudget;
		private static int currentWeek ;
		private ArrayList<site> DengueFighterSite;
                private ArrayList<resource>DengueFighterResource;
                
                
                public dengueFighter(String playerName){
                    this.playerName=playerName;
                    this.currentBudget=0;
                    this.currentWeek=0;
                    DengueFighterSite=new ArrayList<>();
                    DengueFighterResource=new ArrayList<>();   
                }
                
                public void addResource(resource r){
                    DengueFighterResource.add(r);
                    
                }
                
                public resource findResource(String resourceID){
                    for(int i =0; i<DengueFighterResource.size(); i++){
                        if (DengueFighterResource.get(i).getresourceID().equals(resourceID))
                            return DengueFighterResource.get(i);
                    }
                    return null;    
                }
                    
		public site findSite(String siteID){
                    for (int i=0; i< DengueFighterSite.size(); i++){
                        if (DengueFighterSite.get(i).getSiteID().equals(siteID))
                            return DengueFighterSite.get(i);
                    }
                    return null;                    
                }
                public void updateAllSite(){
                    for (site s:DengueFighterSite)
                        s.updateInfections();
                }
                
 
                public String showAllResource(){
                    String allResource="\n";
                    for (resource r: DengueFighterResource){
                        allResource+=r.toString()+"\n";
                    }
                    return allResource;
                }
                
                public void confirmResourceUsage(){
                    for (site s:DengueFighterSite)
                        s.UsedResourceForWeek(currentWeek);
                }

    
                        
		
		public double BudgetCalculator(double currentBudget){
			for (site s: DengueFighterSite){
                            currentBudget+=s.getRevenue();
                        }
                        return currentBudget;
		}

		public String getPlayerName() {
			return playerName;
		}

		public void setPlayerName(String playerName) {
			this.playerName = playerName;
		}

		public double getCurrentBudget() {
			return currentBudget;
		}

		public void setCurrentBudget(double currentBudget) {
			this.currentBudget = currentBudget;
		}

		public static int getCurrentWeek() {
			return currentWeek;
		}

		public static void setCurrentWeek(int currentWeek) {
			dengueFighter.currentWeek = currentWeek;
		}
                public ArrayList<site> getDengueFighterSite() {
                        return DengueFighterSite;
                }

                public void setDengueFighterSite(ArrayList<site> dengueFighterSite) {
                    this.DengueFighterSite = dengueFighterSite;
                }

                public ArrayList<resource> getDengueFighterResource() {
                return DengueFighterResource;
                }

                public void setDengueFighterResource(ArrayList<resource> DengueFighterResource) {
                    this.DengueFighterResource = DengueFighterResource;
                }


    public void addSite(site s) {
        DengueFighterSite.add(s);
    }
    
    public void addCurrentBudget(double budget){
        
    }
    
    public String showSite(){
        String str = String.format("SiteID", "Cleanliness", "Population", "Revenue per worker", "Number of infected", "Has Aedes");
        for (site s: DengueFighterSite){
            str += String.format(s.getSiteID(),s.getCleanliness(), s.getPopulation(), s.getRevenue(), s.getNumInfected(),s.HasAedes());
            
        }
        return str;   
    }
    
    @Override
    public String toString(){
        return "DengueFighter:" + "playerName: "+ playerName + ", currentBudget: " + currentBudget;
        
    }



}