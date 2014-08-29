(ns photopic
  (:use
    clostache.parser
    compojure.core
    ring.adapter.jetty
    ring.util.response
  )
  (:gen-class)
)

(defn index-response []
  (redirect "/topics")
)

(defn topics-response []
  (render-resource "templates/topics.mustache" {:name "Photopic"})
)

(defroutes app
  (GET "/" []
    (index-response)
  )
  (GET "/topics" []
    (topics-response)
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
