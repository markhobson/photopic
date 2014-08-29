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
  (render-resource "templates/index.mustache" {:name "Photopic"})
)

(defroutes app
  (GET "/" []
    (index-response)
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
