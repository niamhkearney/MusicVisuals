package c19382781;

import ie.tudublin.*;

public class NiamhsVisual extends Visual {

    float[] lerpedBuffer;

    public void settings() {
        size(1024, 650);

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

        switch (mode) {
        case 0: {
            noStroke();
            fill(88, 200, 115);
            rect(512, 300, 30, 330); // x, y, width, height

            // Petals
            fill(0, 230, 220);
            ellipse(450, 300, 160, 50); // x, y, width, height
            ellipse(600, 300, 160, 50); // x, y, width, height
            ellipse(527, 400, 50, 160); // x, y, width, height
            ellipse(527, 200, 50, 160); // x, y, width, height

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
