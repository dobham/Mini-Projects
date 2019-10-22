static final int MAX = 2, GAP = 50, DIM = 120, RAD = DIM >> 1;
int page, cx, cy;
Button back, next;
     private int y, x;
    private int randSize;
    private int yDist1,xDist1,yDist2,xDist2,yDist3,xDist3,yDist4,xDist4,yDist5,xDist5,yDist6,xDist6,yDist7,xDist7;
    private boolean circleOver1,circleOver2,circleOver3,circleOver4,circleOver5,circleOver6,circleOver7,circleOver8;
    private boolean click1,click2,click3,click4,click5,click6,click7,click8;
    private float smoothScale1, smoothScale2, smoothScale3, smoothScale4, smoothScale5, smoothScale6, smoothScale7, smoothScale8;
void setup() {
   size(1000,800);
 
  //frameRate(50);
  //noLoop();
  smooth();
 
  rectMode(CORNER);
  ellipseMode(CENTER);
  textAlign(CENTER, CENTER);
 
  stroke(0);
  strokeWeight(1.5);
 
  cx = width  >> 1;
  cy = height >> 1;
 
  back = new Button("BACK", GAP, height - Button.H - GAP);
  next = new Button("NEXT", width - Button.W - GAP, height - Button.H - GAP);
  
  randSize = width/8;
        x = (int)random(width);
        y = 25;
        smoothScale1 = smoothScale2 = smoothScale3 = smoothScale4 = smoothScale5 = smoothScale6 = smoothScale7 = smoothScale8 = width/8;
        ellipseMode(CENTER);
}
 
void draw() {
  background(0300);
 // textSize(0100);
 // fill(Button.TXTC);
 // text("Page #" + page, cx, cy);
 // textSize(Button.TXTSZ);
 // if (page > 0)    back.display();
 // if (page < MAX)  next.display();
 // //method("page" + page); // Java only!
  pageSelector();        // For JS!
}
 
void mousePressed() {
  if      (page > 0   && back.isHovering)  --page;
  else if (page < MAX && next.isHovering)  ++page;
 
}
 
void mouseMoved() {
  back.isInside();
  next.isInside();

}
 
void page0() {
  background(0);
        fill(127,0,0);
        if(click1){
            for(int i = 0; i < width/8; i+=1000){
                smoothScale1 -= 8;
                circleCreate(x, y, smoothScale1);
            }
        } else circleCreate(x, y, randSize);
        if(click2){
            for(int i = 0; i < width/8; i+=1000){
                smoothScale2 -= 8;
                circleCreate(xDist1, y+yDist1, smoothScale2);
            }
        } else circleCreate(xDist1, y+yDist1, randSize);
        if(click3){
            for(int i = 0; i < width/8; i+=1000){
                smoothScale3 -= 8;
                circleCreate(xDist2, y+yDist2, smoothScale3);
            }
        } else circleCreate(xDist2, y+yDist2, randSize);
        if(click4){
            for(int i = 0; i < width/8; i+=1000){
                smoothScale4 -= 8;
                circleCreate(xDist3, y+yDist3, smoothScale4);
            }
        } else circleCreate(xDist3, y+yDist3, randSize);
        if(click5){
            for(int i = 0; i < width/8; i+=1000){
                smoothScale5 -= 8;
                circleCreate(x+xDist4, y+yDist4, smoothScale5);
            }
        } else circleCreate(x+xDist4, y+yDist4, randSize);
        if(click6){
            for(int i = 0; i < width/8; i+=1000){
                smoothScale6 -= 8;
                circleCreate(x+xDist5, y+yDist5, smoothScale6);
            }
        } else circleCreate(x+xDist5, y+yDist5, randSize);

        if(click7){
            for(int i = 0; i < width/8; i+=1000){
                smoothScale7 -= 8;
                circleCreate(x+xDist6, y+yDist6, smoothScale7);
            }
        } else circleCreate(x+xDist6, y+yDist6, randSize);
        if(click8){
            for(int i = 0; i < width/8; i+=1000){
                smoothScale8 -= 8;
                circleCreate(x+xDist7, y+yDist7, smoothScale8);
            }
        }
        else circleCreate(x+xDist7, y+yDist7, randSize);

        //Possibly add a system where each individual circle that goes above the respawn line is SEPERATLY spawned in
        //Will greatly improve looks
      if (page > 0)    back.display();
      if (page < MAX)  next.display();
        if(y < (-yDist6-100)){
            x = (int)random(width);
            y = height;
            yDist1 = xDist1 = (int)(50 + random(100));
            yDist2 = xDist2 = (int)(150 + random(200));
            yDist3 = xDist3 = (int)(250 + random(300));
            yDist4 = xDist4 = (int)(350 + random(400));
            yDist5 = xDist5 = (int)(450 + random(300));
            yDist6 = xDist6 = (int)(550 + random(200));
            yDist7 = xDist7 = (int)(650 + random(100));
            click1 = click2 = click3 = click4 = click5 = click6 = click7 = click8 = false;
            smoothScale1 = smoothScale2 = smoothScale3 = smoothScale4 = smoothScale5 = smoothScale6 = smoothScale7 = smoothScale8 = width/8;
        }
        y-=10;
}
 private void circleCreate(float x, float y, float randomSize){
        ellipse((x), (y), randomSize, randomSize);
    }
void page1() {
  fill(#FFFF00);
  rect(cx - RAD, GAP*2 - RAD, DIM, DIM);
}
 
void page2() {
  fill(#008000);
  triangle(cx, GAP*2 - RAD, cx - RAD, GAP*2 + RAD, cx + RAD, GAP*2 + RAD);
}
 
void pageSelector() {
  switch(page) {
  case 0: 
    page0();
    break;
 
  case 1: 
    page1();
    break;
 
  case 2: 
    page2();
  }
}
 
class Button {
  static final int W = 60, H = 40, TXTSZ = 020;
  static final color BTNC = #00A0A0, HOVC = #00FFFF, TXTC = 0;
 
  final String label;
  final short x, y, xW, yH;
 
  boolean isHovering;
 
  Button(String txt, int xx, int yy) {
    label = txt;
 
    x = (short) xx;
    y = (short) yy;
 
    xW = (short) (xx + W);
    yH = (short) (yy + H);
  }
 
  void display() {
    fill(isHovering? HOVC:BTNC);
    rect(x, y, W, H);
 
    fill(TXTC);
    text(label, x + W/2, y + H/2);
  }
 
  boolean isInside() {
    return isHovering = mouseX > x & mouseX < xW & mouseY > y & mouseY < yH;
  }
}
