package com.codinginflow.exchangeApp.ui.exchangeList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codinginflow.exchangeApp.data.remote.response.Currency
import com.codinginflow.exchangeApp.databinding.ItemCurrencyBinding


class ExchangeListAdapter(private val listener: OnItemClickListener) :
    ListAdapter<Currency, ExchangeListAdapter.WordsViewHolder>(DiffCallback()) {

    inner class WordsViewHolder(private val binding: ItemCurrencyBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.apply {
                root.setOnClickListener {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        val word = getItem(position)
                        listener.onItemClick(word)
                    }
                }/*
                checkBoxLearned.setOnClickListener {
                    val position=adapterPosition
                    if (position != RecyclerView.NO_POSITION){
                        val word=getItem(position)
                        listener.onCheckBoxClick(word,checkBoxLearned.isChecked)
                    }
                }*/
            }
        }

        fun bind(word: Currency) {
            binding.apply {
//                checkBoxLearned.isChecked = word.learned
//                textViewWord.text = word.word
//                textViewWord.paint.isStrikeThruText = word.learned
//                labelPriority.isVisible = word.important
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordsViewHolder {
        val binding = ItemCurrencyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WordsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WordsViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    interface OnItemClickListener {
        fun onItemClick(Currency: Currency)
    }


    class DiffCallback : DiffUtil.ItemCallback<Currency>() {
        override fun areItemsTheSame(oldItem: Currency, newItem: Currency): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Currency, newItem: Currency): Boolean = oldItem == newItem
    }
}