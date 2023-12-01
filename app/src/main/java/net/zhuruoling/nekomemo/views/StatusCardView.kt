package net.zhuruoling.nekomemo.views

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.card.MaterialCardView
import net.zhuruoling.nekomemo.R

class StatusCardView : LinearLayout {

    private var backgroundCard: MaterialCardView
    private var statusImageView: ImageView
    private var statusTextView: TextView

    var statusImage: Drawable?
        get() = statusImageView.drawable
        set(value) {
            statusImageView.setImageDrawable(value)
        }

    var statusText: String
        get() = statusTextView.text.toString()
        set(value){
            statusTextView.text = value
        }

    var cardBackgroundColor: Int
        get() = backgroundCard.cardBackgroundColor.defaultColor
        set(value) = backgroundCard.setCardBackgroundColor(value)

    constructor(context: Context) : super(context) {
        LayoutInflater.from(context).inflate(R.layout.view_status_card, this)
        backgroundCard = findViewById(R.id.background_card)
        statusImageView = findViewById(R.id.status_icon)
        statusTextView = findViewById(R.id.status_text)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        LayoutInflater.from(context).inflate(R.layout.view_status_card, this)
        backgroundCard = findViewById(R.id.background_card)
        statusImageView = findViewById(R.id.status_icon)
        statusTextView = findViewById(R.id.status_text)
    }

}