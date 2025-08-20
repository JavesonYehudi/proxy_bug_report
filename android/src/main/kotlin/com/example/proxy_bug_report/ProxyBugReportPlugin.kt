package com.example.proxy_bug_report

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result

/** ProxyBugReportPlugin */
class ProxyBugReportPlugin: FlutterPlugin {
  private lateinit var proxyApiRegistrar: ProxyApiRegistrar

  override fun onAttachedToEngine(flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    proxyApiRegistrar = ProxyApiRegistrar(flutterPluginBinding.binaryMessenger)
    proxyApiRegistrar.setUp()
  }

  override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
    proxyApiRegistrar.tearDown()
    proxyApiRegistrar.instanceManager.stopFinalizationListener()
  }
}
