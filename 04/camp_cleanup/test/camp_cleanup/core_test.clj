(ns camp-cleanup.core-test
  (:require [clojure.test :refer :all]
            [camp-cleanup.core :refer :all]))

(deftest overlaps-test
  (testing "checks if the ramges overlap"
    (is (= (overlaps? ['(3 4) '(1 7)]) true))
    (is (= (overlaps? ['(1 7) '(3 4)]) true))
    (is (= (overlaps? ['(1 3) '(3 4)]) true))
    (is (= (overlaps? ['(3 4) '(1 3)]) true))
    (is (= (overlaps? ['(1 3) '(6 9)]) false))
  ))
