import java.util.*;

/*
 * Status Explained 
 * !!Needs to go somewhere else!!
 * alive if status ==  1
 * dead  if status == -1
 * confused   if status % 2   = 0
 * distracted if status % 3   = 0
 * sleeping   if status % 5  = 0 
 */



public abstract class Unimon{
	
	/*
	 * MAX_INJURY_TURNS  referes to the max turns a signal attack can 
	 * add. A unimon cound have longer after multiple attacks;
	 */
	private final static int MAX_SLEEP_TURNS 	= 3;
	private final static int MAX_CONFUSE_TURNS 	= 5;
	private final static int MAX_DISTRACT_TURNS = 5;
	private int hp								=100;
	private int status							= 1;
	private int turnsUntilNotConfused			=0;
	private int turnsUntilNotDistracted		    =0;
	private int turnsUntilNotAsleep			    =0;
	private Random rand;
	private String name;
	private Type type;
	private ArrayList<Attack> attacks;
	
	
	
	public Unimon(String name, Type type){
		this.name = name;
		this.type = type;
		this.status =1;
		attacks = new ArrayList<Attack>();
		rand = new Random();
	}
	
	/*
	 * Returns the current health points of the unimon
	 */
	public int getHp(){
		return hp;
	}
	
	
	/*
	 * Decreases the the health points of the unimon
	 */
	public void reduceHp(int amount){
		hp -=amount;
		if(hp<=0){
			hp = 0;
			status = -1;
		}
	}
	
	
	/*
	 * Increases the current health points of the unimon.
	 * Can increase above the starting 100.
	 */
	public void increaseHp(int amount){
		hp += amount;
	}
	
	/*
	 * confused unimon do damaged to themselves CONFUSE_PERCENTAGE of the time.
	 * confuses the pokemon between 1 and MAX_SLEEP_TURNS
	 */
	public void confuse(){
		status *= 2;
		turnsUntilNotConfused += rand.nextInt(MAX_CONFUSE_TURNS)+1;
	}
	
	/*
	 * distracted unimon distracted unimon dont attack DISTRACT_PERCENTAGE of the time.
	 * distract the unimon for between 1 and MAX_DISTRACT_TURNS
	 */
	public void distract(int turns){
		status *=3;
		turnsUntilNotDistracted += rand.nextInt(MAX_DISTRACT_TURNS)+1;	
	}
	
	
	/*
	 * sleeping unimon are immobilized
	 * sleep 
	 */
	public void sleep(){
		status *=5;
		turnsUntilNotAsleep += rand.nextInt(MAX_DISTRACT_TURNS)+1;
	}
	
	/*
	 * returns the status of the unimon
	 * see status guide above
	 */
	public int getStatus(){
		return status;
	}
	
	/*
	 * returns all the attack of the unimon
	 */
	public ArrayList<Attack> getAttacks(){
		return attacks;
	}
	
	
	/*
	 * attacks the given Unimon using the given attack.
	 */
	public void attack(Attack att, Unimon target){
	//ToDO
		
	}
	
	public void attack(int attackPosition, Unimon target){
	attack(attacks.get(attackPosition),target);
	}
	
	/*
	 * returns the type of the unimon.
	 */
	public Type getType(){
		return type;
	}
	
	/*
	 * updates status/injuries of unimon
	 */
	 
	public void endOfTurn(){
		
		if(turnsUntilNotConfused>1){
			turnsUntilNotConfused--;
		}else if(turnsUntilNotConfused==1){
			turnsUntilNotConfused = 0;
			status /=2;
		}
		if(turnsUntilNotDistracted>1){
			turnsUntilNotDistracted--;
		}else if(turnsUntilNotDistracted==1){
			turnsUntilNotDistracted = 0;
			status /=3;
		}
		if(turnsUntilNotAsleep>1){
			turnsUntilNotAsleep--;
		}else if(turnsUntilNotAsleep==1){
			turnsUntilNotAsleep = 0;
			status /=5;
		}
		
		
	}
}
