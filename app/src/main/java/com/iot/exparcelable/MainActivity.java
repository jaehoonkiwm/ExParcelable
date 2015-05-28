package com.iot.exparcelable;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private static final int REQUEST_CODE = 100;
    EditText etMsg;
    TextView tvMsg;
    String receiveMsg = null;

    public void onButtonClicked(View v){
        switch (v.getId()){
            case R.id.btnSave:
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                SimpleData simpleData = new SimpleData(etMsg.getText().toString());
                intent.putExtra("savemsg", simpleData);
                startActivityForResult(intent, REQUEST_CODE);
                break;
            case R.id.btnRead:
                tvMsg.setText(receiveMsg);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMsg = (EditText) findViewById(R.id.editText);
        tvMsg = (TextView) findViewById(R.id.textView2);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE)
            if (resultCode == RESULT_OK){
                receiveMsg = data.getStringExtra("receivemsg");
            }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
