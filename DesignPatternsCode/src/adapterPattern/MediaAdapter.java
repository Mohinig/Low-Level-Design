package adapterPattern;

public class MediaAdapter implements MediaPlayer{
    AdavancedMediaPlayer adavancedMediaPlayer;
    public MediaAdapter(String audioType) {
        if(audioType.equalsIgnoreCase("vlc")){
            adavancedMediaPlayer=new VlcMediaPlayer();
        }
        else if(audioType.equalsIgnoreCase("mp4")){
            adavancedMediaPlayer=new Mp4MediaPlayer();
        }
    }
    public void play(String audioType,String fileName){
        if (audioType.equalsIgnoreCase("vlc")) {
            adavancedMediaPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            adavancedMediaPlayer.playMp4(fileName);
        }
    }
}
