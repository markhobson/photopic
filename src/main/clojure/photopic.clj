(ns photopic
  (:use
    clostache.parser
    compojure.core
    ring.adapter.jetty
    ring.util.response
  )
  (:gen-class)
)

(defroutes app
  (GET "/" []
    (render-resource "templates/index.mustache" {:name "Photopic"})
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
