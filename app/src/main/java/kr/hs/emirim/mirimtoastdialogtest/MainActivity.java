package kr.hs.emirim.mirimtoastdialogtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textName, textEmail;       //activity_main.xml
    EditText editName, editEmail;       //ai
    TextView textToast;
    View dialogView, toastView;
    Button btnHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textName = findViewById(R.id.text_name);
        textEmail = findViewById(R.id.text_email);
        editName = findViewById(R.id.exit_name);
        editEmail = findViewById(R.id.exit_email);

        btnHere = findViewById(R.id.btn_here);
        btnHere.setOnClickListener((btnHereListener));
    }
    View.OnClickListener btnHereListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dialogView = View.inflate(MainActivity.this, R.layout.dialog,null);
            AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
            dlg.setTitle("사용자 정보 입력");
            dlg.setView(dialogView);
            dlg.setPositiveButton("확인", positiveButtonListener);
            dlg.setPositiveButton("취소", null);
            dlg.show();
        }
    };
    DialogInterface.OnClickListener positiveButtonListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            editName = dialogView.findViewById(R.id.exit_name);
            editEmail = dialogView.findViewById(R.id.exit_email);
            textEmail.setText(editEmail.getText().toString());
        }
    };
    DialogInterface.OnClickListener nagativeButtonListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Toast toast = new Toast(MainActivity.this);
            toastView = View.inflate(MainActivity.this, R.layout.toast1, null);
            textToast = findViewById(R.id.text_toast);
            textToast.setText("취소버튼을 누르셨네요");
            toast.setView(toastView);
            toast.show();
        }
    };
}