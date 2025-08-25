package com.example.proxy_bug_report

import CredentialsApiPigeonProxyApiRegistrar
import PigeonApiAuth
import android.util.Log
import com.example.proxy_bug_report.auth.Auth
import com.example.proxy_bug_report.auth.Callback
import com.example.proxy_bug_report.auth.Credentials

class AuthApi(pigeonRegistrar: CredentialsApiPigeonProxyApiRegistrar) :
  PigeonApiAuth(pigeonRegistrar) {
  override fun pigeon_defaultConstructor(): Auth {
    return Auth()
  }

  override fun getCredentials(
    pigeon_instance: Auth,
    callback: (Result<Credentials>) -> Unit
  ) {
    pigeon_instance.getCredentials(
      object : Callback<Credentials, Exception> {
        override fun onSuccess(result: Credentials) {
          getPigeonRegistrar().runOnMainThread {
            callback(Result.success(result))
          }
        }

        override fun onFailure(error: Exception) {
          Log.e("AuthApi", "Error getting credentials", error)
          callback(Result.failure(error))
        }
      }
    )
  }

  fun getPigeonRegistrar(): ProxyApiRegistrar {
    return pigeonRegistrar as ProxyApiRegistrar
  }
}