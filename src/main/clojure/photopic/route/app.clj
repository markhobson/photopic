(ns photopic.route.app
  (:use
    compojure.core
    [photopic.route.index :as index]
    photopic.route.topic
    ring.middleware.content-type
    ring.middleware.params
    ring.middleware.resource
    ring.middleware.not-modified
  )
)

(defroutes app-routes
  index/router
  topic-routes
)

(defroutes app
  (-> app-routes
    (wrap-params)
    (wrap-resource "META-INF/resources")
    (wrap-content-type)
    (wrap-not-modified)
  )
)
