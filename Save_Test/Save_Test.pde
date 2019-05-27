  
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
  } 
}

void keyPressed(){
  if(key == 'N' || key == 'n'){
    save("saveTest.png");
  }
}

// line(20, 20, 80, 80);
//// Saves a TIFF file named "diagonal.tif"
//save("diagonal####.png");
//// Saves a TARGA file named "cross.tga"
//line(80, 20, 20, 80);
//textSize(32);
//text("word", 10, 30); 
//save("cross####.png");
