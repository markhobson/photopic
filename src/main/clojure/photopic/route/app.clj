(ns photopic.route.app
  (:use
    compojure.core
    ring.middleware.content-type
    ring.middleware.params
    ring.middleware.resource
    ring.middleware.not-modified
  )
  (:require
    [photopic.route.index :as index]
    [photopic.route.topic :as topic]
  )
)

(defroutes app-routes
  index/router
  topic/router
)

(defroutes app
  (-> app-routes
    (wrap-params)
    (wrap-resource "META-INF/resources")
    (wrap-content-type)
    (wrap-not-modified)
  )
)
