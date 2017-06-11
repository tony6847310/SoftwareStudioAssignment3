import java.util.Random;
import javax.swing.JOptionPane;

public class Leaves extends AbstractSkill{
	public Leaves(){
		this.setType(Type.GRASS);
		this.setPower(50);
		this.setAccuracy(75);
	}
	public void launch(AbstractCharacter ch){
		Random rand = new Random();
		int hitpoints = 50;
		
		int p = rand.nextInt(100) + 1;
		if(p <= this.getAccuracy()) {
			if(ch.getType() == Type.FIRE){
				hitpoints /= 2;
				ch.setNowHP(ch.getNowHP() - hitpoints);
				JOptionPane.showMessageDialog(null,"Are you scratching your enemy? " + ch.getName() 
				+ " takes " + hitpoints + " points of damage." );
			}
			else{
				ch.setNowHP(ch.getNowHP() - hitpoints);
				JOptionPane.showMessageDialog(null,"It surprisingly hits! " + ch.getName() 
				+ " takes " + hitpoints + " points of damage." );
			}
		}
		else {
			JOptionPane.showMessageDialog(null,"As usual, you miss.");
		}
		if(ch.getNowHP() < 0)
			ch.setNowHP(0);
	}
	
	public String getName(){
		return "Razor weeds ";
	}
}
