(ns photopic.repository.topic.memory)

(def ^:private id
  (atom 0)
)

(def ^:private topics
  (atom (sorted-map))
)

(defn- next-id []
  (swap! id inc)
)

(defn- set-next-id [topic]
  (conj topic [:id (next-id)])
)

(defn get-all []
  (vals @topics)
)

(defn store [topic]
  (let [topic (set-next-id topic)]
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
