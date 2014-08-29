(ns photopic
  (:use
    clostache.parser
    compojure.core
    ring.adapter.jetty
    ring.middleware.resource
    ring.util.response
  )
  (:gen-class)
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

(defroutes app-routes
  (GET "/" []
    (index-response)
  )
  (GET "/topics" []
    (topics-response)
  )
)

(defroutes app
  (->
    app-routes
    (wrap-resource "META-INF/resources")
  )
)

(defn run []
  (defonce server
    (run-jetty #'app {:port 8080 :join? false})
  )
)

(defn -main [& args]
  (run-jetty app {:port 8080})
)
