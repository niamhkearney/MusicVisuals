package c19382781;

import ddf.minim.AudioBuffer;
import ie.tudublin.*;

public class NiamhsVisual extends Visual {

    float[] lerpedBuffer;
    AudioBuffer ab;

    public void settings() {
        size(1024, 650, P3D);

        // Use this to make fullscreen
        // fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        // fullScreen(P3D, SPAN);
    }

    int mode = 0;
    float y = 200;
    float lerpedY = y;

    public void setup() {

        colorMode(HSB);
        startMinim();

        // Call loadAudio to load an audio file to process
        loadAudio("heykids.mp3");

        lerpedBuffer = new float[width];

    }

    public void keyPressed() {

        // Star music
        if (key == ' ') {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }

        // Choose visual based on number inputted
        if (keyCode >= '0' && keyCode <= '9') {
            mode = keyCode - '0';
        }
    }

    float lerpedAverage = 0;

    public void draw() {
        background(0);

        // float average = 0;
        // float sum = 0;
        float halfHeight = height / 3;

        switch (mode) {
        case 0: {

            // Flower

            // Stalk
            noStroke();
            fill(88, 170, 115);
            rect(512, 300, 30, 330); // x, y, width, height

            for (int i = 0; i < getAudioBuffer().size(); i++) {
                float c = map(i, 0, getAudioBuffer().size(), 0, 255);
                fill(c, 255, 255);
                lerpedBuffer[i] = lerp(lerpedBuffer[i], getAudioBuffer().get(i), 0.51f);

                // Petals
                // fill(0, 230, 220);
                ellipse(450, 300, halfHeight - lerpedBuffer[i] * halfHeight * 6, 50); // x, y, width, height
                ellipse(600, 300, halfHeight - lerpedBuffer[i] * halfHeight * 6, 50); // x, y, width, height
                ellipse(527, 400, 50, halfHeight - lerpedBuffer[i] * halfHeight * 6); // x, y, width, height
                ellipse(527, 200, 50, halfHeight - lerpedBuffer[i] * halfHeight * 6); // x, y, width, height

                pushMatrix();
                translate(460, 230);
                rotate(radians(45));
                ellipse(0, 0, halfHeight - lerpedBuffer[i] * halfHeight * 6, 50); // x, y, width, height
                popMatrix();

                pushMatrix();
                translate(595, 230);
                rotate(radians(135));
                ellipse(0, 0, halfHeight - lerpedBuffer[i] * halfHeight * 6, 50); // x, y, width, height
                popMatrix();

                pushMatrix();
                translate(595, 370);
                rotate(radians(225));
                ellipse(0, 0, halfHeight - lerpedBuffer[i] * halfHeight * 6, 50); // x, y, width, height
                popMatrix();

                pushMatrix();
                translate(460, 370);
                rotate(radians(315));
                ellipse(0, 0, halfHeight - lerpedBuffer[i] * halfHeight * 6, 50); // x, y, width, height
                popMatrix();
            }

            // Center
            fill(50, 200, 220);
            circle(527, 300, 100); // x, y, width
            break;
        }
        }

        /*
         * try { // Call this if you want to use FFT data calculateFFT(); } catch
         * (VisualException e) { e.printStackTrace(); }
         * 
         */

        // Call this is you want to get the average amplitude
        // calculateAverageAmplitude();
    }
}
