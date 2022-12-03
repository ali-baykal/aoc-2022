(ns rock-paper-scissors.core-test
  (:require [clojure.test :refer :all]
            [rock-paper-scissors.core :refer :all]))

(deftest move-score-test
  (testing "has values for each move possibility"
    (is (= (get move-score '(:rock :paper)) 8))))
