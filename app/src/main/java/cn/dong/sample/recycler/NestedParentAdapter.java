package cn.dong.sample.recycler;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Locale;

import cn.dong.sample.R;

/**
 * @author dong on 2017/05/01.
 */
public class NestedParentAdapter extends RecyclerView.Adapter<NestedParentAdapter.ViewHolder> {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nested_parent, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.titleText.setText(String.format(Locale.US, "item:%d", position));
        holder.adapter.setParentPosition(position);
        holder.adapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleText;
        private final RecyclerView recyclerView;
        private final NestedChildAdapter adapter;

        ViewHolder(View itemView) {
            super(itemView);
            titleText = (TextView) itemView.findViewById(R.id.parent_title);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.parent_recycler);

            LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext());
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
                @Override
                public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                    outRect.set(0, 0, 10, 0);
                }
            });

            adapter = new NestedChildAdapter();
            recyclerView.setAdapter(adapter);
        }
    }
}
