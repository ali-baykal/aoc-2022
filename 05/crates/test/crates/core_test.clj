(ns crates.core-test
  (:require [clojure.test :refer :all]
            [crates.core :refer :all]))

(defn read-resource [resource-name]
  (slurp (.getPath (clojure.java.io/resource resource-name))))

(def test-file-content 
  (read-resource "test-input"))

(def initial-state-string 
  (read-resource "initial-state"))

(def initial-state-list (vector
  '("N" "Z")
  '("D" "C" "M")
  '("P")
))

(def instructions-string
  (read-resource "instructions"))

(deftest split-input-test
  (testing "split the initial input into the intial state and the instructions"
    (is (= (split-input test-file-content) (list initial-state-string instructions-string)))))

(deftest parse-state-line-test
  (testing "parses a sing line into a vector"
    (is (= (parse-state-line "    [D] [F]") [:empty "D" "F"]))))

(deftest parse-initial-state-test
  (testing "turns initial state strin in to two dimensional list"
    (is (= (parse-initial-state initial-state-string) initial-state-list))))

(deftest parse-single-instruction-test
  (testing "parses a single line into a map")
    (is (= (parse-single-instruction "move 1 from 2 to 1") {:move 1, :from 2, :to 1})))

(deftest apply-move-9000-test
  (testing "applies the move the current state"
    (is (= 
          (apply-move-9000 initial-state-list {:move 2 :from 2 :to 3}) 
          (vector
            '("N" "Z")
            '("M")
            '("C" "D" "P")
          )
        )
    )))

(deftest apply-move-9001-test
  (testing "applies the move the current state"
    (is (= 
          (apply-move-9001 initial-state-list {:move 2 :from 2 :to 3}) 
          (vector
            '("N" "Z")
            '("M")
            '("D" "C" "P")
          )
        )
    )))    

(deftest solve-first-test 
  (testing "solves the first part")
    (is (= 
      (solve-first test-file-content) 
      (vector
        '("C")
        '("M")
        '("Z" "N" "D" "P")
      )
    )))

(deftest solve-second-test 
  (testing "solves the first part")
    (is (= 
      (solve-second test-file-content) 
      (vector
        '("M")
        '("C")
        '("D" "N" "Z" "P")
      )
    )))
