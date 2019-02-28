package fantasticbaking.com.jge.jokeandroidlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        String neatAJokeFromJavaLib = getIntent().getStringExtra("joke");
        //Toast.makeText(this, neatAJokeFromJavaLib, Toast.LENGTH_SHORT).show();

        TextView tv = findViewById(R.id.textView);
        tv.setText(neatAJokeFromJavaLib);
    }
}
