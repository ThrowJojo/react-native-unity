
#import "RNUnity.h"

@implementation RNUnity {

}

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(loadAds: (NSString*) appID testMode: (BOOL) testMode) {
    [UnityAds initialize:appID delegate:self testMode:testMode];
}

RCT_EXPORT_METHOD(showAd) {
    if ([UnityAds isReady]) {
        [UnityAds show:[self rootViewController]];
    }
    [self sendEventWithName:@"error" body:@{@"message": @"test error"}];
}


- (NSArray<NSString *> *)supportedEvents {
    return @[@"ready", @"didStart", @"didFinish", @"error"];
}

- (UIViewController*) rootViewController {
    return [UIApplication sharedApplication].delegate.window.rootViewController;
}

- (void)unityAdsReady:(NSString *)placementId {
    [self sendEventWithName:@"ready" body:@{@"placementId": placementId}];
}

- (void)unityAdsDidStart:(NSString *)placementId {
    [self sendEventWithName:@"didStart" body:@{@"placementId": placementId}];
}

- (void)unityAdsDidFinish:(NSString *)placementId withFinishState:(UnityAdsFinishState)state {
    [self sendEventWithName:@"didFinish" body:@{@"placementId": placementId}];
}

- (void)unityAdsDidError:(UnityAdsError)error withMessage:(NSString *)message {
    [self sendEventWithName:@"error" body:@{@"message": message}];
}

@end
  
