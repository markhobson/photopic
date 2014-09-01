(ns photopic.route.topic
  (:use
    compojure.core
    photopic.resource.topic
  )
)

(defroutes router
  (context "/topics" []
    (GET "/" []
      (topics-response)
    )
    (POST "/" [name]
      (topic-create-response {:name name})
    )
    (GET "/create" []
      (topic-create-form-response)
    )
  )
  (context "/topic/:id" [id]
    (let [id (read-string id)]
      (DELETE "/" []
        (topic-delete-response id)
      )
    )
  )
)
