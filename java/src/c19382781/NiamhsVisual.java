package c19382781;

//import ddf.minim.AudioBuffer;
import ie.tudublin.*;

public class NiamhsVisual extends Visual {

    Flower fl;
    Shape sh;
    Waveform wf;

    public void settings() {
        size(1024, 650, P3D);

        // Use this to make fullscreen
        // fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        // fullScreen(P3D, SPAN);
    }

    int mode = 0;

    public void setup() {

        colorMode(HSB);
        startMinim();

        // Call loadAudio to load an audio file to process
        loadAudio("heykids.mp3");

        fl = new Flower(this);
        sh = new Shape(this);
        wf = new Waveform(this);

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

    public void draw() {
        background(0);

        switch (mode) {
        case 0: {

            textSize(32);
            text("Press spacebar to play music", 10, 30);

            break;
        }
        case 1: {
            sh.render();
            break;
        }
        case 2: {
            fl.render();
            break;
        }
        case 3: {
            wf.render();
            break;
        }
        }

        try {
            // Call this if you want to use FFT data
            calculateFFT();
        } catch (VisualException e) {
            e.printStackTrace();
        }

        // Call this is you want to use frequency bands
        calculateFrequencyBands();

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();
    }
}
