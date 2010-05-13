; Teleprompter
; Viksit Gaur

(ns viksit-teleprompter
  (:use [clojure.contrib.str-utils :as s1]))

(def +testdict+ {"kewl" "cool", "hammered" "drunk"})
 
(defn translate [text dict]
  (let [slang (second (re-find #"\$(\S+?)\$" text))]
    (s1/re-sub #"\$[a-z]+\$" (dict slang) text)))

