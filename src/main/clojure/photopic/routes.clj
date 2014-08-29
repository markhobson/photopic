(ns photopic.routes
  (:use
    compojure.core
    photopic.topics
    ring.middleware.content-type
    ring.middleware.resource
    ring.middleware.not-modified
    ring.util.response
  )
)

(defn index-response []
  (redirect "/topics")
)

(defroutes app-routes
  (GET "/" []
    (index-response)
  )
  (GET "/topics" []
    (topics-response)
  )
  (GET "/topics/create" []
    (topic-create-form-response)
  )
  (POST "/topics" []
    (topic-create-response)
  )
)

(defroutes app
  (->
    app-routes
    (wrap-resource "META-INF/resources")
    (wrap-content-type)
    (wrap-not-modified)
  )
)
