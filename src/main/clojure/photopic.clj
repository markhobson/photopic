(ns photopic
  (:use
    compojure.core
    ring.adapter.jetty
    ring.util.response
  )
  (:gen-class)
)

(defroutes app
  (GET "/" []
    (resource-response "templates/index.html")
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
