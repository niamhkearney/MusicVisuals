package c19382781;

import processing.core.*;

public class Waveform {

    NiamhsVisual nv;
    float cy = 0;

    public Waveform(NiamhsVisual nv) {

        this.nv = nv;
        cy = this.nv.height / 2;
    }

    public void render() {

        float lerpedAverage = 0;
        float average = 0;
        float sum = 0;

        for (int i = 0; i < nv.getAudioBuffer().size(); i++) {
            sum += PApplet.abs(nv.getAudioBuffer().get(i));
        }
        average = sum / nv.getAudioBuffer().size();

        lerpedAverage = PApplet.lerp(lerpedAverage, average, 0.1f);

        float r = 1f;
        int numPoints = 3;
        float thetaInc = PApplet.TWO_PI / (float) numPoints;
        nv.strokeWeight(2);
        float lastX = nv.width / 2, lastY = nv.height / 2;
        for (int i = 0; i < 1000; i++) {
            float c = PApplet.map(i, 0, 300, 0, 255) % 255.0f;
            nv.stroke(c, 255, 255, 100);
            float theta = i * (thetaInc + lerpedAverage * 5);
            float x = nv.width / 2 + PApplet.sin(theta) * r;
            float y = nv.height / 2 - PApplet.cos(theta) * r;
            r += 0.5f + lerpedAverage;
            nv.line(lastX, lastY, x, y);
            lastX = x;
            lastY = y;
        }

    }

}
