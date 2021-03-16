import com.sun.jna.NativeLibrary;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import uk.co.caprica.vlcj.test.basic.PlayerControlsPanel;
import uk.co.caprica.vlcj.test.basic.PlayerVideoAdjustPanel;

import javax.print.attribute.standard.Media;
import javax.swing.*;
import javax.xml.datatype.Duration;
import java.awt.*;


public class SrodkowyPanel{

    public Media media;
    public MediaPlayer playa;
    public Duration time;
    public EmbeddedMediaPlayer mediaPlayer;
    public EmbeddedMediaPlayerComponent component;
    public MediaPlayerFactory mediaPlayerFactory;


    public SrodkowyPanel (JFrame okno) {
        JPanel panel = new JPanel();
        panel.setBounds(230,10,724,620);
        panel.setBackground(Color.lightGray);
        okno.add(panel);
        panel.setLayout(new BorderLayout());

        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(),"C:\\Program Files\\VideoLAN\\VLC");
        component = new EmbeddedMediaPlayerComponent();

        Canvas canvas = new Canvas();
        canvas.setBackground(Color.black);

        mediaPlayerFactory = new MediaPlayerFactory();
        mediaPlayer = component.getMediaPlayer();
        mediaPlayer.setVideoSurface(mediaPlayerFactory.newVideoSurface(canvas));
        mediaPlayer.setPlaySubItems(true);
        panel.add(canvas, BorderLayout.CENTER);
        canvas.setVisible(true);

        final PlayerControlsPanel controlsPanel = new PlayerControlsPanel(mediaPlayer);

        panel.add(controlsPanel, BorderLayout.SOUTH);




    }

    public void play(String filepath){

        String[] opts = {};
        mediaPlayer.playMedia(filepath, opts);

    }

    public void cut(){

        String[] opts = {":sout=#transcode{vcodec=mp4v,vb=4096,scale=1,acodec=mp4a,ab=128,channels=2,samplerate=44100}:duplicate{dst=file{dst=output.mp4},dst=display}", ":input-slave=alsa://hw:0,0"};
//        double time = mediaPlayer.getTime();
//
//
//        System.out.println(time);
//        String[] opts2 = new String[opts.length];
//        opts2[opts2.length-1] = ":start-time=" + time/1000;
//        for(int i = 0; i < opts2.length-1; i++){
//            opts2[i] = opts[i];
//        }

        mediaPlayer.playMedia(GUI.lewyPanel.pliki[LewyPanel.FILE_PATH].elementAt(GUI.lewyPanel.list.getSelectedIndex()), opts);

    }



}
