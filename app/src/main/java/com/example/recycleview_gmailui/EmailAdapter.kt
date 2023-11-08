package com.example.recycleview_gmailui

import android.annotation.SuppressLint
import android.graphics.Color
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(private val emails: List<Email>) : RecyclerView.Adapter<EmailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_email, parent, false)
        return EmailViewHolder(view)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        val email = emails[position]
        val context = holder.itemView.context

        holder.senderTextView.text = email.sender
        holder.senderTimeTextView.text = email.time
        holder.mailContentTextView.text = email.content
        holder.senderCircleTextView.text = email.sender.first().toString()
        holder.mailContentTextView.maxLines = 2
        holder.mailContentTextView.ellipsize = TextUtils.TruncateAt.END

        var isClicked = false
        holder.itemView.setOnClickListener {
            if (isClicked) {
                holder.senderCircleTextView.background = context.getDrawable(R.drawable.avatar_frame)
                holder.senderCircleTextView.text = email.sender.first().toString()
                holder.senderCircleTextView.setTextColor(Color.WHITE)
                holder.itemView.setBackgroundColor(Color.WHITE)
            } else {
                holder.itemView.setBackgroundColor(Color.parseColor("#D3D3D3"))
                holder.senderCircleTextView.background = context.getDrawable(R.drawable.holder_avatar)
            }
            isClicked = !isClicked
        }
    }

    override fun getItemCount(): Int {
        return emails.size
    }
}