(ns photopic.route.index
  (:use
    compojure.core
    ring.util.response
  )
)

(defroutes router
  (GET "/" []
    (redirect "/topics")
  )
)
