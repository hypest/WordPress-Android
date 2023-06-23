package org.wordpress.android.ui.prefs.privacy.banner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import org.wordpress.android.ui.WPBottomSheetDialogFragment
import org.wordpress.android.ui.compose.theme.AppTheme
import org.wordpress.android.viewmodel.main.WPMainActivityViewModel

@AndroidEntryPoint
class PrivacyBannerFragment : WPBottomSheetDialogFragment() {
    private val viewModel: PrivacyBannerViewModel by viewModels()
    private val mainViewModel: WPMainActivityViewModel by viewModels({ requireActivity() })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                AppTheme {
                    PrivacyBannerScreen(viewModel)
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.apply {
            setCanceledOnTouchOutside(false)
            setCancelable(false)
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.actionEvent.collect { actionEvent ->
                    when (actionEvent) {
                        is PrivacyBannerViewModel.ActionEvent.Dismiss -> Unit
                        is PrivacyBannerViewModel.ActionEvent.ShowSettings -> {
                            mainViewModel.onPrivacySettingsTapped()
                        }

                        is PrivacyBannerViewModel.ActionEvent.ShowErrorOnSettings -> {
                            mainViewModel.onSettingsPrivacyPreferenceUpdateFailed(actionEvent.requestedAnalyticsValue)
                        }
                    }
                    dismiss()
                }
            }
        }
    }
    companion object {
        const val TAG = "PRIVACY_BANNER_FRAGMENT"
    }
}
