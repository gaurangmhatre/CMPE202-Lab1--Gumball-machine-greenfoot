import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RandomPicker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RandomPicker extends Picker
{   
    
    /**
     * Act - do whatever the RandomPicker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    public void act() 
    {
        // Add your action code here.
    }


    public void randomPickerMessage()
    {
        int x = this.getX();
        int y = this.getY();
        DisplayMessage msg = new DisplayMessage("Enjoy your Gumball!!");

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
