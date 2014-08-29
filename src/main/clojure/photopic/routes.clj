(ns photopic.routes
  (:use
    clostache.parser
    compojure.core
    ring.middleware.content-type
    ring.middleware.resource
    ring.middleware.not-modified
    ring.util.response
  )
)

(defn index-response []
  (redirect "/topics")
)

(defn topics-response []
  (render-resource "templates/topics.mustache" {
    :topic [
      {:name "Apple"}
      {:name "Banana"}
      {:name "Carrot"}
    ]
  })
)

(defn topic-create-form-response []
  (render-resource "templates/topic-create.mustache" {
    :topic {}
  })
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
)

(defroutes app
  (->
    app-routes
    (wrap-resource "META-INF/resources")
    (wrap-content-type)
    (wrap-not-modified)
  )
)
