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
      (resource/topics-response)
    )
    (POST "/" [name]
      (resource/topic-create-response {:name name})
    )
    (GET "/create" []
      (resource/topic-create-form-response)
    )
  )
  (context "/topic/:id" [id]
    (let [id (read-string id)]
      (DELETE "/" []
        (resource/topic-delete-response id)
      )
    )
  )
)
