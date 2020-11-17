package kr.hs.emirim.mirimtoastdialogtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Button no, btn_ck;
    EditText name, email;
    View dialogView, toastView;
    TextView textToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        no = findViewById(R.id.no);
        btn_ck = findViewById(R.id.btn_click);
        name = findViewById(R.id.edit_name);
        email = findViewById(R.id.edit_email);
        btn_ck.setOnClickListener(btnHereListener);
    }
    View.OnClickListener btnHereListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dialogView = View.inflate(MainActivity2.this, R.layout.dialog,null);
            AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity2.this);
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
            name = dialogView.findViewById(R.id.exit_name);
            email = dialogView.findViewById(R.id.exit_email);
            email.setText(email.getText().toString());
        }
    };
    DialogInterface.OnClickListener nagativeButtonListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Toast toast = new Toast(MainActivity2.this);
            toastView = View.inflate(MainActivity2.this, R.layout.toast1, null);
            textToast = findViewById(R.id.text_toast);
            textToast.setText("취소버튼을 누르셨네요");
            toast.setView(toastView);
            Display display = ((WindowManager)getSystemService((WINDOW_SERVICE)).getDefaultDisplay());
            int xOffset =(int)(Math.random() * display.getWidth());
            int uOffset = (int)(Math.random() * display.getHeight());
            toast.setGravity(Gravity.TOP | Gravity.LEFT, xOffset,uOffset);
            toast.show();
        }
    };
}