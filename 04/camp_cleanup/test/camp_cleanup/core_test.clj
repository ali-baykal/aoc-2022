(ns camp-cleanup.core-test
  (:require [clojure.test :refer :all]
            [camp-cleanup.core :refer :all]))

(deftest fully-contains-test
  (testing "checks if the first range fully contains the second one"
    (is (= (fully-contains? '(1 7) '(3 4)) true))
    (is (= (fully-contains? '(1 3) '(3 4)) false))
    (is (= (fully-contains? '(3 4) '(1 7)) false))
  ))

(deftest overlaps-test
  (testing "checks if the any of ranges (within a pair) fully contains the other"
    (is (= (overlaps? '([1 7] [3 4])) true))
    (is (= (overlaps? '([1 3] [3 4])) false))
    (is (= (overlaps? '([3 4] [1 7])) true))
  ))
