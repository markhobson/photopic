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
  (context "/topics" []
    (GET "/" []
      (topics-response)
    )
    (POST "/" []
      (topic-create-response)
    )
    (GET "/create" []
      (topic-create-form-response)
    )
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
