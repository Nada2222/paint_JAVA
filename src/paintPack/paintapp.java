/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintPack;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import static java.awt.Color.black;
import static java.awt.Color.white;
import static java.awt.Color.yellow;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.shape.Line;

/**
 *
 * @author Nada
 */
public class paintapp extends Applet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    Lin l;
    myOval o; 
    myRect r;
    int order = 0;
    int lFlag=0;
    int oFlag=0;
    int rFlag =0;
    int eraseFlag=0;
    Checkbox checkBox1 = new Checkbox();
   
    public class Fl{
        int check = 0;
        int orderdraw ;
    }
    public class Lin extends Fl{
        int xStart, yStart, xEnd , Yend;
        Lin(){
          xStart=0;  yStart=0 ;xEnd =0;Yend=0 ;orderdraw = order;  
        }
        Color li;
    }
    public class myRect extends Fl{
        int xStart, yStart, width, height;
        //int rFLag =0;
        myRect(){
            xStart=0;  yStart=0 ;width =0;height=0; 
        }
        
        Color re;
        myRect(int x , int y , int w , int h , int order){
            xStart=x;  yStart=y ;width =w;height=h ; orderdraw = order; 
        }
    }
    public class myOval extends Fl{
       int xStart, yStart, width, height; 
       //int oFLag= 0;
       myOval(){
            xStart=0;  yStart=0 ;width =0;height=0; 
        }
       Color ov;
    }
    
   
   
    
    ArrayList<Lin> li = new ArrayList<>();
    ArrayList<myOval> ova = new ArrayList<>();
    ArrayList<myRect> re = new ArrayList<>();
    ArrayList<myRect> er = new ArrayList<>();
    
    //ArrayList lineList = new ArrayList<>();
