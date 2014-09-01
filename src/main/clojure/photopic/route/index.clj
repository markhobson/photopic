(ns photopic.route.index
  (:use
    compojure.core
    ring.util.response
  )
)

(defroutes index-routes
  (GET "/" []
    (redirect "/topics")
  )
)
