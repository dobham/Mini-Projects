int numRow = 5;
int numCol = 5;
static boolean hover = false;
mapBox[][] listBox = new mapBox[numRow][numCol];
void setup(){
  rectMode(CENTER);
  size(1000,1000);
  for(int i = 0, spacerX = 0;  i<numRow; i++, spacerX +=50){
    for (int y = 0, spacerY = 0; y<numCol; y++, spacerY += 50){
      listBox[i][y] = (new mapBox(50, 50, spacerX, spacerY));
    }
  }
  noLoop();
}

void draw(){
  for(int i=0; i < numRow; i++){
    for(int y=0; y < numCol; y++){
      listBox[i][y].drawBox();
    }
  }
}

//void update(){
//  for(int i=0; i < numRow; i++){
//     for(int y=0; y < numCol; y++){
//         if(listBox[i][y].mapBoxHover()){
//            hover = true;
//         } else hover = false;  
//       }
// }
//}

void mouseMoved(){
  //update();
  //if(hover){
  //  System.out.print("god damn it0");
  //} else System.out.print("gOD");
  for(int i=0; i < numRow; i++){
     for(int y=0; y < numCol; y++){
         if(listBox[i][y].mapBoxHover()){
           listBox[i][y].hover();
         }
         
   }
   
}
redraw();
}

void mousePressed(){
  //update();
  //if(hover){
  //  System.out.print("god damn it0");
  //} else System.out.print("gOD");
  for(int i=0; i < numRow; i++){
     for(int y=0; y < numCol; y++){
         if(listBox[i][y].mapBoxHover()){
           listBox[i][y].click();
           redraw();
         }
   }
}
}

class mapBox{
  private int xLen, yLen;
  private int xLoc, yLoc;
  private boolean isHover; 
  private boolean isClick;
  private int colourOn = 120, colourOff = 50, colourClick = 255;
  public mapBox(int x, int y, int xx, int yy){
    xLen = x;
    yLen = y;
    xLoc = xx;
    yLoc = yy;  
    isHover = false;
  }
  boolean hover(){
    return isHover = !isHover;
  }
  boolean click(){
    return isClick = !isClick;
  }
  boolean mapBoxHover(){
      return (mouseX > xLoc - xLen/2 && mouseX <  xLoc + xLen/2) && (mouseY > yLoc - yLen/2 && mouseY < yLoc + yLen/2);
  }
  void drawBox(){
    fill(isHover && isClick ? colourClick : (isClick && !isHover ? colourClick : (!isClick && isHover ? colourOn : colourOff)));
    rect(xLoc, yLoc, xLen, yLen);
  }
}
