float posx;
float posy;
float rad;
float max = 300;
int i = 0;
int r = 100;
ArrayList<Circles> CirclesList = new ArrayList<Circles>();
void setup(){
  frameRate(10);
  background(93,221,255);
  size(1920,1080);
}


void draw(){
  stroke(0,0200);
  fill(255,255,255,150);
  strokeWeight(random(1,2));
  CirclesList.add(new Circles(random(0,width), random(9,height), random(0,200)));
  //CirclesList.get(i).drawCircle();
  //i++;
  if(r < 0){
    
  }
  
}

public class Circles{
  float X;
  float Y;
  float R;
  public Circles(float x, float y, float r){
    X = x;
    Y = y;
    R = r;
  }
  void ChangeR(){
    R+=10;
  }
  void drawCircle(){
    for(int f=0;f<100;f++){
      ChangeR();
      ellipse(X,Y,R,R);
    }
  }
}
