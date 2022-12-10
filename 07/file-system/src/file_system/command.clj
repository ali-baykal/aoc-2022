(ns file-system.command
  (:require [clojure.test :refer :all]
            [file-system.command :refer :all]
            [file-system.file-system :refer :all])
  (:gen-class))

(defn change-dir [state dir-name]
  (let [
    cwd (:cwd state)
    new-cwd (if (= dir-name "/") ["/"] 
      (if (= dir-name "..") (drop-last cwd) (conj cwd dir-name))
    )
  ]
  (merge state {:cwd new-cwd})))