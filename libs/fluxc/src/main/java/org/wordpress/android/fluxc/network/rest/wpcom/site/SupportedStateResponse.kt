package org.wordpress.android.fluxc.network.rest.wpcom.site

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class SupportedStateResponse(
    val code: String?,
    val name: String?
) : Parcelable
