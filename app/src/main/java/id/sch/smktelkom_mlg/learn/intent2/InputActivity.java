package id.sch.smktelkom_mlg.learn.intent2;

import android.annotation.TargetApi;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {

    public static final String NAMA = "Nama";
    public static final String TAHUN_LAHIR = "TahunLahir";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        findViewById(R.id.buttonInput).setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                EditText etNama = (EditText) findViewById(R.id.editTextName);
                EditText etThnLhr = (EditText) findViewById(R.id.editTextThnLhr);
                String nama = etNama.getText().toString();
                String thnLhrStr = etThnLhr.getText().toString();
                int thnLhr = thnLhrStr.isEmpty()?Calendar.getInstance().get(Calendar.YEAR):Integer.parseInt(thnLhrStr);
                Intent intent = new Intent();
                intent.putExtra(NAMA,nama);
                intent.putExtra(TAHUN_LAHIR,thnLhr);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
