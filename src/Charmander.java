import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Charmander extends AbstractCharacter{
	private BufferedImage first;
	private BufferedImage second;
	private boolean animated;
	
	public Charmander(GameStage gamestage){
		this.gs = gamestage;
	}
	
	public String getName(){
		//return the name of the character
		return "Charemunder";
	}
	
	public void initial(){
		// initial the parameter of the character
		Fireball skill = new Fireball();
		
		try{
			first = ImageIO.read(new File("img/charmander-1.png"));
			second = ImageIO.read(new File("img/charmander-2.png"));
		} catch (IOException e){
		}
		this.setSkill(skill);
		this.setMAXHP(200);
		this.setNowHP(200);
		this.setImage(first);
		this.setType(Type.FIRE);
	}
	@Override
	public Image getImage(){
		BufferedImage current;
		
		/*try{
		    Thread.sleep(150);
		}catch(InterruptedException e){
		    System.out.println("got interrupted!");
		}*/
		if(this.isActive()){
	    	animated = !animated;
	       	current = animated ? first : second;
		}else {
			current = first;
		}
		
       	return current;
	}
}
