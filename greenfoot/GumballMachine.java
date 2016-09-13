import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class GumballMachine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GumballMachine extends Actor
{

    Coin c = null;
    boolean cranked = true;
    Inspector inspector = null;
    
    public GumballMachine()
    {
        GreenfootImage image = getImage() ;
        image.scale( 350, 400 ) ; 
    }

    public void act() 
    {
        // Check if the coin is on gumballmachine.
        //if yes, set flag IsCoinInserted to true and dispose the coin.
        //and pass coin to Inspector
        
        
        
        if(getOneIntersectingObject(Coin.class)!=null)
        {
            List<Inspector> instruct = null;
            c = (Coin)getOneIntersectingObject(Coin.class);
            if(c.getX() > this.getX() - 100 && c.getX() < this.getX()+100 && c.getY() > this.getY()-100 && c.getY() < this.getY() +100)
            {
               
               putMessage("Crank It",this.getX(),this.getY());
               instruct = (List<Inspector>)getWorld().getObjects(Inspector.class);
               inspector = instruct.get(0);
               
               getWorld().removeObject(c);
               cranked = false;
            }
        }
        
        if(Greenfoot.mousePressed(this))
        {
            GreenPicker greenPicker = null;
            RandomPicker randomPicker = null;
            List<GreenPicker> greenPick = null;
            List<RandomPicker> randomPick = null;
            
            greenPick= (List<GreenPicker>)getWorld().getObjects(GreenPicker.class);
            greenPicker = (GreenPicker)greenPick.get(0); 
            
            randomPick= (List<RandomPicker>)getWorld().getObjects(RandomPicker.class);
            randomPicker = (RandomPicker)randomPick.get(0);
            
            //Clear old meaasge.
            if(greenPicker !=null)
            {
                greenPicker.clearMessage();
            }
            
            if(randomPicker!= null)
            {
                randomPicker.clearMessage();
            }
                
       
            inspector.clearMessage();
            
            if(!cranked) 
            {          
                MouseInfo mouse = Greenfoot.getMouseInfo();  
                int mouseX=mouse.getX();  
                int mouseY=mouse.getY();  
                cranked = false;
                if(mouseX > this.getX()-130 && mouseX < this.getX()+130 ) 
                {
                    //displayMessage("cranked",350,500);
                    cranked = true;
                    if (!getWorld().getObjectsAt(this.getX(), this.getY(), DisplayMessage.class).isEmpty())  
                    {  
                        System.out.println("Delete syntax");
                        getWorld().removeObject((DisplayMessage)getWorld().getObjectsAt(this.getX(), this.getY(), DisplayMessage.class).get(0));  
                    }
                   // c.setCoinUsed(true); //use this method
                   
                    inspector.inspect(c);
                    
                    
                }       
            }
        }
        
        
        //Greenfoot.delay(2);
         //getWorld().removeObject((DisplayMessage)getWorld().getObjectsAt(.class));  
    
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
}
