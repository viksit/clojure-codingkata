; Recursive function to generate the GCD of 2 numbers
; Viksit Gaur
(defn gcd [a b]
  (if (zero? b) a
  (gcd b (mod a b))))
    
