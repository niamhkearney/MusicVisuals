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

        nv.camera();

        nv.noFill();

        nv.colorMode(PApplet.HSB);
        for (int i = 0; i < nv.getAudioBuffer().size(); i++) {
            nv.strokeWeight(1);
            nv.stroke(PApplet.map(i, 0, nv.getAudioBuffer().size(), 0, 255), 255, 255);

            nv.rotateX(cy * nv.getAudioBuffer().get(i));
            nv.arc(i + 250, cy, 9, cy * nv.getAudioBuffer().get(i), PApplet.PI + PApplet.QUARTER_PI, PApplet.TWO_PI);

            nv.rotateX(cy * nv.getAudioBuffer().get(i));
            nv.arc(i + 250, cy * 2, 9, (cy * 2) * nv.getAudioBuffer().get(i), PApplet.PI + PApplet.QUARTER_PI,
                    PApplet.TWO_PI);

        }
    }

}
