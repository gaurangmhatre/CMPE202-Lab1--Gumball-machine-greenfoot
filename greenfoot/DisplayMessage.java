import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.*;
/**
 * Write a description of class DisplayMessage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DisplayMessage extends Actor
{
    public DisplayMessage(String text){
        updateImage(text); 
    }
    public void setText(String text)  
    {  
        updateImage(text);  
    }  
      
    private void updateImage(String text)  
    {  
        setImage(new GreenfootImage(text, 30, Color.black, Color.green));  
    }
}
