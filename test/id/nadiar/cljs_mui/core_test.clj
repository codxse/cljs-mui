(ns id.nadiar.cljs-mui.core-test
  (:require [clojure.test :refer :all]
            [id.nadiar.cljs-mui :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 1))))

(def ^{:private true} component-api "https://raw.githubusercontent.com/mui-org/material-ui/master/packages/material-ui/src/index.js")
(def ^{:private true} component-icons "https://raw.githubusercontent.com/cljsjs/packages/master/material-ui-icons/resources/cljsjs/material-ui-icons/common/material-ui-icons.ext.js")

(defn- exctract-name
  [source output]
  (->> (clojure.string/split (slurp source) #"(\s)")
       (filter #(some (partial = (first %)) "ABCDEFGHIJKLMNOPQRSTUVWXYZ"))
       (map #(.replaceAll % "[-+.^:,]" ""))
       (remove #{"MaterialUIIcons"})
       vec
       (spit output)))

(def ^{:private true} spit-component-api #(exctract-name component-api "component-api.edn"))
(def ^{:private true} spit-component-icons #(exctract-name component-icons "component-icons.edn"))

(def ^{:private true} component-tags (read-string (slurp "component-api.edn")))
(def ^{:private true} component-icons (read-string (slurp "component-icons.edn")))

(defn- generate-components
  [tags]
  (->> (map #(str "(defn " % " [& args] (into-material-component \"" % "\" args))") tags)
       (map read-string)))

(defn- generate-icons
  [tags]
  (->> (map #(str "(defn " % " [& args] (into-material-icon \"" % "\" args))") tags)
       (map read-string)))

(defn- generate-fulcro-components
  [tags]
  (->> (map #(str "(def " % " (component-factory (aget js/MaterialUI \"" % "\")))") tags)
       (map read-string)))

(defn- generate-fulcro-icons
  [tags]
  (->> (map #(str "(def " % " (component-factory (aget js/MaterialUIIcons \"" % "\")))") tags)
       (map read-string)))