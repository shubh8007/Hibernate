package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//id , name, abbrevation,owner,max_age,batting_avg,wickets_taken
@Entity
@Table(name="teams")
public class Team extends BaseEntity{
	@Column(name="name",length=40,unique=true)
	private String name;
	@Column(name="abbrevation",length=40,unique=true)
	private String abbrevation;
	@Column(name="owner",length=40)
	private String owner;
	@Column(name="max_age")
	private int maxAge;// max age of the player allowed in this team
	@Column(name="batting_avg")
	private double battingAvg;
	@Column(name="wickets_taken")
	private int wicketsTaken;
	@OneToMany(mappedBy="myteam",cascade=CascadeType.ALL,orphanRemoval = true)
	private List<Player> players=new ArrayList<>();

	public Team() {
		// TODO Auto-generated constructor stub
	}

	public Team( String name, String abbrevation, String owner, int maxAge, double battingAvg,
			int wicketsTaken) {
		super();
	
		this.name = name;
		this.abbrevation = abbrevation;
		this.owner = owner;
		this.maxAge = maxAge;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
	}
	

	public Team(int teamId, String abbrevation) {
		super();
		
		this.abbrevation = abbrevation;
	}


	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbrevation() {
		return abbrevation;
	}

	public void setAbbrevation(String abbrevation) {
		this.abbrevation = abbrevation;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public double getBattingAvg() {
		return battingAvg;
	}

	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}

	public int getWicketsTaken() {
		return wicketsTaken;
	}

	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}

	@Override
	public String toString() {
		return "Team , name=" + name + ", abbrevation=" + abbrevation + ", owner=" + owner
				+ ", maxAge=" + maxAge + ", battingAvg=" + battingAvg + ", wicketsTaken=" + wicketsTaken + "]";
	}
	
//add 2 helper method:addplayer, remove player , to establish/
	
	public void addplayer(Player player) 
	{
		players.add(player);//parent
		player.setMyteam(this);//child
	}
	public void removeplayer(Player player) 
	{
		players.remove(player);//parent
		player.setMyteam(null);//child
	}
}
