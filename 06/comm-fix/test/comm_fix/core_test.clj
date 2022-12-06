(ns comm-fix.core-test
  (:require [clojure.test :refer :all]
            [comm-fix.core :refer :all]))

(deftest find-marker-position-test
  (testing "finds the position of the marker"
    (is (= (find-marker-position "mjqjpqmgbljsphdztnvjfqwrcgsmlb") 7))
    (is (= (find-marker-position "bvwbjplbgvbhsrlpgdmjqwftvncz") 5))
    (is (= (find-marker-position "nppdvjthqldpwncqszvftbrmjlhg") 6))
    (is (= (find-marker-position "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg") 10))
    (is (= (find-marker-position "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw") 11))))

(deftest find-message-position-test
  (testing "finds the position of the marker"
    (is (= (find-message-position "mjqjpqmgbljsphdztnvjfqwrcgsmlb") 19))
    (is (= (find-message-position "bvwbjplbgvbhsrlpgdmjqwftvncz") 23))
    (is (= (find-message-position "nppdvjthqldpwncqszvftbrmjlhg") 23))
    (is (= (find-message-position "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg") 29))
    (is (= (find-message-position "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw") 26))))
