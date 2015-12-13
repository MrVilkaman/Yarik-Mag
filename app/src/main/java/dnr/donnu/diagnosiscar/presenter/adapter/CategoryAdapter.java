package dnr.donnu.diagnosiscar.presenter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import dnr.donnu.diagnosiscar.R;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>
		implements View.OnClickListener  {

	public interface OnClickListener {
		void onCategoryClick(int questionId);
	}

	private OnClickListener clickListener;

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
//		User user = mUsers.get(position);
		holder.name.setText("position "+position);
		holder.itemView.setTag(position);
	}

	@Override
	public int getItemCount() {
		return 10;
	}

	@Override
	public void onClick(View v) {
		Integer position = (Integer) v.getTag();
		if (clickListener != null && position != null) {
			clickListener.onCategoryClick(position);
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
