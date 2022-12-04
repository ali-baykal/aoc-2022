(ns camp-cleanup.solution-first
  (:require [clojure.string :as str])
  (:gen-class))

(def input-path (.getPath (clojure.java.io/resource "input")))
(def input-content (slurp input-path))

(defn split-range [range]
  (map #(Integer/parseInt %) (str/split range #"-")))

(defn parse-input [input]
  (map #(map split-range (str/split % #",")) (str/split-lines input-content)))


(defn fully-contains? [larger-range, smaller-range]
  (let [ 
    larger-range-start (first larger-range)
    larger-range-end (last larger-range)
    smaller-range-start (first smaller-range)
    smaller-range-end (last smaller-range)
  ]
    (and (>= smaller-range-start larger-range-start) (<= smaller-range-end larger-range-end)))
)

(defn overlaps? [pair]
  (or (apply fully-contains? pair) (apply fully-contains? (reverse pair))))

(defn find-overlaps [pair-list]
  (filter overlaps? pair-list))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (count (find-overlaps (parse-input input-content)))))
