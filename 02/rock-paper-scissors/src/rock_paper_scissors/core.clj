(ns rock-paper-scissors.core
  (:require [clojure.string :as str])
  (:gen-class))

(def input-path (.getPath (clojure.java.io/resource "input")))
(def input-content (slurp input-path))

(defn map2 [mapping-func two-dim] 
  (map (fn [group] (map mapping-func group)) two-dim))

(def map-to-symbol {
  "X" :lose
  "Y" :draw
  "Z" :win
  "A" :rock
  "B" :paper
  "C" :scissors
})

(def rock-point 1)
(def paper-point 2)
(def scissors-point 3)
(def win-point 6)
(def draw-point 3)
(def lose-point 0)

(def move-score (hash-map
  '(:rock :draw) (+ rock-point draw-point)
  '(:rock :lose) (+ scissors-point lose-point)
  '(:rock :win) (+ paper-point win-point)

  '(:scissors :win) (+ rock-point win-point)
  '(:scissors :draw) (+ scissors-point draw-point)
  '(:scissors :lose) (+ paper-point lose-point)

  '(:paper :lose) (+ rock-point lose-point)
  '(:paper :win) (+ scissors-point win-point)
  '(:paper :draw) (+ paper-point draw-point)
))

(defn group-moves [input]
  (map2 #(get map-to-symbol %) (map (fn [move-line] (str/split move-line #"\s")) (str/split input #"\n"))))

(defn calc-scores [move-list]
  (map #(get move-score %) move-list))

(defn sum [x] (reduce + x))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (sum (calc-scores (group-moves input-content)))))
