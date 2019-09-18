  int x;
  int y;
  int x2;
  int y2;
void setup() {
  size(640, 360);
  background(100);
}
boolean press = false;
void draw() {

  if(keyPressed && key == 'r' || key == 'R'){
    stroke((100));
  } else {
    stroke(255);
}
  if (mousePressed == true) {
    line(mouseX, mouseY, pmouseX, pmouseY);
    x = mouseX + 10;
    y = mouseY;
    x2 = pmouseX + 10;
    y2 = pmouseY;
    line(x,y,x2,y2);
  } 
}

void keyPressed(){
  if(key == 'N' || key == 'n'){
    save("saveTest.png");
  }
}
