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



;; Problem 11, conj on maps
;;
;; (= {:a 1, :b 2, :c 3} (conj {:a 1} __ [:c 3]))

[:b 2]




;; Problem 12, Sequences
;;
;; (= __ (first '(3 2 1)))
;;
;; (= __ (second [2 3 4]))
;;
;; (= __ (last (list 1 2 3)))

3


;; Problem 13, rest
;;
;; (= __ (rest [10 20 30 40]))

[20 30 40]


;; Problem 14, Functions
;;
;; (= __ ((fn add-five [x] (+ x 5)) 3))
;;
;; (= __ ((fn [x] (+ x 5)) 3))
;;
;; (= __ (#(+ % 5) 3))
;;
;; (= __ ((partial + 5) 3))

8

;; Problem 15, Double Down
;;
;; (= (__ 2) 4)
;; (= (__ 3) 6)
;; (= (__ 11) 22)
;; (= (__ 7) 14)


* 2
;; usage
(= (* 2 2) 4)



;; Problem 16, Hello World
;;
;; (= (__ "Dave") "Hello, Dave!")
;;
;; (= (__ "Jenn") "Hello, Jenn!")
;;
;; (= (__ "Rhea") "Hello, Rhea!")

((fn [name] (str "Hello, " name "!")) "Dave")



;; Problem 17, map
;;
;; (= __ (map #(+ % 5) '(1 2 3)))

'(6 7 8)




;; Problem 18, filter
;;
;; (= __ (filter #(> % 5) '(3 4 5 6 7)))

(= '(6 7) (filter #(> % 5) '(3 4 5 6 7)))



;; Problem 19, Last Element
;;
;;(= (__ [1 2 3 4 5]) 5)
;;(= (__ '(5 4 3)) 3)
;;(= (__ ["b" "c" "d"]) "d")


((fn [x]
   (->> x
        reverse
        first)) [1 2 3 4 5])




;; Problem 20, Penultimate Element
;;
;; Write a function which returns the second to last element from a sequence.
;;
;;(= (__ (list 1 2 3 4 5)) 4)
;;(= (__ ["a" "b" "c"]) "b")
;;(= (__ [[1 2] [3 4]]) [1 2])

((fn [x]
   (second (reverse x))) (list 1 2 3 4 5))


;; Problem 21, Nth Elements
;;
;; Write a function which returns the Nth element from a sequence.
;;
;;(= (__ '(4 5 6 7) 2) 6)
;;(= (__ [:a :b :c] 0) :a)
;;(= (__ [1 2 3 4] 1) 2)
;;(= (__ '([1 2] [3 4] [5 6]) 2) [5 6])


((fn [v n]
   (get (zipmap (range (count v)) (vec v)) n)) '(4 5 6 7) 2)



;; Problem 22, Count a Sequence
;;
;; Write a function which returns the total number of elements in a sequence.
;;
;;(= (__ '(1 2 3 3 1)) 5)
;;(= (__ "Hello World") 11)
;;(= (__ [[1 2] [3 4] [5 6]]) 3)
;;(= (__ '(13)) 1)
;;(= (__ '(:a :b :c)) 3)


((fn [vs]
   (->> vs
        (mapcat #(vector %2 %1) (range))
        last
        inc)) '(1 2 3 3 1))




;; Problem 23, Reverse a Sequence
;;
;;Write a function which reverses a sequence.
;;
;;(= (__ [1 2 3 4 5]) [5 4 3 2 1])
;;(= (__ (sorted-set 5 7 2 7)) '(7 5 2))
;;(= (__ [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]])


((fn [ins]
   (reduce #(cons %2 %1) [] ins)
   ) [1 2 3 4 5])





;; Problem 24, Sum It All Up
;;
;; Write a function which returns the sum of a sequence of numbers.
;;
;;(= (__ [1 2 3]) 6)
;;(= (__ (list 0 -2 5 5)) 8)
;;(= (__ #{4 2 1}) 7)
;;(= (__ '(0 0 -1)) -1)
;;(= (__ '(1 10 3)) 14)


((fn [x]
   (reduce + x)) [1 2 3])


;; Problem 25, Find the odd numbers
;;
;; Write a function which returns only the odd numbers from a sequence.
;;
;;(= (__ #{1 2 3 4 5}) '(1 3 5))
;;(= (__ [4 2 1 6]) '(1))
;;(= (__ [2 2 4 6]) '())
;;(= (__ [1 1 1 3]) '(1 1 1 3))

(filter odd? #{1 2 3 4 5})



;; Problem 26, Fibonacci Sequence
;;
;; Write a function which returns the first X fibonacci numbers.
;;
;;(= (__ 3) '(1 1 2))
;;(= (__ 6) '(1 1 2 3 5 8))
;;(= (__ 8) '(1 1 2 3 5 8 13 21))


((fn [n]
   (take n
         ((fn fib [a b]
            (lazy-seq
              (cons a (fib b (+ a b))))) 1 1))) 8)





;; Problem 27, Palindrome Detector
;;
;; Write a function which returns true if the given sequence is a palindrome. Hint: "racecar" does not equal '(\r \a \c \e \c \a \r)
;;
;;(false? (__ '(1 2 3 4 5)))
;;(true? (__ "racecar"))
;;(true? (__ [:foo :bar :foo]))
;;(true? (__ '(1 1 3 3 1 1)))
;;(false? (__ '(:a :b :c)))


((fn [x]
   (let [seq-forward  (seq x)
         seq-backward (reverse seq-forward)]
     (if (= seq-forward seq-backward)
       true
       false))) "racecar")



;; Problem 28, Flatten a Sequence
;;
;; Write a function which flattens a sequence.
;;
;;(= (__ '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
;;(= (__ ["a" ["b"] "c"]) '("a" "b" "c"))
;;(= (__ '((((:a))))) '(:a))









;; Problem 29, Get the Caps
;;
;; Write a function which takes a string and returns a new string
;; containing only the capital letters.
;;
;;(= (__ "HeLlO, WoRlD!") "HLOWRD")
;;(empty? (__ "nothing"))
;;(= (__ "$#A(*&987Zf") "AZ")

((fn [x]
   (apply str (
                filter
                #(re-find (re-pattern "[A-Z]") (str %))
                x
                ))) "HeLlO, WoRlD!")




;; Problem 30, Compress a Sequence
;;
;; Write a function which removes consecutive duplicates from a sequence.
;;
;;(= (apply str (__ "Leeeeeerrroyyy")) "Leroy")
;;(= (__ [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
;;(= (__ [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))


((fn [x]
   (seq (reduce (fn [x1 x2]
                  (if (= (last x1) x2)
                    x1
                    (conj x1 x2))
                  )
                [] x))) [[1 2] [1 2] [3 4] [1 2]])



;; Problem 31, Pack a Sequence
;;
;; Write a function which packs consecutive duplicates into sub-lists.
;;
;;(= (__ [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))
;;(= (__ [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))
;;(= (__ [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))


(partition-by (fn [x] x) [1 1 2 1 1 1 3 3])





;; Problem 32, Duplicate a Sequence
;;
;; Write a function which duplicates each element of a sequence.
;;
;;(= (__ [1 2 3]) '(1 1 2 2 3 3))
;;(= (__ [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))
;;(= (__ [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))
;;(= (__ [44 33]) [44 44 33 33])


(mapcat (fn [x]
          (repeat 2 x))
        [[1 2] [3 4]])




;; Problem 33, Replicate a Sequence
;;
;; Write a function which replicates each element of a sequence a variable number of times.
;;
;;(= (__ [1 2 3] 2) '(1 1 2 2 3 3))
;;(= (__ [:a :b] 4) '(:a :a :a :a :b :b :b :b))
;;(= (__ [4 5 6] 1) '(4 5 6))
;;(= (__ [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))
;;(= (__ [44 33] 2) [44 44 33 33])

((fn [c n]
   (mapcat
     #(repeat n %) c))
 [[1 2] [3 4]] 2)






;; Problem 34, Implement range
;;
;; Write a function which creates a list of all integers in a given range.
;;
;;(= (__ 1 4) '(1 2 3))
;;(= (__ -2 2) '(-2 -1 0 1))
;;(= (__ 5 8) '(5 6 7))

((fn [s e]
   (take (- e s) (iterate inc s))) -2 2)

;without using the iterate method
((fn [s e] (take (- e s) ((fn lzs [b]
                            (lazy-seq
                              (cons b (lzs (inc b))))) s))) 1 4)




;; Problem 35, Local bindings
;;
;; Clojure lets you give local names to values using the special let-form.
;;
;;(= __ (let [x 5] (+ 2 x)))
;;(= __ (let [x 3, y 10] (- y x)))
;;(= __ (let [x 21] (let [y 3] (/ x y))))


(= 7 (let [x 5] (+ 2 x)))




;; Problem 36, Let it Be
;;
;; Can you bind x, y, and z so that these are all true?
;;
;;(= 10 (let __ (+ x y)))
;;
;;(= 4 (let __ (+ y z)))
;;
;;(= 1 (let __ z))



(= 10 (let [x 7
            y 3
            z 1]
        (+ x y)))





;; Problem 37, Regular Expressions
;;
;; (= __ (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))


(= "ABC" (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))






;; Problem 38, Maximum value
;;
;; Write a function which takes a variable number of parameters and returns the maximum value.
;;
;;(= (__ 1 8 3 4) 8)
;;(= (__ 30 20) 30)
;;(= (__ 45 67 11) 67)


((fn [& nums]
   (->> nums
        sort
        last)) 30 20)





;; Problem 39, Interleave Two Seqs
;;
;; Write a function which takes two sequences and returns the first
;; item from each, then the second item from each, then the third, etc.
;;
;;(= (__ [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))
;;(= (__ [1 2] [3 4 5 6]) '(1 3 2 4))
;;(= (__ [1 2 3 4] [5]) [1 5])
;;(= (__ [30 20] [  25 15]) [30 25 20 15])


(= (mapcat #(list %1 %2) [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))




;; Problem 40, Interpose a Seq
;;
;; Write a function which separates the items of a sequence by an arbitrary value.
;;
;;(= (__ 0 [1 2 3]) [1 0 2 0 3])
;;(= (apply str (__ ", " ["one" "two" "three"])) "one, two, three")
;;(= (__ :z [:a :b :c :d]) [:a :z :b :z :c :z :d])



((fn [r c]
   (-> (map (fn [e] (vector e r)) c)
       flatten
       butlast
       vec)
   ) :z [:a :b :c :d])




;; Problem 41, Drop Every Nth Item
;;
;; Write a function which drops every Nth item from a sequence.
;;
;;(= (__ [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
;;(= (__ [:a :b :c :d :e :f] 2) [:a :c :e])
;;(= (__ [1 2 3 4 5 6] 4) [1 2 3 5 6])


((fn [c n]
   (->> (zipmap (range 1 (inc (count c))) c)
        (filter (fn [[k _]]
                  (if (= (rem k n) 0)
                    false
                    true)
                  ))
        (mapv #(second %))))
 [1 2 3 4 5 6 7 8] 3)



;; Problem 42, Factorial Fun
;;
;; Write a function which calculates factorials.
;;
;;(= (__ 1) 1)
;;(= (__ 3) 6)
;;(= (__ 5) 120)
;;(= (__ 8) 40320)


((fn [x]
   (->> (range 1 (inc x))
        (apply *))) 8)



;; Problem 43, Reverse Interleave
;;
;; Write a function which reverses the interleave process into x number of subsequences.
;;
;;(= (__ [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))
;;(= (__ (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))
;;(= (__ (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))

;apply will open up the partitioned list
;then map list to each element of each coll

((fn [col p]
   (->> (partition p col)
        (apply map list))) (range 9) 3)








;; Problem 44, Rotate Sequence
;;
;; Write a function which can rotate a sequence in either direction.
;;
;;(= (__ 2 [1 2 3 4 5]) '(3 4 5 1 2))
;;(= (__ -2 [1 2 3 4 5]) '(4 5 1 2 3))
;;(= (__ 6 [1 2 3 4 5]) '(2 3 4 5 1))
;;(= (__ 1 '(:a :b :c)) '(:b :c :a))
;;(= (__ -4 '(:a :b :c)) '(:c :a :b))




((fn [p col]
   (if (pos? p)
     (apply concat (reverse (split-at (rem p (count col)) col)))
     (apply concat (reverse (split-at (- (count col) (rem (abs p) (count col))) col)))
     )
   ) -2 [1 2 3 4 5])





;; Problem 45, Intro to Iterate
;;
;; The iterate function can be used to produce an infinite lazy sequence.
;;
;;(= __ (take 5 (iterate #(+ 3 %) 1)))


'(1 4 7 10 13)




;; Problem 46, Flipping out
;;
;; Write a higher-order function which flips the order of the arguments of an input function.
;;
;;(= 3 ((__ nth) 2 [1 2 3 4 5]))
;;(= true ((__ >) 7 8))
;;(= 4 ((__ quot) 2 8))
;;(= [1 2 3] ((__ take) [1 2 3 4 5] 3))


(= true (((fn [func]
            #(func %2 %1))
          >) 7 8))








;; Problem 47, Contain Yourself
;;
;; The contains? function checks if a KEY is present in a given collection.
;; This often leads beginner clojurians to use it incorrectly with
;; numerically indexed collections like vectors and lists.
;;
;;(contains? #{4 5 6} __)
;;(contains? [1 1 1 1 1] __)
;;(contains? {4 :a 2 :b} __)
;;(not (contains? [1 2 4] __))


(contains? [1 2 3 4] 4)                                     ; checks keys only not values








;; Problem 48, Intro to some
;;
;; The some function takes a predicate function and a collection.
;; It returns the first logical true value of (predicate x) where x is
;; an item in the collection.
;;
;;(= __ (some #{2 7 6} [5 6 7 8]))
;;(= __ (some #(when (even? %) %) [5 6 7 8]))

;;;;; in case a set is being used as predicate all the


6

(some #{2 7 6} [5 6 7 8])

split-at


;; Problem 49, Split a sequence
;;
;; Write a function which will split a sequence into two parts.
;;
;;(= (__ 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]])
;;(= (__ 1 [:a :b :c :d]) [[:a] [:b :c :d]])
;;(= (__ 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]])


((fn [n col]
   [(vec (take n col)) (vec (drop n col))])
 3 [1 2 3 4 5 6])




;; Problem 50, Split by Type
;;
;; Write a function which takes a sequence consisting of items with
;; different types and splits them up into a set of homogeneous
;; sub-sequences. The internal order of each sub-sequence should be maintained,
;; but the sub-sequences themselves can be returned in any order (this is why
;; 'set' is used in the test cases).
;;
;;(= (set (__ [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]})
;;(= (set (__ [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]})
;;(= (set (__ [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]})


((fn [a]
   (->> (group-by type a)
        (map second))) [[1 2] :a [3 4] 5 6 :b])
