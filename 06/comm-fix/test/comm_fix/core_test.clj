(ns comm-fix.core-test
  (:require [clojure.test :refer :all]
            [comm-fix.core :refer :all]))

(deftest find-marker-postion-test
  (testing "finds the position of the marker"
    (is (= (find-marker-postion "bvwbjplbgvbhsrlpgdmjqwftvncz")) 5)
    (is (= (find-marker-postion "bvwbjplbgvbhsrlpgdmjqwftvncz")) 6)
    (is (= (find-marker-postion "bvwbjplbgvbhsrlpgdmjqwftvncz")) 10)
    (is (= (find-marker-postion "bvwbjplbgvbhsrlpgdmjqwftvncz")) 11)))
