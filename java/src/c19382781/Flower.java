package c19382781;

import processing.core.*;

public class Flower {

    NiamhsVisual nv;

    public Flower(NiamhsVisual nv) {
        this.nv = nv;
    }

    float[] lerpedBuffer;

    public void render() {

        nv.camera();

        lerpedBuffer = new float[nv.width];
        float halfHeight = nv.height / 3;
        nv.colorMode(PApplet.HSB);

        // Flower
        nv.noStroke();

        if (nv.mouseButton == PApplet.LEFT) {
            nv.fill(255); // White
        } else if (nv.mouseButton == PApplet.RIGHT) {
            nv.fill(140, 200, 200); // Blue
        } else {
            nv.fill(3, 230, 250); // Red
        }

        // move flower to the middle of the screen
        nv.translate(nv.width / 2, nv.height / 2);

        for (int i = 0; i < nv.getAudioBuffer().size(); i++) {

            lerpedBuffer[i] = PApplet.lerp(lerpedBuffer[i], nv.getAudioBuffer().get(i), 0.50f);

            // Petals

            nv.ellipse(0, -50, halfHeight - lerpedBuffer[i] * halfHeight * 4,
                    halfHeight + lerpedBuffer[i] * halfHeight * 4);
            nv.rotate(PApplet.radians(45));

        }

        // Center
        nv.fill(50, 200, 220);
        nv.circle(0, 0, 100);

    }
}
