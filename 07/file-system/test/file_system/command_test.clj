(ns file-system.command-test
  (:require [clojure.test :refer :all]
            [file-system.command :refer :all]
            [file-system.file-system :refer :all]))

(deftest change-dir-root-test
  (testing "changes cwd to root"
    (is (= 
      (let [
        initial-state {:cwd ["/" "a"] :file-system empty-file-system}
      ] (change-dir initial-state "/"))
      {:cwd ["/"] :file-system empty-file-system}
    ))))

(deftest chnage-dir-to-child-test
  (testing "changes the cwd to child"
    (is (= 
      (let [initial-state {:cwd ["/" "a"] :file-system empty-file-system}]
        (change-dir initial-state "b"))    
      (hash-map :cwd ["/" "a" "b"] :file-system empty-file-system)
    ))))

(deftest chnage-dir-to-parent-test (
  testing "chnages the cwd to parent directory"
  (is (=
    (let [initial-state {:cwd ["/" "a" "b"] :file-system empty-file-system}]
        (change-dir initial-state ".."))
    (hash-map :cwd ["/" "a"] :file-system empty-file-system)  
  ))
))

