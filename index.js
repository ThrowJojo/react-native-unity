
import { NativeModules, NativeEventEmitter } from 'react-native';

const {RNUnity} = NativeModules;
let EventEmitter = new NativeEventEmitter(RNUnity);

class UnityAds {

    // Load Unity Ads with your appId, testMode accepts a boolean
    static loadAds = (appId, testMode) => {
        RNUnity.loadAds(appId, testMode);
    };

    // Show the default placement
    static showAd = () => {
        RNUnity.showAd();
    };

    // Show a placement by it's placementId
    static showAdWithId = (placementId) => {
        RNUnity.showAdWithId(placementId);
    };

    // Check if a placement is ready using it's placementId, callback will return a boolean
    static isReady = (placementId, callback) => {
        RNUnity.isReady(placementId, callback);
    };

    // Ready listener, return object with 'placementId'
    static addReadyListener = (callback) => {
        EventEmitter.addListener('ready', callback);
    };

    // Start listener, returns object with 'placementId'
    static addStartListener = (callback) => {
        EventEmitter.addListener('didStart', callback);
    };

    /* Finish listener, returns:
        placementId -> String,
        finishState -> Number
        Refer to the official SDK for more information about the finish state
    */
    static addFinishListener = (callback) => {
        EventEmitter.addListener('didFinish', callback);
    };

    /* Error listener, returns:
         message -> String,
         error -> Number
         Refer to the official SDK for more information about error values
    */
    static addErrorListener = (callback) => {
        EventEmitter.addListener('error', callback);
    };

}

module.exports.UnityAds = UnityAds;
