(ns photopic.route.topic
  (:use
    compojure.core
  )
  (:require
    [photopic.resource.topic :as resource]
  )
)

(defroutes router
  (context "/topics" []
    (GET "/" []
      (resource/get-all)
    )
    (POST "/" [name]
      (resource/create {:name name})
    )
    (GET "/create" []
      (resource/create-form)
    )
  )
  (context "/topic/:id" [id]
    (let [id (read-string id)]
      (DELETE "/" []
        (resource/delete id)
      )
    )
  )
)
