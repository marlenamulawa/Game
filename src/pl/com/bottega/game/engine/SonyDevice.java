package pl.com.bottega.game.engine;

public class SonyDevice implements SoundDevice {
    @Override
    public void playSound() {
        System.out.println("Sony plays punk-rock music");
    }
}