//     private List list = new ArrayList();
//     
//     private List ov = new ArrayList();
//     private List rec = new ArrayList();
    // private List er = new ArrayList();

     private Line line;
     private Oval oval;
     private Rectangle rect;
    Button rButton , oButton , lButton, red , green , blue,eraseall, erase;
     Color mycolor;
   
    public void init() {
        // TODO start asynchronous download of heavy resources
        rButton = new Button("DrawRectangle");
        oButton = new Button("DrawOval");
        lButton = new Button("DrawLine");
        red = new Button("Red");
        green = new Button("green");
        blue = new Button("blue");
        eraseall = new Button("EraseAll");
        erase = new Button("Erase");
        checkBox1.setLabel("Fill");
          
          add(rButton); 
          add(oButton) ;
          add(lButton);
          add(red) ;
          add(green) ;
          add(blue); 
          add(eraseall);
          add(erase);
          add(checkBox1);
         
          oButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oFlag = 1;
                rFlag = 0;
                lFlag= 0;
                eraseFlag = 0;
            }
          });
          
        rButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
               
               oFlag = 0;
                rFlag = 1;
                lFlag= 0;
                eraseFlag = 0;
            }
        });
        
         lButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
               oFlag = 0;
               rFlag = 0;
               lFlag = 1;
               eraseFlag = 0;
            }
        });
        
       red.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
               // mycolor = red;
               mycolor  = Color.red;
               
                
            }
       });
       
       blue.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                mycolor  = Color.blue; 
            }
       });
       
       green.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
               mycolor  = Color.green;  
            }
       });
       
      eraseall.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                //list.removeAll(list);
                li.clear();
                ova.removeAll(ova);
                re.removeAll(re);
                repaint();
            }
      });
        
    erase.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                eraseFlag = 1;
                 oFlag = 0;
               rFlag = 0;
               lFlag = 0;
               
            }
    });
         
       
         
         
        this.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
                //set dragged flag false;
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                      l= new Lin();
                       o= new myOval();
                       r = new myRect();
                    if (oFlag == 1 || rFlag == 1 || lFlag == 1){  
                     if(rFlag ==1 ){
                   
                      r.xStart = e.getX();//
                    r.yStart = e.getY();//
                    order++;
                    r.orderdraw=order;
                    r.re = mycolor;
                    if(checkBox1.getState()==true)
                    {
                        r.check=1;
                    }
                        re.add(r);
                        
                    }
                    if (lFlag == 1) {
                     l.xStart = e.getX();
                    l.yStart = e.getY();
                    order++;
                    l.orderdraw=order;
                    l.li=mycolor;
                    if(checkBox1.getState()==true)
                    {
                        l.check=1;
                    }
                        li.add(l);
                    }
                   
                     if(oFlag ==1){
                             
                    o.xStart = e.getX();
                    o.yStart = e.getY();
                    order++;
                    o.orderdraw=order;
                     o.ov=mycolor;
                     if(checkBox1.getState()==true)
                     {
                        o.check =1;
                     }
                     ova.add(o);
                    }
                    
                   
                }
                if(eraseFlag ==1)
                {
                    r.xStart = e.getX();
                    r.yStart = e.getY();
                    order++;
                    r.orderdraw=order;
                     er.add(r);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            
                    //save shapes in arraylist
                //check eleent is drageg flag 
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        this.addMouseMotionListener(new MouseMotionListener(){

            @Override
            public void mouseDragged(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
               
                  //set dragged flag true
                      if(rFlag ==1){
                   
                      r.width = e.getX()-r.xStart;
                    r.height = e.getY()-r.yStart;
                     repaint();
                       
                        
                    }
                    if (lFlag == 1) {
                    l.xEnd = e.getX();
                    l.Yend = e.getY();
                      repaint();  
                    }
                   
                     if(oFlag ==1){
                             
                    o.width = e.getX()-o.xStart;
                    o.height = e.getY()-o.yStart;
                      repaint();  
                    }
                    
                     
                     if(eraseFlag == 1){
                         order++;
                         er.add(new myRect(e.getX() , e.getY() , 20 , 20 , order));
                         repaint();
                     }
                     
                     
                   
                  
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
    
    Graphics g= getGraphics();
     Lin currentLine;
     myRect currentRect;
     myOval currentOval;
       public void paint(Graphics g) {
      
 for(int num=0; num<=order ; num++)
 {
        
        for (int j = 0; j < li.size(); j++) {
           if(li.get(j).orderdraw == num)
           {
            currentLine = (Lin) (li.get(j));
            g.setColor(currentLine.li);
             
            g.drawLine(currentLine.xStart, currentLine.yStart, currentLine.xEnd, currentLine.Yend);
           }
            
        }
        
        
         for (int j = 0; j < re.size(); j++) {
              //g.setColor(Color.BLACK) ;
             if(re.get(j).orderdraw == num)
             {
                currentRect = (myRect) (re.get(j));
                g.setColor(currentRect.re);
                 if(currentRect.check==1 )
                  {
                      g.fillRect(currentRect.xStart, currentRect.yStart, currentRect.width, currentRect.height);
                  }
                 else
                 {   
                g.drawRect(currentRect.xStart, currentRect.yStart, currentRect.width, currentRect.height);
                 }
             }
        }
         
          for (int j = 0; j < ova.size(); j++) {
            // g.setColor(Color.BLACK) ;
              if(ova.get(j).orderdraw ==num)
              {
                currentOval = (myOval) (ova.get(j));
                g.setColor(currentOval.ov);
                if(currentOval.check==1)
                  {
                      g.fillOval(currentOval.xStart, currentOval.yStart, currentOval.width, currentOval.height);
                  }
                else{
                g.drawOval(currentOval.xStart, currentOval.yStart, currentOval.width, currentOval.height);
                }
              }
        }
        
          
             for (int j = 0; j < er.size(); j++) {
            if(er.get(j).orderdraw == num)
            {
            currentRect = (myRect) (er.get(j));
           
            g.setColor(white);
             
            g.fillRect(currentRect.xStart, currentRect.yStart, 20, 20);
            g.drawRect(currentRect.xStart, currentRect.yStart, 20, 20);
            }
        }


    }
       }
    // TODO overwrite start(), stop() and destroy() methods
}
