(ns photopic.repository.topic)

(def ^:private id
  (atom 0)
)

(def ^:private topics
  (atom (sorted-map))
)

(defn- next-id []
  (swap! id inc)
)

(defn get-all []
  (vals @topics)
)

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
