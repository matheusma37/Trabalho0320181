package pooa20181.iff.edu.trabalho03_2018_1.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import io.realm.Realm;
import pooa20181.iff.edu.trabalho03_2018_1.R;
import pooa20181.iff.edu.trabalho03_2018_1.adapter.ClickRecyclerViewListener;
import pooa20181.iff.edu.trabalho03_2018_1.adapter.OficinaAdapter;
import pooa20181.iff.edu.trabalho03_2018_1.model.Oficina;

public class OficinaActivity extends AppCompatActivity implements ClickRecyclerViewListener {

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oficina);
        FloatingActionButton fabOficina = (FloatingActionButton) findViewById(R.id.fabOficina);

        realm = Realm.getDefaultInstance();

        fabOficina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OficinaActivity.this, DetalheOficina.class);
                intent.putExtra("id", "-1");
                startActivity(intent);
            }
        });

    }


    protected void onResume() {

        super.onResume();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvOficina);

        recyclerView.setAdapter(new OficinaAdapter(getOficinas(),this,this));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public List<Oficina> getOficinas(){

        return (List) realm.where(Oficina.class).findAll();

    }

    @Override
    public void onClick(Object object) {
        Oficina oficina = (Oficina) object;
        Intent intent = new Intent(OficinaActivity.this, DetalheOficina.class);
        intent.putExtra("id",oficina.getId());
        startActivity(intent);
    }

    public void finish(){
        super.finish();
        realm.close();
    }
}
