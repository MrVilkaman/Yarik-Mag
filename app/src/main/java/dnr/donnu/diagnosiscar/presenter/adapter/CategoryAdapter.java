package dnr.donnu.diagnosiscar.presenter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import dnr.donnu.diagnosiscar.R;
import dnr.donnu.diagnosiscar.model.entity.Category;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>
		implements View.OnClickListener  {


	public interface OnClickListener {
		void onCategoryClick(Category category);
	}

	private List<Category> categories;
	private OnClickListener clickListener;

	public CategoryAdapter() {
		categories = new ArrayList<>();
	}

	public void setClickListener(OnClickListener clickListener) {
		this.clickListener = clickListener;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		final Context context = parent.getContext();
		final LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View v = layoutInflater.inflate(R.layout.simlpe_list_view, parent, false);
		ViewHolder vh = new ViewHolder(v);
		vh.itemView.setOnClickListener(this);
		return vh;
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		Category category = getCategory(position);
		holder.name.setText(category.getTitle());
		holder.itemView.setTag(category);
	}

	private Category getCategory(int position) {
		return categories.get(position);
	}


	public void setItems(List<Category> categories) {
		this.categories.addAll(categories);
		notifyDataSetChanged();
	}

	@Override
	public int getItemCount() {
		return categories.size();
	}

	@Override
	public void onClick(View v) {
		Category category = (Category) v.getTag();
		if (clickListener != null && category != null) {
			clickListener.onCategoryClick(category);
		}
	}

	static class ViewHolder extends RecyclerView.ViewHolder {
		@Bind(R.id.text)
		TextView name;
		public ViewHolder(View view) {
			super(view);
			ButterKnife.bind(this, view);
		}
	}
}
