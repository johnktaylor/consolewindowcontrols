/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jktsoftware.consolewindowcontrols;

/**
 *
 * @author jktdev
 */
public class Application {
 
    public static void main(String[] args) {
        exampleloop();
    }
	
    public static void exampleloop()
    {
        ConsoleProgressBar progressbar = new ConsoleProgressBar();
        long totalbytes = 2000000000*512;
        long downloadedbytes = 512*1000;
        long progressbytes=0;
		
        for(progressbytes=0; progressbytes<totalbytes; progressbytes=progressbytes+downloadedbytes) {
            System.out.print(progressbar.getProgress(progressbytes, downloadedbytes, totalbytes) + "\r");
            try 
            {
                Thread.sleep(2);
            }
            catch (Exception ex) 
            {
                
            }
            
        }
		
        System.out.println(progressbar.getProgress(progressbytes, downloadedbytes, totalbytes));
    }
}
