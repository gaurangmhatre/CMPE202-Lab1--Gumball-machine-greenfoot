import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Inspector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inspector extends Alien
{
    /**
     * Act - do whatever the Inspector wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Inspector()
    {
        GreenfootImage image = getImage() ;
        //image.scale( 350, 400 ) ;
    }
    
    public void act(Coin coin) 
    {
    }  

    public void inspect(Coin coin) 
    {
        // Add your action code here.
        GreenPicker greenPicker = null;
        RandomPicker randomPicker = null;
        List<GreenPicker> greenPick = null;
        List<RandomPicker> randomPick = null;
        
        greenPick= (List<GreenPicker>)getWorld().getObjects(GreenPicker.class);
        greenPicker = (GreenPicker)greenPick.get(0); 
        
        randomPick= (List<RandomPicker>)getWorld().getObjects(RandomPicker.class);
        randomPicker = (RandomPicker)randomPick.get(0);
     
        
        //System.out.println("Inspector is checking. hight :"+coin.getImage().getHeight() +"width: "+coin.getImage().getWidth());
        if(coin.getImage().getHeight()==80 && coin.getImage().getWidth()==80)
        {
            int GreenorRandom = Greenfoot.getRandomNumber(2);       
            putMessage("Quarter! validated.",this.getX(),this.getY());
            
            //System.out.println("<<GreenorRandom>> "+GreenorRandom );
            if(GreenorRandom ==0)//0-Greenpicker  1-RandomPicker
            {
                //calling Green Picker
               
                if(greenPick!=null)
                {                  
                     
                    //System.out.println("----Calling Green Picker."+greenPicker);
                    greenPicker.pickAGumBall(0);
                    greenPicker.greenPickerMessage();
                }
            }
            else
            {
               // Calling random picker
               
                if(randomPick!=null)
                {
                    
                    //System.out.println("----Calling random Picker."+randomPicker);
                    randomPicker.pickAGumBall(Greenfoot.getRandomNumber(3));
                    randomPicker.randomPickerMessage();
                }
            }
        }
        else if(coin.getImage().getHeight()==75 && coin.getImage().getWidth()==75)
        {
            //print fake message 
            //System.out.println("Fake Coin!.");
            putMessage("Fake Coin!.", this.getX(),this.getY());

        }
        else if(coin.getImage().getHeight()==50 && coin.getImage().getWidth()==50)
        {
            //print penny
            //System.out.println("Penny will not work!");
            putMessage("Penny will not work!", this.getX(),this.getY());
        }
    }  

    public void putMessage(String message, int x, int y)//display message
    {

        DisplayMessage msg = new DisplayMessage(message);

         if (!getWorld().getObjectsAt(x, y, DisplayMessage.class).isEmpty())  
        {  
            getWorld().removeObject((DisplayMessage)getWorld().getObjectsAt(x, y, DisplayMessage.class).get(0));  
        }
         
        getWorld().addObject(msg,x,y);
    }

    public void clearMessage()
    {
        if (!getWorld().getObjectsAt(this.getX(), this.getY(), DisplayMessage.class).isEmpty())  
        {  
            getWorld().removeObject((DisplayMessage)getWorld().getObjectsAt(this.getX(), this.getY(), DisplayMessage.class).get(0));  
        }
    
    }
    
    
}
