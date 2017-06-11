First I create 3 classes to extend "AbstractCharacter" and 3 to extend "AbstactSkill".
Each character uses one skill. I add three new Type for my characters and skills. FIRE, GRASS, and LIGHTNING.
FIRE is effective against GRASS. On the other hand,  GRASS is weak against FIRE.

For Skill classes, I uses "Random.nextInt()" with accuracy to decide if the skill hits.
For Character classes, I uses "ImageIO.read()" to get my characters' images. 
As for animations, I  override "getImage()" to switch images each time it is called if the character is active.
At "GameStage", I also uses "Random.nextInt()" to decide which character will be new in the constructor.
Lastly, I add a method "music()" to play background music by using Clip.