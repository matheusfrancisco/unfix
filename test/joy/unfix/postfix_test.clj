(ns joy.unfix.postfix-test
  (:use [clojure.test :only [deftest is]])
  (:use [joy.unfix.postfix :only [postfix postfix2]]))

(deftest test-postfix
  (is (= [14] (postfix 5 1 2 + 4 * + 3 -)))
  (is (= [9]  (postfix 3 2 1 + *)))
  (is (= [7]  (postfix 1 2 3 * +))))

(defn sum! [a b c] (+ a c b))
(defn max> [a b] (max a b))

(deftest test-postfix-2
  (is (= [8] (postfix 5 1 2 sum!)))
  (is (= [1 8] (postfix 5 1 2 sum! 1)))
  (is (= [2 5] (postfix 5 1 2 max>))))


