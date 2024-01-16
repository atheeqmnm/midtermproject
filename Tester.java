

/**
 *
 * @author ATHEEQ
 */
import java.util.ArrayList;
import java.util.Scanner;

class Bloodsugar{
    private int id,yob,sugar_level ;
    private String name;
    
    public Bloodsugar(int ID,String Name,int Yob,int sugar_level ){
   
        this.id = ID;
        this.yob = Yob;
        this.sugar_level = sugar_level ;
        this.name = Name;
        
    }
    public int getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    public int getyob(){
        return yob;
    }
    
    public int getsugar_level(){
        return sugar_level;
    }
    
    
    
    
    public void setId(int i){
        id = i;
    }
    
    public void setName(String N){
        name = N;
    }
    
    public void setyob(int Y){
        yob = Y;
    }
    
    public void setsugar_level(int S){
        sugar_level = S;
    }
    
    
    
 
       
    public void display(){
        System.out.println("Id : "+id);
        System.out.println("Name : "+name);
        System.out.println("Year of Birth : "+yob);
        System.out.println("Sugar_level : "+sugar_level);
        
    }    
        
    
} 

public class Tester {
    private static Bloodsugar record(){
        Scanner R = new Scanner(System.in);
        System.out.print("Enter ID: ");
        int id = R.nextInt();
        System.out.print("Enter Name: ");
        String name = R.next();
        System.out.print("Enter your Year of Birth: ");
        int yob = R.nextInt();
        System.out.print("Enter The sugar_level : ");
        int sugar_level = R.nextInt();
        return new Bloodsugar(id,name,yob,sugar_level );

    }
    private static int getId() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID: ");
        return scanner.nextInt();
    }

    private static Bloodsugar getbpBYId(ArrayList<Bloodsugar> bloodsugarRecords, int id) {
        for (Bloodsugar bloodsugar : bloodsugarRecords) {
            if (bloodsugar.getId() == id) {
                return bloodsugar;
            }
        }
        return null;
    }
   
    
    public static void displayMenu(){
        System.out.println(" Blood sugar monitor");
        System.out.println("-----------------------");
        System.out.println("1. Create a record."); 
        System.out.println("2. Show blood sugar data for all users.");
        System.out.println("3. Show blood sugar data for a selected user.");  
        System.out.println("4. Delete all.");
        System.out.println("5. Exit application.");
        
        System.out.print("Enter Your Choise : ");
    }
    
    public static void index(){
        System.out.println("to show all records");
    }
    public static void view(int Id){
        System.out.println(" to show one record for the given id.");
    } 
    
    public static void create(){
        System.out.println("create a new record"); 
    }
    
    public static void delete(){
        System.out.println("All Blood sugar deleted successfully");
        
    }
    public static void exit(){
        System.out.println("Thank you for using The Blood sugar monitor");
        System.exit(0);
    } 
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList <Bloodsugar> bloodsugar = new ArrayList<>();
        int choise;
        Scanner in = new Scanner(System.in);
        do{
            displayMenu();
            choise = in.nextInt();
            switch(choise){
                case 1:
                    create();
                    for(int j=0 ; j < 5 ; j++){
                        bloodsugar.add(record());
                        System.out.println("---------------------");
                    }
                    break;
                    
                case 2:
                    index();
                    for(Bloodsugar BS : bloodsugar){
                        BS.display();
                        System.out.println("--------------------");
                    }
                    
                    break;
                
                case 3:
                    int id = getId();
                    view(id);
                    Bloodsugar bloodsugarToDisplay = getbpBYId(bloodsugar, id);
                    if (bloodsugarToDisplay != null) {
                        bloodsugarToDisplay.display();
                    }
                    else {
                        System.out.println("No Bloodsugar record found for the given ID.");
                    }
                    break;
                    
                case 4:
                    delete();
                    bloodsugar.clear();
                    break;
                    
                case 5:
                    exit();
                    break;
                    
                default:
                    System.out.println("Invalid Choise");
                 
            }
                    
        }
        while(true);
        
        
    }
    
    
}