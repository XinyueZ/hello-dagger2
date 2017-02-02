package com.hellodg.itbooks;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hellodg.R;
import com.hellodg.data.itbooks.Book;
import com.hellodg.data.itbooks.ItBooks;
import com.hellodg.databinding.ItemItBookBinding;


public final class ItBooksListAdapter extends RecyclerView.Adapter<ItBooksListAdapter.ItBooksListAdapterViewHolder> {
	private ItBooks mItBooks;

	public ItBooksListAdapter(ItBooks itBooks) {
		mItBooks = itBooks;
	}

	@Override
	public ItBooksListAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		Context cxt = parent.getContext();
		ItemItBookBinding binding = DataBindingUtil.inflate(LayoutInflater.from(cxt), R.layout.item_itbooks_list, parent, false);
		return new ItBooksListAdapter.ItBooksListAdapterViewHolder(binding);
	}

	@Override
	public void onBindViewHolder(ItBooksListAdapterViewHolder holder, int position) {
		Book book = mItBooks.getBookList().get(position);
		holder.mBinding.titleTv.setText(book.getTitle());
		holder.mBinding.subtitleTv.setText(book.getSubTitle());
		holder.mBinding.executePendingBindings();
	}

	@Override
	public int getItemCount() {
		return mItBooks.getBookList()
		               .size();
	}

	static class ItBooksListAdapterViewHolder extends RecyclerView.ViewHolder {
		private ItemItBookBinding mBinding;

		public ItBooksListAdapterViewHolder(ItemItBookBinding binding) {
			super(binding.getRoot());
			mBinding = binding;
		}
	}
}
