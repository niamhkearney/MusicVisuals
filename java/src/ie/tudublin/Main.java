package ie.tudublin;

//import example.CubeVisual;
import c19382781.NiamhsVisual;
//import example.RotatingAudioBands;

public class Main {

	public void startUI() {
		String[] a = { "MAIN" };
		processing.core.PApplet.runSketch(a, new NiamhsVisual());
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.startUI();
	}
}