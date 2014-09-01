(ns photopic.core
  (:use
    photopic.route.app
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
