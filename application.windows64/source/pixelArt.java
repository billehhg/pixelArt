import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class pixelArt extends PApplet {

float[] h=new float[(50*50)+1];
float[] s=new float[(50*50)+1];
float[] v=new float[(50*50)+1];
boolean paint=false;
boolean toggled=true;
int x=0;
int y=0;
int ch=100;
int cs=70;
int cv=100;
public void setup(){
  
  colorMode(HSB,360,50,50);
  for(int i=0; i<=(50*50);i++){
    h[i]=325;
    s[i]=70;
    v[i]=70;
  }
}
public void keyPressed(){
  if(key=='l'||keyCode==RIGHT){  x+=1; if(x>=50){x-=50;}  }
  if(key=='h'||keyCode==LEFT){  x-=1; if(x<0){x+=50;} }
  if(key=='j'||keyCode==DOWN){  y+=1; if(y>=50){y-=50;}  }
  if(key=='k'||keyCode==UP){  y-=1; if(y<0){y+=50;} }
  if(key=='0'){  x=0;   y=0;  }
  if(key=='9'){  y=0;  }
  if(key=='8'){  x=0;  }
  if(key=='q'){  ch+=15; if(ch>360){ch-=360;} }
  if(key=='a'){  ch-=15; if(ch<0){ch+=360;} }
  if(key=='w'&&cs<100){  cs+=5; }
  if(key=='s'&&cs>0){  cs-=5; }
  if(key=='e'&&cv<100){  cv+=5; }
  if(key=='d'&&cv>0){  cv-=5; }
  if(key==RETURN||key==ENTER){  x=-1; saveFrame("screenshot-######.png"); }
  if(key=='p'){if(paint){paint=false;}else{paint=true;} }
  if(key=='P'){if(paint){paint=false; toggled=true; }else{paint=true; toggled=false; } }
  if(keyCode==BACKSPACE){ setup(); }
}
public void mouseDragged(){
  x=mouseX/10;
  y=mouseY/10;
  paint=true;
}
public void mouseReleased(){
  paint=false;
}
public void draw(){ 
  int iii=0;
  for(int a=0;a<=49;a++){
    for(int b=0;b<=49;b++){
      noStroke();
      fill(h[iii],s[iii],v[iii]);
      if(x==a && y==b){
        stroke(0);
        if(paint){h[iii]=ch;s[iii]=cs;v[iii]=cv; if(toggled){paint=false;} }
        fill(ch,cs,cv);
      }
      rect(a*10,b*10,10,10);
      iii++;
    }
  }
}
  public void settings() {  size(500,500); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "pixelArt" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
