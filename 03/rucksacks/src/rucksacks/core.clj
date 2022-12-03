(ns rucksacks.core
  (:require [clojure.string :as str])
  (:require [clojure.set :as sets])
  (:gen-class))

(def input-path (.getPath (clojure.java.io/resource "input")))
(def input-content (slurp input-path))

(defn parse-rucksacks [input]
  (str/split-lines input-content))

(defn parse-compartments [rucksack]
  (let [half (/ (count rucksack) 2)]
    (list (subs rucksack 0 half) (subs rucksack half))))

(defn parse-items [compartment]
  (str/split compartment #""))

(defn parse-input [input]
  (map #(map parse-items (parse-compartments %)) (parse-rucksacks input)))

(defn find-common [set-list]
  (first (apply sets/intersection set-list)))

(def map-to-priority {
  "a"  1
  "b"  2
  "c"  3
  "d"  4
  "e"  5
  "f"  6
  "g"  7
  "h"  8
  "i"  9
  "j" 10
  "k" 11
  "l" 12
  "m" 13
  "n" 14
  "o" 15
  "p" 16
  "q" 17
  "r" 18
  "s" 19
  "t" 20
  "u" 21
  "v" 22
  "w" 23
  "x" 24
  "y" 25
  "z" 26
  "A" 27
  "B" 28
  "C" 29
  "D" 30
  "E" 31
  "F" 32
  "G" 33
  "H" 34
  "I" 35
  "J" 36
  "K" 37
  "L" 38
  "M" 39
  "N" 40
  "O" 41
  "P" 42
  "Q" 43
  "R" 44
  "S" 45
  "T" 46
  "U" 47
  "V" 48
  "W" 49
  "X" 50
  "Y" 51
  "Z" 52
})

(defn calc-priority [parsed-input]
  (map #(get map-to-priority (find-common (map set %))) parsed-input))

(defn sum [x] (reduce + x))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (sum (calc-priority(parse-input input-content)))))
