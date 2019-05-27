int spacing = 20;
int x = 0;
int y = 0;
void setup(){
  size(500,500);
  background(0);
}
// UNCOMMENT IF YOU WANT TO MESS AROUND
void draw(){
  stroke(255);
  if(random(1) < 0.9){
    //line(x, y, x +spacing, y + spacing);
    //rect(x, y, 20, 20);
    //triangle(5+x, 15+y, 12+x, 5+y, 15+x, 10+y);
  } else {
    //line(x,y + spacing, x +spacing, y);
    //triangle(x, 15+y, 1+x, 5+y, 5+x, 10+y);
}
  x += spacing;
  if(x > width){
    x = 0;
    y += spacing;
  }
}
