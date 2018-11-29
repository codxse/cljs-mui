(ns id.nadiar.cljs-mui.utils)

(defn component-factory
  ([react-class args]
   (let [fargs (first args)
         [attr node] (if (or (map? fargs)
                             (nil? fargs))
                       args
                       (cons {} args))]
     (js/React.createElement react-class (clj->js attr) node)))
  ([root-obj type args]
   (component-factory (aget root-obj type) args)))