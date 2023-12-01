package net.zhuruoling.nekomemo.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import net.zhuruoling.nekomemo.databinding.FragmentSettingBinding
import net.zhuruoling.nekomemo.sync.SyncStatus
import net.zhuruoling.nekomemo.sync.setSyncStatusToView

class SettingFragment : Fragment() {

    private var _binding: FragmentSettingBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val settingViewModel = ViewModelProvider(this)[SettingViewModel::class.java]
        _binding = FragmentSettingBinding.inflate(inflater, container, false)

        binding.syncStatusCard.setSyncStatusToView(requireContext(), SyncStatus.ENABLED)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}