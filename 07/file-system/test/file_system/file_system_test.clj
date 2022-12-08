(ns file-system.file-system-test
  (:require [clojure.test :refer :all]
            [file-system.file-system :refer :all]))

(deftest add-child-test
  (testing "adds a child to a folder"
    (is (= 
    (let [
        folder (create-folder "test-folder" [] nil)
        child (create-file "test-file" 500 nil)
      ]
        (add-child folder child))
    (create-folder "test-folder" [
      (create-file "test-file" 500 nil)
    ] nil)
  ))))
