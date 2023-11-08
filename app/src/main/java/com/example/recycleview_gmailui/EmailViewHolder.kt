package com.example.recycleview_gmailui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val senderTextView: TextView = itemView.findViewById(R.id.sender_name)
    val senderTimeTextView: TextView = itemView.findViewById(R.id.sender_time)
    val mailContentTextView: TextView = itemView.findViewById(R.id.mail_content)
    val senderCircleTextView: TextView = itemView.findViewById(R.id.sender_circle)
}