package com.example.proxy_bug_report

import CredentialsApiPigeonProxyApiRegistrar
import PigeonApiAuth
import android.util.Log

class AuthApi(pigeonRegistrar: CredentialsApiPigeonProxyApiRegistrar) :
  PigeonApiAuth(pigeonRegistrar) {
  override fun pigeon_defaultConstructor(): Auth {
    return Auth()
  }

  override fun login(
    pigeon_instance: Auth,
    callback: (Result<Credentials>) -> Unit
  ) {
    try {
      val credentials = pigeon_instance.login()
      callback(Result.success(credentials))
    } catch (e: Exception) {
      Log.e("TAG", e.message ?: "Unknown error during login")
      callback(Result.failure(e))
    }
  }
}