(ns rucksacks.core-test
  (:require [clojure.test :refer :all]
            [rucksacks.core :refer :all]))
  
(deftest group-by-3-test
  (testing "grouping item into lists of 3")
    (is (= (group-by-3 '(1 2 3 4 5 6 7 8 9)) (list '(1 2 3) '(4 5 6) '(7 8 9)))))
