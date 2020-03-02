package unsw.Infs3605.Mydegree;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class PasswrodfActivity extends AppCompatActivity {

    Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pwforgot);
        btnback = findViewById(R.id.button6);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent = new Intent(PasswrodfActivity.this, LoginActivity.class);
                startActivity(LoginIntent);

            }
        });
    }

    @Override public void onBackPressed() {
        startActivity(new Intent(PasswrodfActivity.this, LoginActivity.class));
        finish();
    }
}
