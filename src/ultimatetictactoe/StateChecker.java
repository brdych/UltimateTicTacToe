/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultimatetictactoe;

import static java.lang.Thread.sleep;
import ui.GamePanel;

/**
 *
 * @author chris
 */
public class StateChecker implements Runnable
{
    private GamePanel g;
    private boolean run;
    
    public StateChecker(GamePanel g)
    {
        this.g = g;
        run=true;
    }
    
    public void halt()
    {
        run = false;
    }
    
    @Override
    public void run()
    {
        while(run)
        {
            g.update();
            try{sleep(1000);}
            catch (InterruptedException ex){System.out.println(ex.toString());}
        }
    }  
}