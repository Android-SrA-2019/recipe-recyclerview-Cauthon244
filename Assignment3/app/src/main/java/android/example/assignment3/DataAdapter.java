package android.example.assignment3;

import android.content.Context;
import android.content.Intent;
import android.example.assignment3.model.Recipe;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class DataAdapter extends
        RecyclerView.Adapter<DataAdapter.RecipeViewHolder>{

    private final LinkedList<Recipe> mRecipeList;
    private LayoutInflater mInflater;
    private Context context;
    public static int EXTRA_POSITION=0;

    public DataAdapter(Context context, LinkedList<Recipe> mRecipeList) {
        this.mRecipeList = mRecipeList;
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
    }


    class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView headItemView;
        public final TextView bodyItemView;
        public int position;
        final DataAdapter mAdapter;

        public RecipeViewHolder(View itemView, DataAdapter adapter) {
            super(itemView);
            headItemView = itemView.findViewById(R.id.text_head);
            bodyItemView = itemView.findViewById(R.id.text_body);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // Get the position of the item that was clicked.
            EXTRA_POSITION = getLayoutPosition();
// Use that to access the affected item in mRecipeList.
            // Recipe element = mRecipeList.get(mPosition);
            Intent intent = new Intent(context , DetailActivity.class);
            intent.putExtra("CardPosition", EXTRA_POSITION);
            context.startActivity(intent);
        }
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View itemView = mInflater.inflate(R.layout.content_main,
                parent, false);
        return new RecipeViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {
        Recipe mCurrent = mRecipeList.get(position);
        holder.headItemView.setText(mCurrent.name);
        holder.bodyItemView.setText(mCurrent.description);
        holder.position=position;
    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }
}
