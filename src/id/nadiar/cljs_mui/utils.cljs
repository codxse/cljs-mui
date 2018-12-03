(ns id.nadiar.cljs-mui.utils
  (:require [goog.object :as gobj]))

(defn component-factory
  ([react-class args]
   (let [fargs (first args)
         [attr & nodes] (if (or (map? fargs)
                             (nil? fargs))
                       args
                       (cons {} args))]
     (apply js/React.createElement react-class (clj->js attr) nodes)))
  ([root-obj type args]
   (component-factory (gobj/get root-obj type) args)))