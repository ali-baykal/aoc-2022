(ns calories.core
  (:require [clojure.string :as str])
  (:gen-class))

(def input-path (.getPath (clojure.java.io/resource "input")))
(def input-content (slurp input-path))

(defn map2 [mapping-func two-dim] 
  (map (fn [group] (map mapping-func group)) two-dim))

(defn group-calories [input]
  (map2 #(Integer/parseInt %) (map (fn [calories-str] (str/split calories-str #"\n")) (str/split input #"\n\n"))))

(defn sum [x] (reduce + x))

(defn sum-calories [grouped-calories]
  (map sum grouped-calories))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (apply max (sum-calories (group-calories input-content)))))
