(ns comm-fix.core-test
  (:require [clojure.test :refer :all]
            [comm-fix.core :refer :all]))

(deftest find-marker-postion-test
  (testing "finds the position of the marker"
    (is (= (find-marker-postion "mjqjpqmgbljsphdztnvjfqwrcgsmlb") 7))
    (is (= (find-marker-postion "bvwbjplbgvbhsrlpgdmjqwftvncz") 5))
    (is (= (find-marker-postion "nppdvjthqldpwncqszvftbrmjlhg") 6))
    (is (= (find-marker-postion "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg") 10))
    (is (= (find-marker-postion "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw") 11))))
