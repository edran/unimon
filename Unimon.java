import java.util.*;

/*
 * Status Explained 
 * !!Needs to go somewhere else!!
 * alive if status ==  1
 * dead  if status == -1
 * confused   if status % 2   = 0
 * distracted if status % 6   = 0
 * sleeping   if status % 7   = 0 
 */



public abstract class Unimon{
	private final static int MAX_SLEEP_TURNS 	= 3;
	private final static int MAX_CONFUSE_TURNS 	= 5;
	private final static int MAX_DISTRACT_TURNS = 5;
	private int hp								=100;
	private int status							= 1;
	private int turnsUntilNotConfuse			=0;
	private int turnsUntilNotDistracted		    =0;
	private int turnsUntilNotAsleep			    =0;
	private String name;
	private Type type;
	private SortedSet<Attack> attacks;
	
	
	
	public Unimon(String name, Type type){
		this.name = name;
		this.type = type;
		this.status =1;
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
	public void reduceHp(){
	}
	
	
	/*
	 * Increases the current health points of the unimon.
	 * Can increase above the starting 100.
	 */
	public void increaseHp(){
	}
	
	/*
	 * confused unimon do damaged to themselves CONFUSE_PERCENTAGE of the time.
	 * confuses the pokemon between 1 and MAX_SLEEP_TURNS
	 */
	public void confuse(){
	}
	
	/*
	 * distracted unimon distracted unimon dont attack DISTRACT_PERCENTAGE of the time.
	 * distract the unimon for between 1 and MAX_DISTRACT_TURNS
	 */
	public void distract(int turns){
		
	}
	
	
	/*
	 * sleeping unimon are immobilized
	 * sleep 
	 */
	public void sleep(){
	}
	
	/*
	 * returns the status of the unimon
	 */
	public int getStatus(){
		return status;
	}
	
	/*
	 * returns all the attack of the unimon
	 */
	public SortedSet<Attack> getAttacks(){
		return attacks;
	}
	
	
	/*
	 * attacks the given Unimon using the given attack.
	 */
	public void attack(Attack att, Unimon target){
		
	}
	
	public void attack(int attackPosition, Unimon target){
		
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
	}
}
