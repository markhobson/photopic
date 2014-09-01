(ns photopic.resource.topic
  (:use
    photopic.support.clostache
    ring.util.response
  )
  (:require
    [photopic.repository.topic :as repository]
  )
)

(defn topics-response []
  (let [topics (repository/get-all)]
    (render-page "topics"
      {:topic topics :has-topics (boolean (not-empty topics))}
      [:head :navbar]
    )
  )
)

(defn topic-create-form-response []
  (render-page "topic-create"
    {:topic {}}
    [:head :navbar]
  )
)

(defn topic-create-response [topic]
  (repository/store topic)
  (redirect "/topics")
)

(defn topic-delete-response [id]
  (repository/delete id)
  (redirect "/topics")
)