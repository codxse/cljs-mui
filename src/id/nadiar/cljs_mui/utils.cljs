(ns id.nadiar.cljs-mui.utils
  (:require [cljsjs.react]))

(defn component-factory
  ([react-class args]
   (let [first-arg (first args)
         [attr node] (if (or (map? first-arg) (nil? first-arg)) args (cons (clj->js {}) args))]
     (apply js/React.createElement react-class (clj->js attr) node)))
  ([root-obj type args]
   (component-factory (aget root-obj type) args)))
