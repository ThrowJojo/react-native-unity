
package com.reactlibrary;

import android.os.Handler;
import android.os.Looper;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;

public class RNUnityModule extends ReactContextBaseJavaModule implements IUnityAdsListener {

  private final ReactApplicationContext reactContext;
  private Handler handler;

  public RNUnityModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
    this.handler = new Handler(Looper.getMainLooper());
  }

  @ReactMethod
  public void loadAds(final String appID, final boolean testMode) {
    handler.post(new Runnable() {
      @Override
      public void run() {
        UnityAds.initialize(getCurrentActivity(), appID, RNUnityModule.this, testMode);
      }
    });
  }

  @ReactMethod
  public void showAd() {
    if (UnityAds.isReady()) {
      handler.post(new Runnable() {
        @Override
        public void run() {
          UnityAds.show(getCurrentActivity());
        }
      });
    }
  }

  @Override
  public String getName() {
    return "RNUnity";
  }

  private WritableMap placementIdParams(String placementId) {
    WritableMap params = Arguments.createMap();
    params.putString("placementId", placementId);
    return params;
  }

  private WritableMap messageParams(String message) {
    WritableMap params = Arguments.createMap();
    params.putString("message", message);
    return params;
  }

  @Override
  public void onUnityAdsReady(String placementId) {
    reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit("ready", placementIdParams(placementId));
  }

  @Override
  public void onUnityAdsStart(String placementId) {
    reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit("didStart", placementIdParams(placementId));
  }

  @Override
  public void onUnityAdsFinish(String placementId, UnityAds.FinishState finishState) {
    reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit("didFinish", placementIdParams(placementId));
  }

  @Override
  public void onUnityAdsError(UnityAds.UnityAdsError unityAdsError, String message) {
    reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit("error", messageParams(message));
  }

}