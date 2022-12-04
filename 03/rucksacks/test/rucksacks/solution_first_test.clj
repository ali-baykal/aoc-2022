(ns rucksacks.solution-first-test
  (:require [clojure.test :refer :all]
            [rucksacks.solution-first :refer :all]))

(deftest parse-compartments-test
  (testing "splits a rucksack into two equal sized compartments"
    (is (= (parse-compartments "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL") '("jqHRNqRjqzjGDLGL" "rsFMfFZSrLrFZsSL")))))

(deftest parse-items-test
  (testing "split compartment in its items"
  (is (= (parse-items "jqHRNqRjqz") '("j" "q" "H" "R" "N" "q" "R" "j" "q" "z")))))
