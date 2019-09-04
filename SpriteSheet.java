import java.awt.image.BufferedImage;

public class SpriteSheet {

	BufferedImage[] frameArray;
	int frames;
	int currentFrameCount;
	int frameDelay;
	boolean playedOnce = false;
	boolean isChecking;

	public SpriteSheet(BufferedImage input, int aFrames) {
		frames = aFrames;
		boolean playedOnce = false;
		currentFrameCount = 0;
		frameDelay = 1;
		isChecking = false;

		frameArray = new BufferedImage[frames];

		for (int i = 0; i < frames; i++) {
			frameArray[i] = input.getSubimage(i * (input.getWidth() / frames), 0, (input.getWidth() / frames),
					input.getHeight());

		}
	}

	public BufferedImage loop() {
		currentFrameCount++;
		if (this.currentFrameCount / (frames * frameDelay) == 1 && isChecking) {
			playedOnce = true;

		} else {
			playedOnce = false;
		}

		currentFrameCount %= (frameDelay * frames);

		if (frameDelay == 11) {
			// System.out.println(currentFrameCount + ":" + frames + ":" + frameDelay + ":"
			// + Main.spikesheet.currentFrameCount/frameDelay);
		}
		return frameArray[currentFrameCount / frameDelay];

	}
	// loop will return the current frame and then move onto the next one
	// will need a boolean to make it only loop once so a condition setter
	// if the loop has played the last frame was played and if so, set playedOnce to
	// true
	// else set it to false

	public void changeFrameDelayTo(int input) {
		frameDelay = input;
	}

}
