(ns id.nadiar.cljs-mui.style
  (:require [goog.object :as gobj]))

(def mui-colors (js->clj (aget js/MaterialUI "colors")))

(def withStyle (aget js/MaterialUI "withStyles"))

(def createMuiTheme (aget js/MaterialUI "createMuiTheme"))

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

(defn class-name
  "Function helper to get class-name from component.
   Accept react component and className as string or keyword. "
  [component id]
  (assert (or (string? id) (keyword? id)) "`id` must be string or keyword.")
  (gobj/getValueByKeys component "props" "classes" (name id)))

(def theme (create-mui-theme {}))

(defn with-style
  "Return mui withStyle fn. Accept clojure map as argument."
  [m]
  (assert (map? m) "`m` must be valid clojure map.")
  (withStyle (clj->js m)))