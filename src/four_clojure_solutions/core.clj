(ns four-clojure-solutions.core)


;; Run all these in a REPL

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Problem 1, Nothing but the Truth
;;
;; (= __ true)

(= true true)


;; Problem 2, Simple Math
;;
;; (= (- 10 (* 2 3)) __)

4


;; Problem 3, Strings
;;
;; (= __ (.toUpperCase "hello world"))

(.toUpperCase "Hello world")

;; Problem 4, Lists
;;
;; (= (list __) '(:a :b :c))

:a :b :c
; usage
(= (list :a :b :c) '(:a :b :c))



;; Problem 5, conj on lists
;;
;; (= __ (conj '(2 3 4) 1))
;;
;; (= __ (conj '(3 4) 2 1))


'(1 2 3 4)



;; Problem 6, Vectors
;;
;; (= [__] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))

:a :b :c
; usage
(= [:a :b :c] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))



;; Problem 7, conj on vectors
;;
;; (= __ (conj [1 2 3] 4))
;;
;; (= __ (conj [1 2] 3 4))

[1 2 3 4]


;; Problem 8, Sets
;;
;; (= __ (set '(:a :a :b :c :c :c :c :d :d)))
;;
;; (= __ (clojure.set/union #{:a :b :c} #{:b :c :d}))

#{:a :b :c :d}


;; Problem 9, conj on sets
;;
;; (= #{1 2 3 4} (conj #{1 4 3} __))

2




;; Problem 10, Maps
;;
;; (= __ ((hash-map :a 10, :b 20, :c 30) :b))
;;
;; (= __ (:b {:a 10, :b 20, :c 30}))

20
