(ns photopic.routes
  (:use
    compojure.core
    photopic.resource.topic
    photopic.route.topic
    ring.middleware.content-type
    ring.middleware.params
    ring.middleware.resource
    ring.middleware.not-modified
    ring.util.response
  )
)

(defroutes index-routes
  (GET "/" []
    (redirect "/topics")
  )
)

(defroutes app-routes
  index-routes
  topic-routes
)

(defroutes app
  (->
    app-routes
    (wrap-params)
    (wrap-resource "META-INF/resources")
    (wrap-content-type)
    (wrap-not-modified)
  )
)
