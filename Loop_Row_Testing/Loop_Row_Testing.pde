float x = 1;
int y =1;
int dist = 300;
float smooth = 0.05;
boolean click = false;
void setup(){
  background(0);
  size(1000,1000);
}
void draw(){
   fill(255);
   if(click){
     for(int i = 0; i < 20; i++){
       x += 1;
       rect(x,y,50,50);
       if (x == width){
         x=0;
         y+=50;
       }
     }
   } else {rect(x,0,50,50);}
   
}

void mousePressed(){
    click = true;
}
void mouseReleased(){
  click = false;
}
