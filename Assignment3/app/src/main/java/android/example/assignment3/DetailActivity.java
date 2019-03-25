package android.example.assignment3;

import android.content.Intent;
import android.example.assignment3.model.Recipe;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.LinkedList;

public class DetailActivity extends AppCompatActivity {

    private LinkedList<Recipe> mRecipeList;
    private TextView textViewTitle;
    private TextView textViewIngredients;
    private TextView textViewDirections;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_main);

        // Get the intent and its data.
        Intent intent = getIntent();
        int position = intent.getIntExtra("CardPosition",DataAdapter.EXTRA_POSITION);
        Recipe recipe = mRecipeList.get(position);
        Picasso.get()
                .load(recipe.image)
                .fit()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(imageView);
        textViewTitle=findViewById(R.id.textViewTitle);
        textViewIngredients=findViewById(R.id.textViewIngredients);
        textViewDirections=findViewById(R.id.textViewDirections);
        textViewTitle.setText(recipe.name);
        textViewIngredients.setText(recipe.ingredients);
        textViewDirections.setText(recipe.directions);
    }
}