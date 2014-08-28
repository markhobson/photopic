(ns photopic
  (:use compojure.core ring.adapter.jetty)
  (:gen-class)
)

(defroutes app
  (GET "/" [] "<html><body><h1>Hello world!</h1></body></html>")
)

(defn run []
  (defonce server
    (run-jetty #'app {:port 8080 :join? false})
  )
)

(defn -main [& args]
  (run-jetty app {:port 8080})
)
