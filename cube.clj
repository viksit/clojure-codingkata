(ns viksit-cube
  (:use [clojure.contrib.str-utils :as s1]))

; First, we need to compute whether a given number is prime or not
(defn divides? [divisor dividend]
  (zero? (rem dividend divisor)))

(defn prime? [n]
  (when (> n 1)
    (every? (fn [x] (not (divides? x n)))
	    (range 2 (inc (Math/sqrt n))))))

(defn str-sum [n]
     (reduce + (map (fn [x] (Integer/valueOf x))
		    (rest (s1/re-split #"" n)))))

; boolean containsPrimeNumber (String code1, String code2, String code3)
(defn contains-prime-number [code1 code2 code3]
  (if (true?
       (or (prime? (str-sum code1))
	   (prime? (str-sum code2))
	   (prime? (str-sum code3))))
    (prn "Trap")
    (prn "Fine")))
       
	       