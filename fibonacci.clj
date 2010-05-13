; Viksit Gaur 2010
; Function to generate fibonacci numbers

(defn- fib[]
  (map first (iterate (fn [[a b]] [b (+ a b)]) [0 1])))

(defn fibonacci [n]
  (nth (fib) n))
  
