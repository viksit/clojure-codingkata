; Viksit Gaur
; Fizzbuzz

(ns org.viksit.fizzbuzz)

(defn fizz? [num] (if (== (mod num 3) 0) "fizz"))
(defn buzz? [num] (if (== (mod num 5) 0) "buzz"))
(defn fizzbuzz? [num] (and (fizz? num) (buzz? num)))

(defn -main [num]
  (if (fizzbuzz? num) "fizzbuzz"
      (if (fizz? num) "fizz"
	  (if (buzz? num) "buzz"
	      (str num)))))
