(ns photopic.resource.topic
  (:use
    photopic.repository.topic
    photopic.support.clostache
    ring.util.response
  )
)

(defn topics-response []
  (render-page "topics"
    {:topic (vals @topics) :has-topics (not-empty @topics)}
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
  (topic-store
    (conj topic [:id (next-id)])
  )
  (redirect "/topics")
)

(defn topic-delete-response [id]
  (topic-delete id)
  (redirect "/topics")
)