package c19382781;

import processing.core.*;

public class Shape {

    NiamhsVisual nv;

    public Shape(NiamhsVisual nv) {
        this.nv = nv;
    }

    float smoothedBoxSize = 0;
    float smoothedBoxSize2 = 0;

    public void render() {

        nv.colorMode(PApplet.HSB);

        nv.calculateAverageAmplitude();
        nv.background(0);
        nv.noFill();
        nv.lights();
        nv.stroke(PApplet.map(nv.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        nv.camera(0, 0, 0, 0, 0, -3, 0, 1, 0);
        nv.translate(0, 0, -250);

        float boxSize = 50 + (nv.getAmplitude() * 300);
        smoothedBoxSize = PApplet.lerp(smoothedBoxSize, boxSize, 0.2f);

        float boxSize2 = 70 + (nv.getAmplitude() * 500);
        smoothedBoxSize2 = PApplet.lerp(smoothedBoxSize2, boxSize2, 0.5f);

        nv.rotateY(angle);
        nv.rotateX(angle);
        nv.strokeWeight(5);

        nv.box(smoothedBoxSize);

        nv.rotateY(angle - angle * 2);
        nv.rotateX(angle - angle * 2);

        nv.stroke(PApplet.map(nv.getSmoothedAmplitude() * 2, 0, 1, 0, 255), 255, 255);
        nv.box(smoothedBoxSize2);
        nv.sphereDetail(4, 4);
        nv.sphere(smoothedBoxSize2 * 2);

        nv.rotateY(angle - angle * 10);
        nv.rotateX(angle - angle * 10);

        nv.stroke(PApplet.map(nv.getSmoothedAmplitude() * 4, 0, 1, 0, 255), 255, 255);
        nv.fill(PApplet.map(nv.getSmoothedAmplitude() * 4, 0, 1, 0, 255), 255, 255);

        nv.box(smoothedBoxSize2 / 2);

        angle += 0.01f;
    }

    float angle = 0;

}
