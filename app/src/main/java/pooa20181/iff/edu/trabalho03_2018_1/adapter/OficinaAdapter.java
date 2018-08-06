package pooa20181.iff.edu.trabalho03_2018_1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pooa20181.iff.edu.trabalho03_2018_1.R;
import pooa20181.iff.edu.trabalho03_2018_1.model.Oficina;

public class OficinaAdapter extends RecyclerView.Adapter<OficinaAdapter.OficinaViewHolder>{

    private List<Oficina> oficinas;
    private Context context;
    private ClickRecyclerViewListener clickRecyclerViewListener;

    public OficinaAdapter(List<Oficina> oficinas, Context context,
                            ClickRecyclerViewListener clickRecyclerViewListener) {
        this.oficinas = oficinas;
        this.context = context;
        this.clickRecyclerViewListener = clickRecyclerViewListener;
    }

    @Override
    public OficinaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.linha_oficina, parent, false);
        OficinaViewHolder oficinaViewHolder = new OficinaViewHolder(view);
        return oficinaViewHolder;
    }

    @Override
    public void onBindViewHolder(OficinaViewHolder viewHolder, int position) {
        OficinaViewHolder oficinaViewHolder = viewHolder;
        Oficina oficina = this.oficinas.get(position);
        oficinaViewHolder.nome.setText("Nome: " + oficina.getNome());
        oficinaViewHolder.rua.setText("Rua: " + oficina.getRua());
    }

    @Override
    public int getItemCount() {
        return oficinas.size();
    }

    public class OficinaViewHolder extends RecyclerView.ViewHolder{
        private final TextView nome;
        private final TextView rua;

        public OficinaViewHolder(View view){
            super(view);
            nome = (TextView) itemView.findViewById(R.id.nomeOficina);
            rua = (TextView) itemView.findViewById(R.id.ruaOficina);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickRecyclerViewListener.onClick(oficinas.get(getLayoutPosition()));
                }
            });
        }
    }
}
