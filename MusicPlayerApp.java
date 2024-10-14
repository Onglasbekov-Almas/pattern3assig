// AudioPlayer interface
interface AudioPlayer {
    void play(String audioType, String fileName);
}

// MP3Player class
class MP3Player implements AudioPlayer {
    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file. Name: " + fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}
interface WAVPlayer {
    void playWAV(String fileName);
}

interface AACPlayer {
    void playAAC(String fileName);
}

// AdvancedAudioPlayer class
class AdvancedAudioPlayer implements WAVPlayer, AACPlayer {
    @Override
    public void playWAV(String fileName) {
        System.out.println("Playing wav file. Name: " + fileName);
    }

    @Override
    public void playAAC(String fileName) {
        System.out.println("Playing aac file. Name: " + fileName);
    }
}

class AudioAdapter implements AudioPlayer {
    AdvancedAudioPlayer advancedAudioPlayer;

    public AudioAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("wav")) {
            advancedAudioPlayer = new AdvancedAudioPlayer();
        } else if (audioType.equalsIgnoreCase("aac")) {
            advancedAudioPlayer = new AdvancedAudioPlayer();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("wav")) {
            advancedAudioPlayer.playWAV(fileName);
        } else if (audioType.equalsIgnoreCase("aac")) {
            advancedAudioPlayer.playAAC(fileName);
        }
    }
}

// MusicPlayerApp class
class MusicPlayerApp {
    public static void main(String[] args) {
        AudioPlayer mp3Player = new MP3Player();
        mp3Player.play("mp3", "song1.mp3");

        AudioPlayer wavAdapter = new AudioAdapter("wav");
        wavAdapter.play("wav", "song2.wav");

        AudioPlayer aacAdapter = new AudioAdapter("aac");
        aacAdapter.play("aac", "song3.aac");
    }
}
