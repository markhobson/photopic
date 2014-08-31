(ns photopic.topics
  (:use
    photopic.support.clostache
    ring.util.response
  )
)

(def id (atom 0))

(defn next-id []
  (swap! id inc)
)

(def topics (atom (sorted-map)))

(defn- topic-store [topic]
  (swap! topics
    assoc (get topic :id) topic
  )
)

(defn- topic-delete [id]
  (swap! topics
    dissoc id
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