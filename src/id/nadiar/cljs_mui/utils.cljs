(ns id.nadiar.cljs-mui.utils
  (:require [cljsjs.react]))

(defn component-factory
  ([react-class args]
   (let [[attr node] (if (map? (first args)) args (cons {} args))]
     (js/React.createElement react-class (clj->js attr) node)))
  ([root-obj type args]
   (component-factory (aget root-obj type) args)))