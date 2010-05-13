; Teleprompter 2
; Viksit Gaur

(ns viksit-teleprompter2
  (:use [clojure.contrib.str-utils :as s1]))

(def +testdict+ {"kewl" "cool", "hammered" "drunk"})

(def mystr "'crash' the $kewl$ $hammered$ 'crashs'")

(defn subquote [text]
  (s1/re-gsub #"\'[a-z]+\'" "BLEEP" text))

(defn findval [dict s] (if-let [k (dict (nth (re-find #"\$(\S+)\$" s) 1))] k s))

(defn trans [tokens dict]
  (let [k (str-join " " (map (fn [s] (if-let [s$ (findval dict s)] s$ s))  tokens))]
    (subquote k)))

(defn translate [text dict]
  (let [v (vec (re-split #" " text))]
    (trans v dict)))
  
(translate mystr +testdict+)
