(ns id.nadiar.cljs-mui.style
  (:require [goog.object :as gobj]))

(def mui-colors (js->clj (gobj/get js/MaterialUI "colors")))

(def withStyles (gobj/get js/MaterialUI "withStyles"))

(def createMuiTheme (gobj/get js/MaterialUI "createMuiTheme"))

(def keyword-or-string? #(or (string? %) (keyword? %)))

(defn color-for
  "Get the color from Material color db.
   Accept:
   color as keyword / string
   level as integer

   Return `#000000` if color not found"
  [color_ level_]
  (if (keyword-or-string? color_)
    (if (int? level_)
      (get-in mui-colors [(name color_) (str level_)] "#000000")
      (throw (js/Error. "`level_` must be integer.")))
    (throw (js/Error. "`color_` must be string or keyword."))))

(defn create-mui-theme
  "Like `createMuiTheme` material-ui, but accept clojure map."
  [raw-theme]
  (if (map? raw-theme)
    (createMuiTheme (clj->js raw-theme))
    (throw (js/Error. "`raw-theme` must be valid clojure map."))))

(defn class-name
  "Function helper to get class-name from component.
   Accept react component and className as string or keyword. "
  [component id]
  (if (keyword-or-string? id)
    (gobj/getValueByKeys component "props" "classes" (clj->js id))
    (throw (js/Error. "`id` must be string or keyword."))))

(def theme (create-mui-theme {:typography {:useNextVariants true}}))

(defn with-style
  "Return mui withStyle fn. Accept clojure map as argument."
  [m]
  (if (map? m)
    (withStyles (clj->js m))
    (throw (js/Error. "`m` must be valid clojure map."))))