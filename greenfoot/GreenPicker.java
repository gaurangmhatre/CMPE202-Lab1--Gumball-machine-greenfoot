import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GreenPicker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GreenPicker extends Picker
{
   
    /**
     * Act - do whatever the GreenPicker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }   
    
    public void greenPickerMessage()
    {
        int x = this.getX();
        int y = this.getY();
        DisplayMessage msg = new DisplayMessage("Enjoy your Gumball !!");

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
