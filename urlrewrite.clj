; Coding kata
; The rewrite configuration file defines the following rules:
;
;1) /article/$1 into /article?id=$1 ($1 is always a number!)
;(e.g. /article/512 into /article?id=512)
;
;2) /guide/$1/2008/$2 into /guide/$1/2009/$2 ($2 can be empty)
;(e.g. /guide/srv/2008/x12_3/index.html into /guide/srv/2009/x12_3/inde;x.html)
;
;3) /company/$1/$2 into /company?country=$1&city=$2 ($2 can be empty)
;(e.g. /company/usa/newyork into /company?country=usa&city=newyork)
;
;If none of the rules apply simply return the incoming URL!

(ns viksit-urls
  (:use [clojure.contrib.str-utils :as s1]))


; Approach 1
; First step will be to determine which pattern the url maps to, using conds

; Next, we substitute the url as required
; url1 $1 is always a number
(def url1 "/article/$1")
(defn transform-url1 [url1] 
     (let [[a b c] (re-split #"/" url1)] 
       (str-join "" [(str-join "/" ["" b "?id="]) c])))

; url2 - $1 can be anything, and $2 could be empty
(def url2 "/guide/$1/2008/$2")
(let [[a b c d e] (re-split #"/" url2)] 
  (str-join "/" ["" b c (+ (. Integer parseInt d) 1) e]))

; etc.

; A better approach is to use Clojure's built in matching system
; Pass in the url, pattern and format strings
; Destructure the pattern, and format from a sequence 
(defn rewrite [url [pattern frmt & next]]
  ; matches contains a seq of matches of the pattern on the URL
  (let [matches (re-matches pattern url)
   ; next contains the rest of the (pattern url) pairs
	next (seq next)]
    ;cond evaluates the first expression to see if true
    ; ie, any matches found or not
    (cond 
     ; if yes, then format the rest of the matches with frmt string
     matches (apply format frmt (rest matches))
     ; recursively do this for all the other (pattern url) pairs
     next (recur url next)
     ; if nothing matched, then return the original url
     :else url)))
    

(defn -rewrite [this url]
  (rewrite url [#"/article/(\d+)" "/article?id=%s"
		#"/guide/(.+)/2008/(.*)" "/guide/%s/2009/%s"
		#"/company/([^/]+)/([^/]+)" "/company?country=%s&city=%s"
		#"/company/([^/]+)/?" "/company?country=%s"]))


