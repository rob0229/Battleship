import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;

import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;



public class Sounds extends Thread {
	//Sound Methods
	 URL url;
			  public void run(int i) {
				
				switch(i){
				case 1: // hit()
					url = this.getClass().getClassLoader().getResource("DepthCharge.wav");
					break;
				case 2: // ready()
					url = this.getClass().getClassLoader().getResource("Quarters.wav");
					break;
				case 3: // win()
					url = this.getClass().getClassLoader().getResource("Aweigh.wav");
					break;
				case 4: // lose()
					url = this.getClass().getClassLoader().getResource("GameOver.wav");
					break;
				case 5: // battleship
					url = this.getClass().getClassLoader().getResource("SunkB.wav");
					break;
				case 6:	// sunk ship
					url = this.getClass().getClassLoader().getResource("Doh.wav");
					break;
				case 7:
					url = this.getClass().getClassLoader().getResource("Bacon.wav");
					break;
				default: // miss
					url = this.getClass().getClassLoader().getResource("Splash.wav");
					break;
				}
			  
				try {
					AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
					
					Clip clip = AudioSystem.getClip();
					clip.open(audioIn);
					clip.start();
					
					
				      } catch (UnsupportedAudioFileException e) {
				          e.printStackTrace();
				       } catch (IOException e) {
				          e.printStackTrace();
				       } catch (LineUnavailableException e) {
				           e.printStackTrace();
				       }
			  }
			  public void easteregg(){
				  laser();
			  }

			  public void laser() {
			    int repeat = 5;
			    try {
			      AudioFormat af = new AudioFormat(8000f, // sampleRate
			          8, // sampleSizeInBits
			          1, // channels
			          true, // signed
			          false); // bigEndian
			      SourceDataLine sdl;
			      sdl = AudioSystem.getSourceDataLine(af);
			      sdl.open(af);
			      sdl.start();

			      byte[] buf = new byte[1];
			      int step;

			      for (int j = 0; j < repeat; j++) {
			        step = 10;
			        for (int i = 0; i < 2000; i++) {
			          buf[0] = ((i % step > 0) ? 32 : (byte) 0);

			          if (i % 250 == 0)
			            step += 2;
			          sdl.write(buf, 0, 1);
			        }
			        Thread.sleep(200);
			      }
			      sdl.drain();
			      sdl.stop();
			      sdl.close();
			    } catch (Exception e) {
			      e.printStackTrace();
			    }
			  }
			
	
		
		public void shoot(){
			URL url = this.getClass().getClassLoader().getResource("DepthCharge.wav");
			try {
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			
			Clip clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
			
			
		      } catch (UnsupportedAudioFileException e) {
		          e.printStackTrace();
		       } catch (IOException e) {
		          e.printStackTrace();
		       } catch (LineUnavailableException e) {
		           e.printStackTrace();
		       }
			
		}

}