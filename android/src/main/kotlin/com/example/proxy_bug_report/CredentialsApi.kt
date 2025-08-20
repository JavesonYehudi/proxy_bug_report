package com.example.proxy_bug_report

import CredentialsApiPigeonProxyApiRegistrar
import PigeonApiCredentials

class CredentialsApi(pigeonRegistrar: CredentialsApiPigeonProxyApiRegistrar) :
  PigeonApiCredentials(pigeonRegistrar) {
  override fun accessToken(pigeon_instance: Credentials): String {
    return pigeon_instance.accessToken
  }
}