(ns calories.core-test
  (:require [clojure.test :refer :all]
            [calories.core :refer :all]))

(def input "1000\n2000\n3000\n\n4000\n\n5000\n6000\n\n7000\n8000\n9000\n\n10000")


(deftest group-calories-test
  (testing "it parses input in a two dimensinal list of numbers"
    (is (= (group-calories input) [[1000, 2000, 3000], [4000], [5000, 6000], [7000, 8000, 9000], [10000]]))))
