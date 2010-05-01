(ns joy.unfix)

(defn rpn
  ([tokens] (rpn tokens []))
  ([[top & tail] stack]
     (if top
       (if (fn? top)
         (let [l (peek stack)
               s (pop stack)
               r (peek s)]
           (recur tail (conj (pop s) (top r l))))
         (recur tail (conj stack top)))
       stack)))
