import javax.imageio.ImageIO;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Pika extends AbstractCharacter{
	private BufferedImage first;
	private BufferedImage second;
	private boolean animated;
	
	public Pika (GameStage gamestage){
		this.gs = gamestage;
	}
	
	public String getName(){
		//return the name of the character
		return "Picachew";
	}
	
	public void initial(){
		// initial the parameter of the character
		Lightning skill = new Lightning();

		try{
			first = ImageIO.read(new File("img/pikachu-1.png"));
			second = ImageIO.read(new File("img/pikachu-2.png"));
		} catch (IOException e){
			//
		}
		this.setSkill(skill);
		this.setMAXHP(200);
		this.setNowHP(200);
		this.setImage(first);
		this.setType(Type.LIGHTNING);
	}
	@Override
	public Image getImage(){
		BufferedImage current;
		
		if(this.isActive()){
			/*try{
			    Thread.sleep(150);
			}catch(InterruptedException e){
			    System.out.println("got interrupted!");
			}*/
	    	animated = !animated;
	       	current = animated ? first : second;
		}else {
			current = first;
		}
		
       	return current;
	}
}
