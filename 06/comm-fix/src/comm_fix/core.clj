(ns comm-fix.core
  (:require [clojure.string :as str])
  (:gen-class))

(defn find-marker-postion-recur [signal index]
  (let [
    first-4 (apply hash-set (take 4 signal))
  ]
    (if (= (count first-4) 4)
      index
      (recur (rest signal) (inc index)))))

(defn find-marker-postion [input]
  (find-marker-postion-recur (str/split input #"") 0))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
