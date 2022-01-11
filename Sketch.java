import processing.core.PApplet;

public class Sketch extends PApplet {
  float[] snowY = new float[30];

  float[] snowpiles = new float[30];

  int arraynum = 25;
  int[] posX = new int[arraynum];
  int[] posY = new int[arraynum];
  int index = 0;
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(400, 400);
    for (int i = 0; i < snowY.length; i++) {
      snowY[i] = random(height);
    }
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(210, 255, 173);
    noStroke();
    for (int i = 0; i < 30; i++){
      snowpiles[i] = 3;
    }
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    background(0);

    fill(255);
    if (keyCode == UP){
      for (int i = 0; i < snowY.length; i++) {
        float circleX = width * i / snowY.length;
        ellipse(circleX, snowY[i], 20, 20);

        snowY[i] += 3;

        if (snowY[i] > height) {
          snowY[i] = 0;
          snowpiles[i] += 5;
        }
      }
    } else if (keyCode == DOWN) {
      for (int i = 0; i < snowY.length; i++) {
        float circleX = width * i / snowY.length;
        ellipse(circleX, snowY[i], 20, 20);

        snowY[i]++;

        if (snowY[i] > height) {
          snowY[i] = 0;
          snowpiles[i] += 5;
        }
      }
    } else {
      for (int i = 0; i < snowY.length; i++) {
        float circleX = width * i / snowY.length;
        ellipse(circleX, snowY[i], 20, 20);

        snowY[i] += 2;

        if (snowY[i] > height) {
          snowY[i] = 0;
          snowpiles[i] += 5;
        }
      }
    }

    for (int i = 0; i < 30; i++){
      fill(255);
      rect(i*14, height-snowpiles[i], 8, height);
    }

    fill(255,102);
    posX[index] = mouseX;
    posY[index] = mouseY;
    index = (index + 1) % arraynum;

    for (int i = 0; i < arraynum; i++) {
      int pos = (index + i) % arraynum;
      ellipse(posX[pos], posY[pos], i, i);
    }
  }
}