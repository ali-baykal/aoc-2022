(ns comm-fix.core
  (:require [clojure.string :as str])
  (:gen-class))

(def input-path (.getPath (clojure.java.io/resource "input")))
(def input-content (str/trim (slurp input-path)))

(defn find-marker-postion-recur [signal index]
  (let [
    first-4 (apply hash-set (take 4 signal))
  ]
    (if (= (count first-4) 4)
      (+ index 4)
      (recur (rest signal) (inc index)))))

(defn find-marker-postion [input]
  (find-marker-postion-recur (str/split input #"") 0))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (find-marker-postion input-content)))
