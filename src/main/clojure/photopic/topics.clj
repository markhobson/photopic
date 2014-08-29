(ns photopic.topics
  (:use
    photopic.support.clostache
    ring.util.response
  )
)

(def topics [
  {:name "Apple"}
  {:name "Banana"}
  {:name "Carrot"}
])

(defn topics-response []
  (render-page "topics"
    {:topic topics}
    [:head :navbar]
  )
)

(defn topic-create-form-response []
  (render-page "topic-create"
    {:topic {}}
    [:head :navbar]
  )
)

(defn topic-create-response []
  (redirect "/topics")
)