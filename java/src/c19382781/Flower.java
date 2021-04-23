package c19382781;

import processing.core.*;

public class Flower {

    NiamhsVisual nv;

    public Flower(NiamhsVisual nv) {
        this.nv = nv;
    }

    public void render() {
        float[] lerpedBuffer;
        lerpedBuffer = new float[nv.width];
        float halfHeight = nv.height / 3;

        nv.colorMode(PApplet.HSB);

        // Flower

        // Stalk
        nv.noStroke();

        for (int i = 0; i < nv.getAudioBuffer().size(); i++) {
            float c = PApplet.map(i, 0, nv.getAudioBuffer().size(), 0, 255);
            nv.fill(c, 255, 255);
            lerpedBuffer[i] = PApplet.lerp(lerpedBuffer[i], nv.getAudioBuffer().get(i), 0.51f);

            // Petals
            // fill(0, 230, 220);
            nv.ellipse(450, 300, halfHeight - lerpedBuffer[i] * halfHeight * 6, 50); // x, y, width, height
            nv.ellipse(600, 300, halfHeight - lerpedBuffer[i] * halfHeight * 6, 50); // x, y, width, height
            nv.ellipse(527, 400, 50, halfHeight - lerpedBuffer[i] * halfHeight * 6); // x, y, width, height
            nv.ellipse(527, 200, 50, halfHeight - lerpedBuffer[i] * halfHeight * 6); // x, y, width, height

            nv.pushMatrix();
            nv.translate(460, 230);
            nv.rotate(PApplet.radians(45));
            nv.ellipse(0, 0, halfHeight - lerpedBuffer[i] * halfHeight * 6, 50); // x, y, width, height
            nv.popMatrix();

            nv.pushMatrix();
            nv.translate(595, 230);
            nv.rotate(PApplet.radians(135));
            nv.ellipse(0, 0, halfHeight - lerpedBuffer[i] * halfHeight * 6, 50); // x, y, width, height
            nv.popMatrix();

            nv.pushMatrix();
            nv.translate(595, 370);
            nv.rotate(PApplet.radians(225));
            nv.ellipse(0, 0, halfHeight - lerpedBuffer[i] * halfHeight * 6, 50); // x, y, width, height
            nv.popMatrix();

            nv.pushMatrix();
            nv.translate(460, 370);
            nv.rotate(PApplet.radians(315));
            nv.ellipse(0, 0, halfHeight - lerpedBuffer[i] * halfHeight * 6, 50); // x, y, width, height
            nv.popMatrix();
        }

        // Center
        nv.fill(50, 200, 220);
        nv.circle(527, 300, 100); // x, y, width
    }
}
