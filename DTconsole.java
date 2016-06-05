package java2Asignment1;
/**
 * @author Kathiresan
 */
import static java.lang.System.out;

import java.util.*;
public class DTconsole {
    
    private static dengueFighter DengueFighter;
    private static Scanner sc;
    

/**
 * 
 * @param args
 */
    public static void main(String[] args) {
        // TODO code application logic here
        sc = new Scanner(System.in);
            System.out.println("Welcome To Dengue Recovory Game !!!");
            System.out.print("Please enter user name: ");
            String playerName= sc.nextLine();
            dengueFighter dengueFighter = new dengueFighter(playerName);
            site s1=new site();
            site s2=new site();
            site s3=new site();
            dengueFighter.addSite(s1);
            dengueFighter.addSite(s2);
            dengueFighter.addSite(s3);
            dengueFighter.setCurrentBudget(dengueFighter.BudgetCalculator(0));
            pesticide Larvicide = new pesticide("R100", "Larvicide\t",100,Grade.LOW,Grade.MEDIUM);
            pesticide Fogging = new pesticide("R101", "Fogging\t\t",200,Grade.MEDIUM,Grade.LOW);
            pesticide ResidualSpray = new pesticide("R102", "ResidualSpray\t",300,Grade.HIGH,Grade.HIGH);
            medicalService GeneralWard=new medicalService("R200","General Ward\t",100,15);
            medicalService IsolationWard=new medicalService("R201","Isolation Ward\t",300,30);
            cleanUpTeam General = new cleanUpTeam("R300","General Cleaning\t",100,Grade.LOW);
            cleanUpTeam Target = new cleanUpTeam("R301","Targeted Cleaning",500,Grade.HIGH);
            dengueFighter.addResource(Larvicide);
            dengueFighter.addResource(Fogging);
            dengueFighter.addResource(ResidualSpray);
            dengueFighter.addResource(GeneralWard);
            dengueFighter.addResource(IsolationWard);
            dengueFighter.addResource(General);
            dengueFighter.addResource(Target);
            
            

            int choice;
            do{
                displayMenu(dengueFighter);
                choice= sc.nextInt();
                sc.nextLine();
                switch(choice){
                    case 1: manageSite(dengueFighter,s1,s2,s3); break;
                    case 2: endWeek(dengueFighter); break;
                    case 3:endGame(dengueFighter);break;
                    default: System.out.println("Error");
            }
                
        }while(choice!=3);
        
    }
    
    /**
     * 
     * @param df
     */
    private static void displayMenu(dengueFighter df){
        System.out.println("");
        System.out.println(df.showSite());

        System.out.println("Week No: " + df.getCurrentWeek());
        System.out.println(String.format("Budget: %.2f", df.getCurrentBudget()));
        System.out.println("What would you like to do :");
        System.out.println("1. Manage Site");
        System.out.println("2. End Week");
        System.out.println("3. End Game");
        System.out.println("enter choice : ");
        
    }
    
    /**
     * 
     * @param df
     */
    private static void finish(dengueFighter df){
        System.out.println("");
        System.out.println("Game over");
        System.out.println(String.format("Your Budget left : %.2f",df.getCurrentBudget()));
        System.out.println("Week survived: "+ dengueFighter.getCurrentWeek());
    }
    
    /**
     * 
     * @param dengueFighter
     * @param s1
     * @param s2
     * @param s3
     */
    public static void manageSite(dengueFighter dengueFighter, site s1, site s2, site s3){
        String siteChoice,resourceChoice;
        int quantity;
        double totalPrice;
        System.out.println("Enter site : ");
        siteChoice=sc.nextLine();
        while (dengueFighter.findSite(siteChoice)==null){

            System.out.println("Invalid Site, please enter an acurate siteID : ");
            siteChoice=sc.nextLine();
        }
        site siteToManage = dengueFighter.findSite(siteChoice);
        displayResourceDetail(dengueFighter);
        resourceChoice=sc.nextLine();
        resource resourceUsage= dengueFighter.findResource(resourceChoice);
        while(resourceUsage==null){
            System.out.println("Invalid Resource ID, please enter resource choice again: ");
            System.out.print("Your resource choice: ");
            resourceChoice=sc.nextLine();
            resourceUsage= dengueFighter.findResource(resourceChoice);
            
        }
        while(siteToManage.resourceUsed(resourceUsage, dengueFighter.getCurrentWeek())){
            System.out.println("you have already used this resource on this site for this week!");
            System.out.println("therefore please select another resource. ");
            System.out.print("please enter next resource choice: ");
            resourceChoice=sc.nextLine();
            resourceUsage= dengueFighter.findResource(resourceChoice);
            
        }
        resourceUsage=dengueFighter.findResource(resourceChoice);
        System.out.print("Quantity: ");
        quantity=sc.nextInt();
        totalPrice=resourceUsage.getCost()*quantity;
        
        while(((dengueFighter.getCurrentBudget()-totalPrice)<0)){
            System.out.println("Insufficient cash!");
            System.out.print("Quantity: ");
            quantity=sc.nextInt();
            totalPrice=resourceUsage.getCost()*quantity;
        }
        siteToManage.addResourceUsage(resourceUsage,quantity,dengueFighter.getCurrentWeek(),siteToManage);
        System.out.println("total resource used. ");
        System.out.print("Resource usage for current week is: "+ dengueFighter.getCurrentWeek());
        System.out.print(s1.showAllResourceUsage(dengueFighter.getCurrentWeek()));
        System.out.print(s2.showAllResourceUsage(dengueFighter.getCurrentWeek()));
        System.out.print(s3.showAllResourceUsage(dengueFighter.getCurrentWeek()));
        dengueFighter.setCurrentBudget(dengueFighter.getCurrentBudget()-(resourceUsage.getCost()*quantity));
        
            
        
         

    
    
    }
    
    /**
     * 
     * @param df
     */
    public static void displayResourceDetail(dengueFighter df){
        System.out.println(df.showAllResource());
        System.out.print("your choice of resource : ");
    }
       
       public static void endWeek(dengueFighter df){
           df.confirmResourceUsage();
           df.setCurrentWeek(df.getCurrentWeek()+1);
           df.updateAllSite();
           df.setCurrentBudget(df.getCurrentBudget()+df.BudgetCalculator(df.getCurrentBudget()));
       }
       public static void endGame(dengueFighter df){
    	   System.out.println("the game has ended.");
    	   System.out.println(String.format("budget remaining: %.2f", df.getCurrentBudget()));
    	   System.out.println("total weeks played in game: "+ df.getCurrentWeek());
       }
       
       
       public static void addSite(){
           site newSite;
           System.out.print("Enter Site Name : ");
           String site=sc.nextLine();
           
       }



               
}