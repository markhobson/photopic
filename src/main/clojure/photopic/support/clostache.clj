;; See: https://github.com/fhd/clostache/wiki/Using-Partials-as-Includes

(ns photopic.support.clostache
  (:use
    [clostache.parser :refer [render-resource]]
    [clojure.java.io :as io]
  )
)

(defn render-page
  "Pass in the template name (a string, sans its .mustache filename extension), the data for the template (a map), and
a list of partials (keywords) corresponding to like-named template filenames."
  [template data partials]
  (render-resource
    (str "templates/" template ".mustache")
    data
    (reduce
      (fn [accum pt] ;; "pt" is the name (as a keyword) of the partial.
        (assoc accum pt
          (slurp
            (io/resource
              (str "templates/" (name pt) ".mustache")
            )
          )
        )
      )
      {}
      partials
    )
  )
)
