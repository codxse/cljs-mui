# CLJS-MUI

A ClojureScript Material-UI wrapper.

`material-ui v3.2.0`
`material-ui-icon v3.0.1-0`

[![Clojars Project](https://img.shields.io/clojars/v/id.nadiar/cljs-mui.svg)](https://clojars.org/id.nadiar/cljs-mui)


#### Leiningen/Boot
```
[id.nadiar/cljs-mui "0.1.0-alpha4.1"]
```
#### Clojure CLI/deps.edn
```
id.nadiar/cljs-mui {:mvn/version "0.1.0-alpha4.1"}
```

## Usage

From `0.1.0-alpha4.1` above, you have to add react, material-ui, and material-ui-icons manually. If you are using reagent or fulcro, the react is already bundled.

```Clojure
(:require [material-ui]
          [material-ui-icons]
          [id.nadiar.cljs-mui.core :as mui]
          [id.nadiar.cljs-mui.icons :as icon]
          [id.nadiar.cljs-mui.style :refer [theme] :as style]
          [goog.object :as gobj])
```

Reagent example

```Clojure
(def custom-style
  {:button {:margin (gobj/getValueByKeys theme "spacing" "unit")}
   :textField {:marginLeft (gobj/getValueByKeys theme "spacing" "unit")
               :marginRight (gobj/getValueByKeys theme "spacing" "unit")}})

(def with-my-styles (style/with-styles custom-styles))                

(defn my-button [{:keys [classes] :as props}]
  [mui/button {:variant "contained"
               :color "primary"
               :className (.-button classes)}
   "Hello World!"
   [icon/zoom-uut]])

(defn hello-world []
  [:div
   [:> (with-my-styles (reagent.core/reactify-component my-button))]])                
```

Fulcro example

```Clojure
(fulcro.client.primitives/defsc MyButton
                                [this props]
                                {}
                                (mui/button {:variant   "contained"
                                             :color     "primary"
                                             :className (style/class-name this :button)}
                                            "Hello World!"
                                            (icon/zoom-out)))

(def my-button (fulcro.client.primitives/factory
                 ((style/with-style {:button {:margin (gobj/getValueByKeys theme "spacing" "unit")}
                                     :textField {:marginLeft (gobj/getValueByKeys theme "spacing" "unit")
                                                 :marginRight (gobj/getValueByKeys theme "spacing" "unit")}})
                   MyButton)))  
```

Fulcro example, thanks to [Souenzzo](https://gist.github.com/souenzzo/7f376efca955660e6221bca7827164ba)

## License

Copyright © 2018

Distributed under the Eclipse Public License v1.0.
