int scale = 50;
void setup() {
  size(500, 500);
}

void draw() {
  rect(mouseX - scale/2, mouseY - scale/2, scale, scale);
} 

void mouseWheel(MouseEvent event) {
  float e = event.getCount();
  scale += e*5;
  fill(e*=2, e+=e, e+=e, e+=e);
}
