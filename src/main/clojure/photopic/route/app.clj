(ns photopic.route.app
  (:use
    compojure.core
    photopic.resource.topic
    photopic.route.index
    photopic.route.topic
    ring.middleware.content-type
    ring.middleware.params
    ring.middleware.resource
    ring.middleware.not-modified
    ring.util.response
  )
)

(defroutes app-routes
  index-routes
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
