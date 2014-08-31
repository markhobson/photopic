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

(def topics (atom [
  {:id (next-id) :name "Apple"}
  {:id (next-id) :name "Banana"}
  {:id (next-id) :name "Carrot"}
]))

(defn topics-response []
  (render-page "topics"
    {:topic @topics}
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
  (swap! topics
    (fn [topics]
      (conj topics (
        conj topic [:id (next-id)])
      )
    )
  )
  (redirect "/topics")
)