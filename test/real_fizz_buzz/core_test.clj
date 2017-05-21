(ns real-fizz-buzz.core-test
  (:require [clojure.test :refer :all]
            [real-fizz-buzz.core :refer :all :as core]))

(def fizz-buzz-output
  '(1 2 "lucky" 4 "buzz" "fizz" 7 8 "fizz" "buzz" 11 "fizz" "lucky" 14 "fizzbuzz" 16 17 "fizz" 19 "buzz"))

(deftest test-fizz
  (testing "testing fizz, i.e., numbers that are multiples of 3"
    (doseq [n [6 9 12 18 21 24]]
      (is (= "fizz" (core/fizz-buzz n))))))

(deftest test-buzz
  (testing "testing buzz, i.e., numbers that are multiples of 5"
    (doseq [n [5 10 20 25 40 50]]
      (is (= "buzz" (core/fizz-buzz n))))))

(deftest test-fizz-buzz
  (testing "testing fizzbuzz, i.e., numbers that are multiples of 15"
    (doseq [n (range 45 100 15)]
      (is (= "fizzbuzz" (core/fizz-buzz n))))))

(deftest test-print-number
  (testing "testing printing a number that is not multiple of 3, 5 or 15"
    (doseq [n [1 2 4 7 8 11 14]]
      (is (= n (core/fizz-buzz n))))))

(deftest test-lucky
  (testing "testing lucky, i.e., any number with the digit 3"
    (doseq [n [3 13 23 30 33 43]]
      (is (= "lucky" (core/fizz-buzz n))))))

(deftest test-real-fizz-buzz
  (testing "testing the real fizz buzz"
    (is (= fizz-buzz-output (core/real-fizz-buzz (range 1 21))))))

(deftest test-fizz-buzz-frequencies
  (let [freq (core/fizz-buzz-frequencies fizz-buzz-output)]
    (is (= 4 (freq "fizz")))
    (is (= 3 (freq "buzz")))
    (is (= 2 (freq "lucky")))
    (is (= 1 (freq "fizzbuzz")))
    (is (= 10 (freq "integer")))))
