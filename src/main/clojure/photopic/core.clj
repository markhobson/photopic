(ns photopic.core
  (:use
    photopic.routes
    ring.adapter.jetty
  )
  (:gen-class)
)

(defn run []
  (defonce server
    (run-jetty #'app {:port 8080 :join? false})
  )
)

(defn -main [& args]
  (run-jetty app {:port 8080})
)
