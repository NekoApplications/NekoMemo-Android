package net.zhuruoling.nekomemo.setting

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import net.zhuruoling.nekomemo.R
import net.zhuruoling.nekomemo.databinding.FragmentSettingBinding
import net.zhuruoling.nekomemo.sync.DataSync
import net.zhuruoling.nekomemo.sync.SyncStatus
import net.zhuruoling.nekomemo.sync.setSyncStatusToView

class SettingFragment : Fragment() {

    private var _binding: FragmentSettingBinding? = null

    private val binding get() = _binding!!
    private var currentStatus = DataSync.syncStatus

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val settingViewModel = ViewModelProvider(this)[SettingViewModel::class.java]
        _binding = FragmentSettingBinding.inflate(inflater, container, false)
        updateSyncStatusHint(currentStatus)
        binding.syncStatusCard.setOnClickListener {
            currentStatus = when (currentStatus) {
                SyncStatus.ENABLED -> {
                    SyncStatus.DISABLED
                }

                SyncStatus.DISABLED -> {
                    SyncStatus.ERROR
                }

                SyncStatus.ERROR -> {
                    SyncStatus.ENABLED
                }
            }
            Log.i("nm","updateStatus: $currentStatus")
            updateSyncStatusHint(currentStatus)
        }
        return binding.root
    }

    private fun updateSyncStatusHint(status: SyncStatus){
        binding.syncStatusCard.setSyncStatusToView(requireContext(), status)
        when (status) {
            SyncStatus.ENABLED -> {
                binding.informationCard.visibility = View.GONE
            }
            SyncStatus.DISABLED -> {
                binding.apply {
                    informationCard.visibility = View.VISIBLE
                    informationTitle.setText(R.string.text_sync_off_title)
                    informationSummary.setText(R.string.text_sync_off_summary)
                }
            }
            SyncStatus.ERROR -> {
                binding.apply {
                    informationCard.visibility = View.VISIBLE
                    informationTitle.setText(R.string.text_sync_error_title)
                    informationSummary.setText(R.string.text_sync_error_summary)
                }
            }
        }
    }

    private fun setupWarningCard(title: Int, summary: Int) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}