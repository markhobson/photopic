(ns photopic.repository.topic)

(def id (atom 0))

(defn next-id []
  (swap! id inc)
)

(def topics (atom (sorted-map)))

(defn store [topic]
  (let [topic (conj topic [:id (next-id)])]
    (swap! topics
      assoc (get topic :id) topic
    )
  )
)

(defn delete [id]
  (swap! topics
    dissoc id
  )
)
