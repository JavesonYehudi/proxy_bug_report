package com.example.proxy_bug_report

class Auth {
  fun login() : Credentials {
    return Credentials("access_token")
  }
}