(ns joy.unfix.postfix)

(defn arity [f]
  (alength (.getParameterTypes (first (.getDeclaredMethods (class f))))))

(defn postfix [& e]
  (reduce #(if (fn? %2)
             (let [n (arity %2)
                   args (take n %)
                   r (drop n %)]
               (cons (apply %2 (reverse args)) r))
             (cons %2 %))
          []
          e))

