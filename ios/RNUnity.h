#import "RCTEventEmitter.h"
#import "RCTBridgeModule.h"
#import <UnityAds/UnityAds.h>
#import <UnityAds/UADSMediationMetaData.h>
#import <UnityAds/UADSPlayerMetaData.h>

@interface RNUnity : RCTEventEmitter <RCTBridgeModule, UnityAdsDelegate>

@end
  
