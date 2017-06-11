import java.util.Random;
import javax.swing.JOptionPane;

public class Lightning extends AbstractSkill{
	public Lightning() {
		this.setType(Type.LIGHTNING);
		this.setPower(50);
		this.setAccuracy(75);
	}
	public void launch(AbstractCharacter ch){
		Random rand = new Random();
		
		int p = rand.nextInt(100) + 1;
		if(p <= this.getAccuracy()) {
			ch.setNowHP(ch.getNowHP() - this.getPower());
			JOptionPane.showMessageDialog(null,"It surprisingly hits! " + ch.getName() 
			+ " takes " + this.getPower() + " points of damage." );
		}
		else {
			JOptionPane.showMessageDialog(null,"As usual, you miss.");
		}
		if(ch.getNowHP() < 0)
			ch.setNowHP(0);
	}
	
	public String getName(){
		return "10 Volts";
	}
}
