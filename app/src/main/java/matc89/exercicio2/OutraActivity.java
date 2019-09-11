package matc89.exercicio2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OutraActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewHolder mViewHolder = new ViewHolder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outra);
        this.mViewHolder.editText = (EditText) findViewById(R.id.editText);
        this.mViewHolder.btnConfirmar = (Button) findViewById(R.id.btnConfirmar);
        this.mViewHolder.btnCancelar = (Button) findViewById(R.id.btnCancelar);

        this.mViewHolder.btnConfirmar.setOnClickListener(this);
        this.mViewHolder.btnCancelar.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.usuarioAtual();
    }

    private void usuarioAtual(){
        Bundle extras = getIntent().getExtras();
        String usuarioAtual;
        if(extras != null){
            usuarioAtual = extras.getString("UsuarioAtual");
            this.mViewHolder.editText.setText(usuarioAtual);
        }
    }

    @Override
    public void onClick(View v) {
        String valueConfirm = this.mViewHolder.editText.getText().toString();
        Intent intent = new Intent(this,MainActivity.class);
        if(v.getId() == R.id.btnConfirmar){
            intent.putExtra("UsuarioConfirm",valueConfirm);
        }
        startActivity(intent);


    }

    private static class ViewHolder{
        EditText editText;
        Button btnConfirmar, btnCancelar;

    }
}
