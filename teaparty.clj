; Tea Party
; Viksit Gaur

(defn welcome [name isWoman isSir]
  (let [lastname (second (re-seq #"\w+" name))]
       (cond isWoman (format "Hello Ms. %s" lastname)
	     isSir (format "Hello Sir %s" lastname)
	     't (format "Hello Mr. %s" lastname))))
(welcome "George Orwell" false false)

			 
