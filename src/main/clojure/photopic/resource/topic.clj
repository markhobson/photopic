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
  (render-page "topics"
    {:topic (vals @repository/topics) :has-topics (not-empty @repository/topics)}
    [:head :navbar]
  )
)

(defn topic-create-form-response []
  (render-page "topic-create"
    {:topic {}}
    [:head :navbar]
  )
)

(defn topic-create-response [topic]
  (repository/store
    (conj topic [:id (repository/next-id)])
  )
  (redirect "/topics")
)

(defn topic-delete-response [id]
  (repository/delete id)
  (redirect "/topics")
)