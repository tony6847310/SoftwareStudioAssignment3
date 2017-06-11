import javax.imageio.ImageIO;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bulbasaur extends AbstractCharacter{
	private BufferedImage first;
	private BufferedImage second;
	private boolean animated;
	
	public Bulbasaur  (GameStage gamestage){
		this.gs = gamestage;
	}
	
	public String getName(){
		//return the name of the character
		return "Bulbasore";
	}
	
	public void initial(){
		// initial the parameter of the character
		Leaves skill = new Leaves();
		
		try{
			first = ImageIO.read(new File("img/bulbasaur-1.png"));
			second = ImageIO.read(new File("img/bulbasaur-2.png"));
		} catch (IOException e){
			//
		}
		this.setSkill(skill);
		this.setMAXHP(200);
		this.setNowHP(200);
		this.setImage(first);
		this.setType(Type.GRASS);
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
