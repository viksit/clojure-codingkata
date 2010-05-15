(ns viksit-towersofhanoi)

;; Towers of Hanoi
;; If num is not 1, then first move the peg from f to v via t
;; And then recurse into the function by moving the peg from v to t using f

(defn towers [num from to via]
  (if (== num 1) (prn (format "Move from %s to %s" from to))
      (do
	(towers (dec num) from via to)
	(prn (format "Move from %s to %s" from to))
	(recur (dec num) via to from))))