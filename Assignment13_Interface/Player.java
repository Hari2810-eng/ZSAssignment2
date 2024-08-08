interface Playable {
    void play();
    void pause();
    void stop();    
}

class MP3Player implements Playable{
    public void play(){
        System.out.println("MP3Player is playing!");
    }
    public void pause(){
        System.out.println("MP3Player is paused");
    }
    public void stop(){
        System.out.println("MP3Player is stopped");
    }
}

class CDPlayer implements Playable{
    public void play(){
        System.out.println("CDPlayer is playing! ");
    }
    public void pause(){
        System.out.println("CDPlayer is paused! ");
    }
    public void stop(){
        System.out.println("CDPlayer is stopped! ");
    }
}

class StreamingPlayer implements Playable{
    public void play(){
        System.out.println("StreamingPlayer is playing!");
    }
    public void pause(){
        System.out.println("StreamingPlayer is paused");
    }
    public void stop(){
        System.out.println("StreamingPlayer is stopped");
    }
}
public class Player {
    public static void main(String[] args) {
        Playable mp3 = new MP3Player();
        Playable cd = new CDPlayer();
        Playable streaming = new StreamingPlayer();

        mp3.play();
        mp3.pause();
        mp3.stop();

        cd.play();
        cd.pause();
        cd.stop();

        streaming.play();
        streaming.pause();
        streaming.stop();
    }
}

