(ns photopic
  (:use compojure.core ring.util.response ring.adapter.jetty)
  (:gen-class)
)

(defroutes app
  (GET "/" [] (resource-response "templates/index.html"))
)

(defn run []
  (defonce server
    (run-jetty #'app {:port 8080 :join? false})
  )
)

(defn -main [& args]
  (run-jetty app {:port 8080})
)
