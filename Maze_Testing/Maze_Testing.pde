int spacing = 20;
int x = 0;
int y = 0;
boolean thing = true;
void setup(){
  size(500,800);
  background(0);
}
// UNCOMMENT IF YOU WANT TO MESS AROUND
void draw(){
  maker();
}

void maker(){
  stroke(255);
  while(thing){
  if(random(1) < 0.36){
    //line(x, y+30, x +spacing, y + spacing+30);
    rect(x, y+30, 20, 20);
    //triangle(5+x, 15+y, 12+x, 5+y, 15+x, 10+y);
  } else {
    //line(x,y+30 + spacing, x +spacing, y+30);
    //triangle(x, 15+y, 1+x, 5+y, 5+x, 10+y);
}
  x += spacing;
  if(x > width){
    x = 0;
    y += spacing;
  }
  if(y > height/1.1){
    thing = false;
  }
  }
}
