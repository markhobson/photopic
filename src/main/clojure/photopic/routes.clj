(ns photopic.routes
  (:use
    compojure.core
    photopic.topics
    ring.middleware.content-type
    ring.middleware.params
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
    (POST "/" [name]
      (topic-create-response {:name name})
    )
    (GET "/create" []
      (topic-create-form-response)
    )
  )
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
