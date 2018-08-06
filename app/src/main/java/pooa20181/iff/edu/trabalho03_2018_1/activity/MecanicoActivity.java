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
import pooa20181.iff.edu.trabalho03_2018_1.adapter.MecanicoAdapter;
import pooa20181.iff.edu.trabalho03_2018_1.model.Mecanico;

public class MecanicoActivity extends AppCompatActivity implements ClickRecyclerViewListener {

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mecanico);
        FloatingActionButton fabMecanico = (FloatingActionButton) findViewById(R.id.fabMecanico);

        realm = Realm.getDefaultInstance();

        fabMecanico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MecanicoActivity.this, DetalheMecanico.class);
                intent.putExtra("id", "-1");
                startActivity(intent);
            }
        });

    }


    protected void onResume() {

        super.onResume();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvMecanico);

        recyclerView.setAdapter(new MecanicoAdapter(getMecanicos(),this,this));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public List<Mecanico> getMecanicos(){

        return (List) realm.where(Mecanico.class).findAll();

    }

    @Override
    public void onClick(Object object) {
        Mecanico mecanico = (Mecanico) object;
        Intent intent = new Intent(MecanicoActivity.this, DetalheMecanico.class);
        intent.putExtra("id",mecanico.getId());
        startActivity(intent);
    }

    public void finish(){
        super.finish();
        realm.close();
    }
}
