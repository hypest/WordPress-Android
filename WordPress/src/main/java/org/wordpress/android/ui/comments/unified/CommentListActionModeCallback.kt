package org.wordpress.android.ui.comments.unified

import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.view.ActionMode
import androidx.appcompat.view.ActionMode.Callback
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Lifecycle.Event.ON_STOP
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

class CommentListActionModeCallback(
    private val viewModel: UnifiedCommentListViewModel,
    private val activityViewModel: UnifiedCommentActivityViewModel
) : Callback,
        LifecycleOwner {
    private lateinit var lifecycleRegistry: LifecycleRegistry
    override fun onCreateActionMode(
        actionMode: ActionMode,
        menu: Menu
    ): Boolean {
//        lifecycleRegistry = LifecycleRegistry(this)
//        lifecycleRegistry.handleLifecycleEvent(ON_START)
//        val inflater = actionMode.menuInflater
//        inflater.inflate(R.menu.menu_comments_cab, menu)
//
//        lifecycleScope.launchWhenStarted {
//            viewModel.uiState.collect { uiState ->
//                when (val uiModel = uiState.actionModeUiModel) {
//                    is ActionModeUiModel.Hidden -> {
//                        actionMode.finish()
//                        activityViewModel.onActionModeToggled(false)
//                    }
//                    is ActionModeUiModel.Visible -> {
//                        activityViewModel.onActionModeToggled(true)
//                        val approveItem = menu.findItem(R.id.menu_approve)
//                        val unaproveItem = menu.findItem(R.id.menu_unapprove)
//                        val spamItem = menu.findItem(R.id.menu_spam)
//                        val unspamItem = menu.findItem(R.id.menu_unspam)
//                        val trashItem = menu.findItem(R.id.menu_trash)
//                        val untrashItem = menu.findItem(R.id.menu_untrash)
//                        val deleteItem = menu.findItem(R.id.menu_delete)
//
//                        setItemEnabled(approveItem, uiModel.approveActionUiModel)
//                        setItemEnabled(unaproveItem, uiModel.unparoveActionUiModel)
//                        setItemEnabled(spamItem, uiModel.spamActionUiModel)
//                        setItemEnabled(unspamItem, uiModel.unspamActionUiModel)
//                        setItemEnabled(trashItem, uiModel.trashActionUiModel)
//                        setItemEnabled(untrashItem, uiModel.unTrashActionUiModel)
//                        setItemEnabled(deleteItem, uiModel.deleteActionUiModel)
//
//                        if (uiModel.actionModeTitle is UiStringText) {
//                            actionMode.title = uiModel.actionModeTitle.text
//                        }
//                    }
//                }
//            }
//        }
        return true
    }

//    private fun setItemEnabled(menuItem: MenuItem, actionUiModel: ActionUiModel) {
//        menuItem.isVisible = actionUiModel.isVisible
//        menuItem.isEnabled = actionUiModel.isEnabled
//        if (menuItem.icon != null) {
//            // must mutate the drawable to avoid affecting other instances of it
//            val icon = menuItem.icon.mutate()
//            icon.alpha = if (actionUiModel.isEnabled) 255 else 128
//            menuItem.icon = icon
//        }
//    }

    override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
        return false
    }

    override fun onActionItemClicked(
        mode: ActionMode,
        item: MenuItem
    ): Boolean {
        return false
//        return when (item.itemId) {
//            R.id.menu_approve -> {
//                viewModel.performBatchModeration(APPROVED)
//                true
//            }
//            R.id.menu_unapprove -> {
//                viewModel.performBatchModeration(UNAPPROVED)
//                true
//            }
//            R.id.menu_spam -> {
//                viewModel.performBatchModeration(SPAM)
//                true
//            }
//            R.id.menu_unspam -> {
//                viewModel.performBatchModeration(APPROVED)
//                true
//            }
//            R.id.menu_trash -> {
//                viewModel.performBatchModeration(TRASH)
//                true
//            }
//            R.id.menu_untrash -> {
//                viewModel.performBatchModeration(APPROVED)
//                true
//            }
//            R.id.menu_delete -> {
//                viewModel.performBatchModeration(DELETED)
//                true
//            }
//
//            else -> false
//        }
    }

    override fun onDestroyActionMode(mode: ActionMode) {
//        viewModel.clearActionModeSelection()

        lifecycleRegistry.handleLifecycleEvent(ON_STOP)
    }

    override fun getLifecycle(): Lifecycle = lifecycleRegistry
}
