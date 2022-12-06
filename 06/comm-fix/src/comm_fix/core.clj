(ns comm-fix.core
  (:require [clojure.string :as str])
  (:gen-class))

(def input-path (.getPath (clojure.java.io/resource "input")))
(def input-content (str/trim (slurp input-path)))

(defn find-all-unique-recur [signal length index]
  (let [
    first-n (apply hash-set (take length signal))
  ]
    (if (= (count first-n) length)
      (+ index length)
      (recur (rest signal) length (inc index)))))

(defn find-all-unique [signal length]
  (find-all-unique-recur signal length 0))

(defn find-marker-position [input]
  (find-all-unique (str/split input #"") 4))

(defn find-message-position [input]
  (find-all-unique (str/split input #"") 14))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (find-message-position input-content)))
