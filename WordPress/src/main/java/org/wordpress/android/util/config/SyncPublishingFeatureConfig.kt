package org.wordpress.android.util.config

import org.wordpress.android.BuildConfig
import org.wordpress.android.annotation.Feature
import org.wordpress.android.fluxc.store.PostStore.RemotePostPayload
import javax.inject.Inject

private const val SYNC_PUBLISHING_FEATURE_REMOTE_FIELD = "sync_publishing"

@Feature(SYNC_PUBLISHING_FEATURE_REMOTE_FIELD, false)
class SyncPublishingFeatureConfig @Inject constructor(
    appConfig: AppConfig
) : FeatureConfig(
    appConfig,
    BuildConfig.SYNC_PUBLISHING,
    SYNC_PUBLISHING_FEATURE_REMOTE_FIELD
) {
    /**
     * This helper function aids in post-conflict resolution. When attempting to edit a post,
     * sending the "if_not_modified_since" to the backend will trigger a 409 error if a newer version
     * has already been uploaded from another device. This functionality should be encapsulated
     * by the SYNC_PUBLISHING feature flag. The function is used to generate the final RemotePostPayload
     * that is sent to the backend through PostActionBuilder.newPushPostAction(). By setting the
     * isConflictResolution = true, "if_not_modified_since" is not sent to server and the post overwrites
     * the remote version.
     */
    fun getRemotePostPayloadForPush(payload: RemotePostPayload): RemotePostPayload {
        if (this@SyncPublishingFeatureConfig.isEnabled().not()) {
            payload.isConflictResolution = true
        }
        return payload
    }
}
