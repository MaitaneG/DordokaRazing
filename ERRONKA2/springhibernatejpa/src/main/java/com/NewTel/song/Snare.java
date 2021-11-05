package com.NewTel.song;

import javax.sound.sampled.*;
import java.io.File;

public class Snare extends Thread {
    @Override
    public void run() {
        super.run();
        try {

            File sound = new File("sounds/Snare_3-022.wav");//"sounds/Download_succeed.wav"
            AudioInputStream stream;
            AudioFormat format;
            DataLine.Info info;
            Clip clip;

            stream = AudioSystem.getAudioInputStream(sound);
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            clip.start();
        }
        catch (Exception e) {
            //whatevers
            e.printStackTrace();
        }

    }
}