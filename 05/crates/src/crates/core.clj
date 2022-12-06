(ns crates.core
  (:require [clojure.string :as str])
  (:gen-class))

(defn split-input [input]
  (str/split input #"\n\n"))

(defn parse-state-line [line]
  (loop [vect [] line-rest (apply vector (str/split line #""))]
    (let [
        first-three (take 3 line-rest)
        is-empty? (= (map str/trim first-three) '("" "" "")) 
        value (if is-empty? :empty (first (rest first-three)))
      ]
        (if (empty? line-rest)
          vect
          (recur (conj vect value) (drop 4 line-rest))))))

(defn is-not-empty-marker [elem]
  (not (= :empty elem)))

(defn remove-empty [state]
  (map #(filter is-not-empty-marker %) state))

(defn parse-initial-state [input]
  (let [
    split-in-lines (str/split-lines input)
    last-line-dropped (drop-last split-in-lines)
  ]
    (remove-empty (apply map vector (map parse-state-line last-line-dropped)))))

(defn parse-single-instruction [instruction-str]
  (let [
    interrim-map (apply hash-map (str/split instruction-str #" "))
    transform-value (fn [key] (Integer/parseInt (get interrim-map key)))
  ]
    (hash-map
      :move (transform-value "move")
      :from (transform-value "from")
      :to (transform-value "to")
    )))

(defn parse-instructions [input]
  (map parse-single-instruction (str/split-lines input)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
