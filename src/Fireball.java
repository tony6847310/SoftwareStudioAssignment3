import java.util.Random;
import javax.swing.JOptionPane;

public class Fireball extends AbstractSkill{
	public Fireball(){
		this.setType(Type.FIRE);
		this.setPower(50);
		this.setAccuracy(75);
	}
	public void launch(AbstractCharacter ch){
		Random rand = new Random();
		int hitpoints = this.getPower();
		
		int p = rand.nextInt(100) + 1;
		if(p <= this.getAccuracy()) {
			if(ch.getType() == Type.GRASS){
				hitpoints *= 1.5;
				ch.setNowHP(ch.getNowHP() - hitpoints);
				JOptionPane.showMessageDialog(null,"You are such a cheater! " + ch.getName() 
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
		return "FireCough";
	}
}
