
# react-native-unity

This is a work in progress, I wouldn't bother using it yet because there's a lot of kinks to work out still...

## Getting started

`$ npm install react-native-unity --save`

### Mostly automatic installation

`$ react-native link react-native-unity`

For iOS you will need to add the 'UnityAds.framework' file to your project's bundle.

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-unity` and add `RNUnity.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNUnity.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNUnityPackage;` to the imports at the top of the file
  - Add `new RNUnityPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-unity'
  	project(':react-native-unity').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-unity/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-unity')
  	```
    
## Usage
```javascript
import UnityAds from 'react-native-unity';
// TODO: Write about usage
```
  
