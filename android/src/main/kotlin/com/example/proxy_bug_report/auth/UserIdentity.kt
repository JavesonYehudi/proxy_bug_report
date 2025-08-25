package com.example.proxy_bug_report.auth

import java.io.Serializable
import com.google.gson.annotations.SerializedName

/**
 * Class that holds the information from a Identity Provider like Facebook or Twitter.
 */
class UserIdentity(
  @field:SerializedName("userId") @field:JsonRequired val id: String,
  @field:SerializedName("connection") val connection: String?,
  @field:SerializedName("providerName") @field:JsonRequired val provider: String,
  @field:SerializedName("isSocial") val isSocial: Boolean,
  @field:SerializedName("access_token") val accessToken: String?,
  @field:SerializedName("access_token_secret") val accessTokenSecret: String?,
  @field:SerializedName("profileData") private val profileInfo: Map<String, Any>?
) : Serializable {

  fun getProfileInfo(): Map<String, Any> {
    return profileInfo?.toMap() ?: emptyMap()
  }
}