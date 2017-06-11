import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Random;
import javax.sound.sampled.*;
import java.io.File;

public class GameStage extends JFrame implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CharacterPanel ch1,ch2;
	private AbstractCharacter[] charaList;
	private int skill;
	private Random rand = new Random();
	private int select = rand.nextInt(3);
	public GameStage(){
		setLayout(null);
		setSize(1000,500);
		setLocation(100,100);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		charaList = new AbstractCharacter[2];
		//
		if(select == 2)
			charaList[0] = new Charmander(this);
		else if(select == 1)
			charaList[0] = new Pika(this);
		else
			charaList[0] = new Bulbasaur(this);
		//
		charaList[0].initial();
		ch1 = new CharacterPanel(charaList[0],this);
		ch1.setBounds(0, 0, 500, 500);
		add(ch1);
		//
		select = (select+1)%3;
		if(select == 2)
			charaList[1] = new Charmander(this);
		else if(select == 1)
			charaList[1] = new Pika(this);
		else
			charaList[1] = new Bulbasaur(this);
		//
		charaList[1].initial();
		ch2 = new CharacterPanel(charaList[1],this);
		ch2.setBounds(500,0,500,500);
		add(ch2);
		setSkill(-1);
		charaList[0].setActive();
		charaList[1].disActive();
		ch1.update();
		ch2.update();
		setVisible(true);
	}
	@Override
	public void run(){
		// TODO Auto-generated method stub
		int isEnding = 0,turn = 0;
		int state = 0;
		music();
		while(isEnding == 0){
			if(state == 0){	// attack phase
				if(skill != -1){
					state = 1;
				}
			}else if(state == 1){ //effect phase
				charaList[turn].getSkills().get(skill).launch(charaList[1-turn]);
				state = 2;
			}else if(state == 2){ //change phase
				setSkill(-1);
				turn = (1-turn);				
				charaList[turn].setActive();
				charaList[1-turn].disActive();
				ch1.update();
				ch2.update();
				state = 0;
				if(charaList[0].getNowHP() == 0){
					JOptionPane.showMessageDialog(this,charaList[1].getName()+
						    " wins the game.");
					isEnding = 1;
				}
				if(charaList[1].getNowHP() == 0){
					JOptionPane.showMessageDialog(this,charaList[0].getName()+
						    " wins the game.");
					isEnding = 1;
				}
			}
			this.repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.exit(0);
	}
	public void setSkill(int num){
		skill = num;
	}
	
	public void music() { 
		try { File file = new File("sounds/bgm.wav");
		Clip clip = AudioSystem.getClip();
		clip.open(AudioSystem.getAudioInputStream(file));
		clip.start();
		} catch (Exception e) {
		} 
	}
}
