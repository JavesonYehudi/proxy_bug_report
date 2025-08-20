package com.example.proxy_bug_report

import CredentialsApiPigeonProxyApiRegistrar
import PigeonApiAuth
import PigeonApiCredentials
import io.flutter.plugin.common.BinaryMessenger

class ProxyApiRegistrar(binaryMessenger: BinaryMessenger) :
  CredentialsApiPigeonProxyApiRegistrar(binaryMessenger) {
  override fun getPigeonApiAuth(): PigeonApiAuth {
    return AuthApi(this)
  }

  override fun getPigeonApiCredentials(): PigeonApiCredentials {
    return CredentialsApi(this)
  }
}