(ns camp-cleanup.core
  (:require [clojure.string :as str])
  (:gen-class))

(def input-path (.getPath (clojure.java.io/resource "input")))
(def input-content (slurp input-path))

(defn split-range [range]
  (map #(Integer/parseInt %) (str/split range #"-")))

(defn parse-input [input]
  (map #(map split-range (str/split % #",")) (str/split-lines input-content)))

(defn partially-contains? [larger-range, smaller-range]
  (let [ 
    larger-range-start (first larger-range)
    larger-range-end (last larger-range)
    smaller-range-start (first smaller-range)
    smaller-range-end (last smaller-range)
  ]
    (and (<= smaller-range-start larger-range-end) (>= smaller-range-end larger-range-start)))
)

(defn overlaps? [pair]
  (apply partially-contains? pair))

(defn find-overlaps [pair-list]
  (filter overlaps? pair-list))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (count (find-overlaps (parse-input input-content)))))
