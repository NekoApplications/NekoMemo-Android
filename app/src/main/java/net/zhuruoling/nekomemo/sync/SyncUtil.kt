package net.zhuruoling.nekomemo.sync

import android.content.Context
import androidx.appcompat.content.res.AppCompatResources
import net.zhuruoling.nekomemo.R
import net.zhuruoling.nekomemo.views.StatusCardView

fun StatusCardView.setSyncStatusToView(context: Context, status: SyncStatus){
    apply { 
        when(status){
            SyncStatus.ENABLED -> {
                cardBackgroundColor = context.getColor(R.color.syncOn)
                statusText = context.getText(R.string.text_sync_on).toString()
                statusImage = AppCompatResources.getDrawable(context, R.drawable.ic_sync)
            }
            SyncStatus.DISABLED -> {
                cardBackgroundColor = context.getColor(R.color.syncOff)
                statusText = context.getText(R.string.text_sync_off).toString()
                statusImage = AppCompatResources.getDrawable(context, R.drawable.ic_sync_disabled)
            }
            SyncStatus.ERROR -> {
                cardBackgroundColor = context.getColor(R.color.syncError)
                statusText = context.getText(R.string.text_sync_error).toString()
                statusImage = AppCompatResources.getDrawable(context, R.drawable.ic_sync_problem)
            }
        }
    }
}