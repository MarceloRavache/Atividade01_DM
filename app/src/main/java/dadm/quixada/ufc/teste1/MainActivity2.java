package dadm.quixada.ufc.teste1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ListView listView;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = findViewById(R.id.listview);

        ArrayList<String> list = new ArrayList<>();

        list.add("Teste1");
        list.add("Teste2");
        list.add("Teste3");
        list.add("Teste4");
        list.add("Teste5");
        list.add("Teste6");

        ArrayAdapter adapter3 = new ArrayAdapter(this, android.R.layout.simple_list_item_1,list);

        listView.setAdapter(adapter3);

    }
    public void play(View v){
        if(player == null){
            player = MediaPlayer.create(this, R.raw.wrong);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
                @Override
                public void onCompletion(MediaPlayer mp){
                    stopPlayer();
                }
            });
        }
        player.start();
    }
    public void pause(View v){
        if(player != null){
            player.pause();
        }
    }
    public void stop(View v){
        stopPlayer();
    }
    public void stopPlayer(){
        if(player != null){
            player.release();
            player = null;
            Toast.makeText(this,"MediaPlayer release", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onStop(){
        super.onStop();
        stopPlayer();
    }
}