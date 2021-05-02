# Music Visualiser Project

Name: Niamh Kearney

Student Number: C19382781


# Description of the assignment

The objective of this assignment was to create "something beautiful while listening to music". I chose the song 'Backyard Boy' by Claire Rosinkranz to be played alongside the visuals.

The general idea of the visuals was for each one to be created with a lot of movement in mind to match the upbeat and energetic qualities of the song. Vibrant colours were also chosen given the song's positive tone.

For the visuals, the first one is made up of a very rough sphere containing several cubes of decreasing size, each cube stored in the middle of another. The cubes and spheres are all slowly spinning in different directions save for the smallest cube, which spins the fastest and is also the only shape that is filled in; the rest are wireframed. The size of each shape fluctuates with the song, along with their colour.

The second shape is a flower with petals that move with the song, taking on all sorts of different shapes. The flower petals are red by default, but can change to either blue or white if the left or right mouse button is held down.

The third and final shape is a shower of arcs that spread out and stretch with the music, creating a visual akin to rain pouring. The arcs come in a rainbow of different colours.

# Instructions

1. Run the program.

2. Pressing spacebar will start the music.

3. Visuals can be changed by pressing keys 1, 2 or 3.

4. Key 1 plays the cube visual.

5. Key 2 plays the flower visual. To change the colour of the flower, clicking into the program hold down either the left (white) or right (blue) mouse button. Letting go will return the flower to its default red.

6. Key 3 plays the arc waveform.

# How it works

NiamhsVisual extends the Visual class, allowing NiamhsVisual to access the processing methods offered in PApplet through inheritance. From then, each visual was created as its own class, being declared in NiamhsVisual.

```Java

public class NiamhsVisual extends Visual {

    Flower fl;
    Shape sh;
    Waveform wf;
    
    }

```

The classes are then initialised in ```setup().```

```Java
public void setup() {

        fl = new Flower(this);
        sh = new Shape(this);
        wf = new Waveform(this);
    }
```

Within each class file, NiamhsVisual is used as a parameter in a constructor. This allows the classes to use variables from within NiamhsVisual in its own code. This is done by using an instance of NiamhsVisual, in this case named ```NiamhsVisual nv```. 

```Java
public class Flower {

    NiamhsVisual nv;

    public Flower(NiamhsVisual nv) {
        this.nv = nv;
    }
}
```

These classes are called within NiamhsVisual under the ```draw()``` method using the ```render()``` method. These renders are written in a switch statement so that the user can switch between each visual as they like depending on which numbered key between 0 to 3 that they press.

```Java
 public void draw() {
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
```

# What I am most proud of in the assignment

I am most proud of the flower in this assignment. It went through a lot of edits to work properly and smoothly. In its early stages, the code was very long and clunky and took a lot of cleaning and whittling down to get to its current state. The reason it was so long was because I was drawing and rotating each petal individually, and given that there were 8 petals in total it made the code very long. I eventually decided to rewrite the code in a more intuitive manner, creating one singular petal and rotating it instead.

In the end, I really like how the shape changes so drastically as it plays alongside the music, as it started off exceedingly simple with several petals only changing in length rather than the entire shape of it changing. It makes it very interesting to look at.

# Images

![A different image](https://i.imgur.com/vPqHMel.png)
![A different image](https://i.imgur.com/NlKl7Yb.png)
![A different image](https://i.imgur.com/KMWnlVF.png)
![A different image](https://i.imgur.com/8FyBmDd.png)


# Youtube Video


[![YouTube](Youtube Video Link)](https://youtu.be/DxekyasOc7o)
