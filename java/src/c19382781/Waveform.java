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

        nv.colorMode(PApplet.HSB);
        for (int i = 0; i < nv.getAudioBuffer().size(); i += 6) {
            nv.stroke(PApplet.map(i, 0, nv.getAudioBuffer().size(), 0, 255), 255, 255);

            // nv.line(i, cy, i, cy + cy * nv.getAudioBuffer().get(i));
            nv.rect(i, cy, 5, +cy * nv.getAudioBuffer().get(i));
        }

    }

}
