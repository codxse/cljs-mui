(ns id.nadiar.cljs-mui.fulcro.utils
  (:require [fulcro.client.localized-dom :as dom]))

(defn component-factory [component]
  "The Source code taken from:
   https://medium.com/@wilkerlucio/using-any-react-ui-kit-with-fulcro-82cce271b9cc"
  (fn [& args]
    (if (keyword? (first args))
      (dom/macro-create-element component (next args) (first args))
      (dom/macro-create-element component args))))
