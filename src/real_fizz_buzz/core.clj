(ns real-fizz-buzz.core
  (:gen-class))

(defn fizz-buzz [n]
  (cond (.contains (str n) "3") "lucky"
        (zero? (mod n 15)) "fizzbuzz"
        (zero? (mod n 5)) "buzz"
        (zero? (mod n 3)) "fizz"
        :else n))

(defn real-fizz-buzz [x]
  (map fizz-buzz x))

(defn fizz-buzz-frequencies [fizzBuzz]
  (let [freq (select-keys (frequencies fizzBuzz) ["fizz" "buzz" "fizzbuzz" "lucky"])]
    (assoc freq "integer" (count (filter number? fizzBuzz)))))

(defn -main
  "I don't do a whole lot"
  [& args]
  (let [maxValue  (read-string (first args))]
    (println (str  "The real FizzBuzz output over a range from 1 to " maxValue ":"))
    (println (real-fizz-buzz (range 1 maxValue)))
    (println (fizz-buzz-frequencies (real-fizz-buzz (range 1 maxValue))))))
