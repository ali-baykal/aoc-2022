(ns crates.core
  (:require [clojure.string :as str])
  (:require [clojure.core.reducers :as reducers])
  (:gen-class))

(def input-path (.getPath (clojure.java.io/resource "input")))
(def input-content (slurp input-path))

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

(defn apply-move-9000 [state move]
  (let [
        {from :from
        amount :move
        to :to } move
        from-index (- from 1)
        to-index (- to 1)
        taken-from (drop amount (get state from-index))
        crates (reverse (take amount (get state from-index)))
        added-to (apply conj (get state to-index) (reverse crates))
        from-updated (assoc state from-index taken-from)
        result (assoc from-updated to-index added-to)
      ]

      result ))


(defn apply-move-9001 [state move]
  (let [
        {from :from
        amount :move
        to :to } move
        from-index (- from 1)
        to-index (- to 1)
        taken-from (drop amount (get state from-index))
        crates (take amount (get state from-index))
        added-to (apply conj (get state to-index) (reverse crates))
        from-updated (assoc state from-index taken-from)
        result (assoc from-updated to-index added-to)
      ]

      result ))

(defn solve-first [input]
  (let [
    [initial-state-input instructions-input] (split-input input)
    initial-state (parse-initial-state initial-state-input)
    instructions (parse-instructions instructions-input)
  ]
    (reducers/reduce apply-move-9000 (apply vector initial-state) instructions)))

(defn solve-second [input]
  (let [
    [initial-state-input instructions-input] (split-input input)
    initial-state (parse-initial-state initial-state-input)
    instructions (parse-instructions instructions-input)
  ]
    (reducers/reduce apply-move-9001 (apply vector initial-state) instructions)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (map first (solve-second input-content))))
