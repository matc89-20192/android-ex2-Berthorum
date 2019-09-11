package matc89.exercicio2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewHolder mViewHolder = new ViewHolder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mViewHolder.textView = (TextView) findViewById(R.id.textView);
        this.mViewHolder.btnTrocar = (Button) findViewById(R.id.btnTrocar);

        this.mViewHolder.btnTrocar.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.trocarUsuario();
    }


    private void trocarUsuario(){
        Bundle extras = getIntent().getExtras();
        String usuarioConfirm;
        if(extras != null){
            usuarioConfirm = extras.getString("UsuarioConfirm");
            if(!usuarioConfirm.equals(""))
                this.mViewHolder.textView.setText(String.format("Oi, "+ usuarioConfirm + "!"));
        }
    }

    @Override
    public void onClick(View v) {
        Bundle extras = getIntent().getExtras();
        String usuarioAtual;
        if(v.getId() == R.id.btnTrocar){
            Intent intent = new Intent(this, OutraActivity.class);
            if(extras != null){
                usuarioAtual = extras.getString("UsuarioConfirm");
                intent.putExtra("UsuarioAtual",usuarioAtual);
            }
            startActivity(intent);


        }
    }

    private static class ViewHolder{
        TextView textView;
        Button btnTrocar;
    }
}
