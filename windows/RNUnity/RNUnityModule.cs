using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Com.Reactlibrary.RNUnity
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNUnityModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNUnityModule"/>.
        /// </summary>
        internal RNUnityModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNUnity";
            }
        }
    }
}
