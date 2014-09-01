(ns photopic.repository.topic)

(def id (atom 0))

(defn next-id []
  (swap! id inc)
)

(def topics (atom (sorted-map)))

(defn topic-store [topic]
  (swap! topics
    assoc (get topic :id) topic
  )
)

(defn topic-delete [id]
  (swap! topics
    dissoc id
  )
)
