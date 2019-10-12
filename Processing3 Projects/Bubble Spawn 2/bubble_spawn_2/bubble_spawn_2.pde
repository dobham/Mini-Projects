ArrayList<Bubble> bubbles= new ArrayList<Bubble>();
ArrayList<Integer> toRemove = new ArrayList<Integer>();
void setup(){
  size(800,600);
  surface.setResizable(true); 
}

void draw(){
  background(#4f4f4f);
  float x = random(width),y = random(height),r = 50+random(20);
  for(int i=0; i<3; i++)
    bubbles.add(new Bubble(x,y,r-i*10));
  for(Bubble bubble: bubbles){
    if(bubble.check())
      toRemove.add(bubbles.indexOf(bubble));
    bubble.grow();
    bubble.show();
  }
  for(int i: toRemove)
    if(bubbles.get(i).check())
      if(bubbles.size()>height*width/15000)
        bubbles.remove(i);
      else
        bubbles.get(i).reset(random(width),random(height));
   println(height,width);
}

public class Bubble{
  float x,y;
  float r = -1,max,a=random(0.9,1);
  public Bubble(float x, float y,float max){
    this.x = x;
    this.y = y;
    this.max = max;
  }
  void grow(){
    r+=a;
  }
  void show(){
    
    strokeWeight(3);
    noFill();
    stroke(255,255,255,255*(1-r/max));
    ellipse(x,y,r,r);
   
  }
  void reset(float x, float y){
    this.x = x;
    this.y = y;
    this.r = 0;
  }
  boolean check(){
    return this.r>this.max;
  }
}
