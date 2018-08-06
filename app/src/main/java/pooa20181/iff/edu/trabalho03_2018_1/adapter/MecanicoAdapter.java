package pooa20181.iff.edu.trabalho03_2018_1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pooa20181.iff.edu.trabalho03_2018_1.R;
import pooa20181.iff.edu.trabalho03_2018_1.model.Mecanico;

public class MecanicoAdapter extends RecyclerView.Adapter<MecanicoAdapter.MecanicoViewHolder>{

    private List<Mecanico> mecanicos;
    private Context context;
    private ClickRecyclerViewListener clickRecyclerViewListener;

    public MecanicoAdapter(List<Mecanico> mecanicos, Context context,
                          ClickRecyclerViewListener clickRecyclerViewListener) {
        this.mecanicos = mecanicos;
        this.context = context;
        this.clickRecyclerViewListener = clickRecyclerViewListener;
    }

    @Override
    public MecanicoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.linha_mecanico, parent, false);
        MecanicoViewHolder mecanicoViewHolder = new MecanicoViewHolder(view);
        return mecanicoViewHolder;
    }

    @Override
    public void onBindViewHolder(MecanicoViewHolder viewHolder, int position) {
        MecanicoViewHolder mecanicoViewHolder = viewHolder;
        Mecanico mecanico = this.mecanicos.get(position);
        mecanicoViewHolder.nome.setText("Nome: " + mecanico.getNome());
        mecanicoViewHolder.funcao.setText("Função: " + mecanico.getFuncao());
    }

    @Override
    public int getItemCount() {
        return mecanicos.size();
    }

    public class MecanicoViewHolder extends RecyclerView.ViewHolder{
        private final TextView nome;
        private final TextView funcao;

        public MecanicoViewHolder(View view){
            super(view);
            nome = (TextView) itemView.findViewById(R.id.nomeMecanico);
            funcao = (TextView) itemView.findViewById(R.id.funcaoMecanico);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickRecyclerViewListener.onClick(mecanicos.get(getLayoutPosition()));
                }
            });
        }
    }
}
