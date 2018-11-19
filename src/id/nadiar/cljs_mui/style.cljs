(ns id.nadiar.cljs-mui.style
  (:require [material-ui]))

(def mui-colors (js->clj (aget js/MaterialUI "colors")))

(def with-style (aget js/MaterialUI "withStyles"))

(def create-mui-theme (aget js/MaterialUI "createMuiTheme"))

(defn color-for
  "Get the color from Material color db.
   Accept:
   color as keyword
   level as integer

   Return `#000000` if color not found"
  [color_ level_]
  (assert color_ "color must not be nil")
  (assert level_ "color level must not be nil")
  (get-in mui-colors [(name color_) (str level_)] "#000000"))

(defn create-mui-theme
  "Like `createMuiTheme` material-ui, but accept clojure map."
  [raw-theme]
  (assert (map? raw-theme) "theme must be valid clojure map.")
  (createMuiTheme (clj->js raw-theme)))