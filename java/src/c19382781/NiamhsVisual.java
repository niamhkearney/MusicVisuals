package c19382781;

import ie.tudublin.*;

public class NiamhsVisual extends Visual {

    public void settings() {
        size(1024, 500);

        // Use this to make fullscreen
        // fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        // fullScreen(P3D, SPAN);
    }

    int mode = 0;

    public void setup() {
        startMinim();

        // Call loadAudio to load an audio file to process
        loadAudio("backyardboy.mp3");

        // Call this instead to read audio from the microphone
        // startListening();

    }

    public void keyPressed() {
        if (key == ' ') {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }

        if (keyCode >= '0' && keyCode <= '9') {
            mode = keyCode - '0';
        }
    }

    public void draw() {
        background(0);
        noStroke();

        try {
            // Call this if you want to use FFT data
            calculateFFT();
        } catch (VisualException e) {
            e.printStackTrace();
        }

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();
    }
}
