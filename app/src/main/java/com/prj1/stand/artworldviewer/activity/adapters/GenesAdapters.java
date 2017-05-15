package com.prj1.stand.artworldviewer.activity.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.prj1.stand.artworldviewer.R;
import com.prj1.stand.artworldviewer.model.genes.Genes;

import com.androidquery.AQuery;

/**
 * GenesAdapter that will handle and display the cursor data on the screen
 * CursorAdapter - later after get local db
 * Created by Stand on 5/6/2017.
 */

public class GenesAdapters extends BaseAdapter{
    private Context gContext;
    private final Genes genes;

    /**
     * GenesAdapters constructor the set-up outside stuff inside
     *
     */
    public GenesAdapters (Context context, Genes _genes) {
        //super(context,cursor,flags);
        gContext = context;
        genes = _genes;
    }

    /**
     * Class the holds the View elements
     */
    public static class ViewHolder{
        public final TextView geneNameTextView;
        public final ImageView geneImageView;
        public final TextView geneDesTextView;

        /**
         * ViewHolder Constructor the binds the public layout elements to the ViewHolder object
         * @param view - The current view for the layout elements
         */
        public ViewHolder(View view){
            geneNameTextView = (TextView) view.findViewById(R.id.genes_name);
            geneImageView = (ImageView) view.findViewById(R.id.genes_image);
            geneDesTextView = (TextView) view.findViewById(R.id.genes_description);
        }
    }

    @Override
    public int getCount() {
        return genes.getEmbedded().getGenes().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v;
        LayoutInflater inflater = (LayoutInflater) gContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(view == null ) {
            // Populate local view with adapter context
            v = new View(gContext);

            // Inflate the gene_item
            v = inflater.inflate(R.layout.gene_item,viewGroup);

            // Create an instance of ViewHolder
            ViewHolder viewHolder = new ViewHolder(view);

            viewHolder.geneNameTextView.setText(genes.getEmbedded().getGenes().get(i).getName());
            viewHolder.geneDesTextView.setText(genes.getEmbedded().getGenes().get(i).getDescription());

            AQuery aq = new AQuery(viewHolder.geneImageView);
            aq.id(viewHolder.geneImageView).image(genes.getEmbedded().getGenes().get(i).getLinks().getThumbnail().getHref());

            v.setTag(viewHolder);
        } else {
            v = (View) view;
        }

        return v;
    }
}
