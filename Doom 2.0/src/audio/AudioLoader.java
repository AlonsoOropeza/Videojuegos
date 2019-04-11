package audio;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioLoader {
	
	static AudioLoader audios;
	
	public static AudioLoader getSingletonInstance() {
		if(audios == null) 
			audios = new AudioLoader();
		return audios;
	}
	
	public static void play(String location) {
		try {
			File path = new File(location);
			if(path.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(path);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			}
			else {
				System.out.println("Cant find file at " + location);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

}


