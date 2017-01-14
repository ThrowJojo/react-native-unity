
import { NativeModules, NativeEventEmitter } from 'react-native';

const {RNUnity} = NativeModules;
let EventEmitter = new NativeEventEmitter(RNUnity);

class UnityAds {

    static loadAds = (appId, testMode) => {
        RNUnity.loadAds(appId, testMode);
    };

    static showAd = () => {
        RNUnity.showAd();
    };

    // Ready listener, return object with 'placementId'
    static addReadyListener = (callback) => {
        EventEmitter.addListener('ready', callback);
    };

    // Start listener, returns object with 'placementId'
    static addStartListener = (callback) => {
        EventEmitter.addListener('didStart', callback);
    };

    // Finish listener, returns object with 'placementId'
    static addFinishListener = (callback) => {
        EventEmitter.addListener('didFinish', callback);
    };

    // Error listener, returns object with 'message'
    static addErrorListener = (callback) => {
        EventEmitter.addListener('error', callback);
    };

}

module.exports.UnityAds = UnityAds;
