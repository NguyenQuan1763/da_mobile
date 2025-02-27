package com.example.da_mobile.Login;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.da_mobile.R;

public class ResetpasswordActivity extends AppCompatActivity {

    EditText edtPassword, edt_resetP;
    ImageView imgP,imgPR;

    // Biến cờ kiểm tra xem đang ẩn hay hiện mật khẩu
    boolean isPasswordVisible = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resetpassword);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtPassword = findViewById(R.id.edtPassword);
        imgP = findViewById(R.id.imgTogglePassword);



        imgP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPasswordVisible) {
                    // Nếu đang ở chế độ hiện -> chuyển sang ẩn
                    edtPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    imgP.setImageResource(R.drawable.baseline_visibility_off_24);
                    isPasswordVisible = false;
                }
                else {
                    // Nếu đang ở chế độ ẩn -> chuyển sang hiện
                    edtPassword.setInputType(InputType.TYPE_CLASS_TEXT |
                            InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    imgP.setImageResource(R.drawable.baseline_visibility_24);
                    isPasswordVisible = true;
                }
                // Di chuyển con trỏ (cursor) về cuối text
                edtPassword.setSelection(edtPassword.getText().length());}
    });
    }
}